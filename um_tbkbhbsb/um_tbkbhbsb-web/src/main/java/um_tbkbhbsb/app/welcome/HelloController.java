package um_tbkbhbsb.app.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import um_tbkbhbsb.domain.Form.DeleteForm;
import um_tbkbhbsb.domain.Form.PasswordUpdateForm;
import um_tbkbhbsb.domain.Form.RegisterForm;
import um_tbkbhbsb.domain.Form.SearchForm;
import um_tbkbhbsb.domain.Form.UpdateForm;
import um_tbkbhbsb.domain.model.AccountDetails;
import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;
import um_tbkbhbsb.domain.repository.RoleTableRepository;
import um_tbkbhbsb.domain.repository.UserTableRepository;
import um_tbkbhbsb.domain.service.DeleteService;
import um_tbkbhbsb.domain.service.RegisterService;
import um_tbkbhbsb.domain.service.SearchService;
import um_tbkbhbsb.domain.service.UpdateService;
import um_tbkbhbsb.domain.validator.RegisterFormValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Inject
	Mapper beenMapper;

	@Inject
	PasswordEncoder passwordEncoder;

	@Inject
	UserTableRepository userTableRepository;

	@Inject
	RoleTableRepository roleTableRepository;

	@Inject
	SearchService searchService;

	@Inject
	UpdateService updateService;

	@Inject
	DeleteService deleteService;

	@Inject
	RegisterService registerService;

	@Inject
	RegisterFormValidator registerFormValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(registerFormValidator);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "welcome/home";
	}

	@RequestMapping(value = "/top", method = { RequestMethod.GET, RequestMethod.POST })
	public String menu(@AuthenticationPrincipal AccountDetails accountDetails, Model model) {
		logger.info("Welcome top." + "on hello controller");

		if (userTableRepository.findOneByUserId(accountDetails.getUsername()).getState().equals("INIT")) {
			PasswordUpdateForm form = new PasswordUpdateForm();
			form.setUserId(accountDetails.getUsername());
			model.addAttribute("PasswordUpdateForm", form);
			return "user/passchangeForm";
		}

		return "top/menu";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login() {
		logger.info("Welcome login." + "on hello controller");

		return "login/loginForm";
	}

	//
	// Register処理
	//

	@RequestMapping(value = "/user/register", params = "form")
	public String registerForm(@ModelAttribute("RegisterForm") RegisterForm form, Model model) {
		logger.info("Welcome registerForm." + "on hello controller");

		model.addAttribute("RegisterForm", form);

		return "user/registerForm";
	}

	@RequestMapping(value = "/user/register", params = "confirm")
	public String registerConfirm(@Validated @ModelAttribute("RegisterForm") RegisterForm form, BindingResult result,
			Model model) {
		logger.info("Welcome registerForm." + "on hello controller");

		if (result.hasErrors()) {
			logger.info("has errors");
			model.addAttribute("RegisterForm", form);
			return "user/registerForm";
		}

		model.addAttribute("RegisterForm", form);

		return "user/registerConfirm";
	}

	@RequestMapping(value = "/user/register", params = "finish")
	public String registerFinish(@Validated @ModelAttribute("RegisterForm") RegisterForm form, BindingResult result,
			Model model) {
		logger.info("Welcome registerForm." + "on hello controller");

		if (result.hasErrors()) {
			logger.info("has errors");
			// model.addAttribute("RegisterForm", form);
			return "user/registerForm";
		}

		// model.addAttribute("RegisterForm", form);

		UserTable userTable = beenMapper.map(form, UserTable.class);
		RoleTable roleTable = beenMapper.map(form, RoleTable.class);

		registerService.registerOneUser(userTable, roleTable);

		return "user/registerFinish";
	}

	//
	// Search処理
	//

	@RequestMapping(value = "/user/search", params = "form")
	public String searchForm(@Validated SearchForm form, BindingResult result, Model model) {
		logger.info("Welcome searchForm." + "on hello controller");

		model.addAttribute("SearchForm", form);

		return "user/searchForm";
	}

	@RequestMapping(value = "/user/search", params = "finish")
	public String searchFinish(@Validated SearchForm form, BindingResult result,
			@PageableDefault( // (1)
					page = 0, // (2)
					size = 5, // (3)
					direction = Direction.DESC, // (4)
					sort = { // (5)
							"userId", }) Pageable pageable,
			Model model) {

		Page<SearchForm> page = searchService.searchUser(form, pageable);

		model.addAttribute("page", page);
		model.addAttribute("criteria", form);

		return "user/searchList";
	}

	@RequestMapping(value = "/user/search")
	public String searchNextPage(@Validated SearchForm form, BindingResult result,
			@PageableDefault( // (1)
					page = 0, // (2)
					size = 5, // (3)
					direction = Direction.DESC, // (4)
					sort = { // (5)
							"userId", }) Pageable pageable,
			Model model) {

		Page<SearchForm> page = searchService.searchUser(form, pageable);

		model.addAttribute("page", page);
		model.addAttribute("criteria", form);

		return "user/searchList";
	}

	//
	// Update処理
	//

	@RequestMapping(value = "/user/update", params = "form")
	public String updateForm(@RequestParam("userId") String userId, Model model) {
		logger.info("Welcome updateForm." + "on hello controller");

		UserTable userInfo = userTableRepository.findOneByUserId(userId);
		RoleTable roleInfo = roleTableRepository.findOneByUserId(userId);

		UpdateForm updateForm = beenMapper.map(userInfo, UpdateForm.class);
		updateForm.setRole(roleInfo.getRole());

		model.addAttribute("UpdateForm", updateForm);

		logger.info(updateForm.toString());

		return "user/updateForm";
	}

	@RequestMapping(value = "/user/update", params = "confirm")
	public String updateConfirm(@Validated UpdateForm form, BindingResult result, Model model) {
		logger.info("Welcome updateConfirm." + "on hello controller");

		UserTable target = userTableRepository.findOneByUserId(form.getUserId());
		form.setState(target.getState());

		model.addAttribute("UpdateForm", form);

		logger.info(form.toString());

		return "user/updateConfirm";
	}

	@RequestMapping(value = "/user/update", params = "finish")
	public String UpdateFinish(@Validated UpdateForm form, BindingResult result, Model model, Locale locale) {
		logger.info("Welcome updateFinish." + "on hello controller");

		model.addAttribute("UpdateForm", form);

		UserTable userTable = beenMapper.map(form, UserTable.class);
		RoleTable roleTable = beenMapper.map(form, RoleTable.class);

		logger.info(userTable.toString());
		logger.info(roleTable.toString());

		updateService.updateOneUser(userTable, roleTable);

		return "user/updateFinish";
	}

	//
	// Delete処理
	//

	@RequestMapping(value = "/user/delete", params = "confirm")
	public String deleteConfirm(@RequestParam("userId") String userId, Model model) {

		logger.info("Welcome deleteConfirm." + "on hello controller");

		UserTable targetUser = userTableRepository.findOneByUserId(userId);
		DeleteForm form = beenMapper.map(targetUser, DeleteForm.class);
		form.setRole(roleTableRepository.findOneByUserId(userId).getRole());

		model.addAttribute("DeleteForm", form);

		return "user/deleteConfirm";
	}

	@RequestMapping(value = "/user/delete", params = "finish")
	public String deleteFinish(@Validated DeleteForm form, BindingResult result, Model model, Locale locale) {
		logger.info("Welcome deleteFinish." + "on hello controller");
		logger.info(form.toString());

		UserTable userTable = userTableRepository.findOneByUserId(form.getUserId());
		RoleTable roleTable = roleTableRepository.findOneByUserId(form.getUserId());

		logger.info(userTable.toString());
		logger.info(roleTable.toString());

		deleteService.deleteOneUser(userTable, roleTable);

		return "user/deleteFinish";
	}

	//
	// 初期パスワード変更
	//

	@RequestMapping(value = "/user/passChange", params = "finish")
	public String passchangeFinish(@Validated PasswordUpdateForm form, BindingResult result, Model model) {

		updateService.updateOneUserPassword(form);

		return "user/passChangeFinish";
	}

}
