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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import um_tbkbhbsb.domain.Form.RegisterForm;
import um_tbkbhbsb.domain.Form.SearchForm;
import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;
import um_tbkbhbsb.domain.repository.RoleTableRepository;
import um_tbkbhbsb.domain.repository.UserTableRepository;
import um_tbkbhbsb.domain.service.SearchService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);
    
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
    

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "welcome/home";
    }
    
    
    @RequestMapping(value="/top", method = {RequestMethod.GET, RequestMethod.POST})
	public String menu() {
    	logger.info("Welcome top."
    			+ "on hello controller");
    	return "top/menu";
		
	}
    
    @RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        logger.info("Welcome login."
        		+ "on hello controller");

        return "login/loginForm";
    }
    
    
//    
//    Register処理
//    
    
    @RequestMapping(value="/user/register", params="form")
    public String registerForm(
    		@Validated RegisterForm form,
            BindingResult result,
            Model model) {
        logger.info("Welcome registerForm."
        		+ "on hello controller");
        
        model.addAttribute("RegisterForm", form);

        return "user/registerForm";
    }

    @RequestMapping(value="/user/register", params="confirm")
    public String registerConfirm(
    		@Validated RegisterForm form,
            BindingResult result,
            Model model) {
        logger.info("Welcome registerForm."
        		+ "on hello controller");
        
        model.addAttribute("RegisterForm", form);

        return "user/registerConfirm";
    }
    
    @RequestMapping(value="/user/register", params="finish")
    public String registerFinish(
    		@Validated RegisterForm form,
            BindingResult result,
            Model model,
            Locale locale) {
        logger.info("Welcome registerForm."
        		+ "on hello controller");
        
        model.addAttribute("RegisterForm", form);
        
        UserTable userTable = beenMapper.map(form, UserTable.class);
        RoleTable roleTable = beenMapper.map(form, RoleTable.class);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.SHORT, locale);

        String formattedDate = dateFormat.format(date);
        
        userTable.setLastUptate(formattedDate);
        userTable.setPassword(passwordEncoder.encode(userTable.getPassword()));
        
        logger.info(userTable.toString());
        logger.info(roleTable.toString());

        userTableRepository.createOneUser(userTable);
        roleTableRepository.createOneUser(roleTable);
        
        return "user/registerFinish";
    }
    
    
    
//  
//  Search処理
//  
  
  @RequestMapping(value="/user/search", params="form")
  public String searchForm(
  		@Validated SearchForm form,
          BindingResult result,
          Model model) {
      logger.info("Welcome searchForm."
      		+ "on hello controller");
      
      model.addAttribute("SearchForm", form);

      return "user/searchForm";
  }
  
  @RequestMapping(value="/user/search", params="finish")
  public String searchFinish(
  		@Validated SearchForm form,
          BindingResult result,
          @PageableDefault( // (1)
                  page = 0,    // (2)
                  size = 5,   // (3)
                  direction = Direction.DESC,  // (4)
                  sort = {     // (5)
                      "userId",
                      }
                  )
          Pageable pageable,
          Model model) {
	  
	  Page<SearchForm> page = searchService.searchUser(form, pageable);
      
//      model.addAttribute("SearchResult", users);
//      
//      UserTable userTable = beenMapper.map(form, UserTable.class);
//      RoleTable roleTable = beenMapper.map(form, RoleTable.class);
//      
//      logger.info(userTable.toString());
//      logger.info(roleTable.toString());

//      List<SearchForm> resultList = userTableRepository.searchUserByAndQuery(form);
//      List<RoleTable> roleTables = roleTableRepository.searchUserByOrQuery(roleTable);
      
//      for (UserTable userTable : userTables) {
//		logger.info(userTable.toString());
//	}
      
//      model.addAttribute("SearchResult", resultList);
      model.addAttribute("page", page);
      model.addAttribute("criteria", form);
      
      return "user/searchList";
  }
  
  @RequestMapping(value="/user/search")
  public String searchNextPage(
  		@Validated SearchForm form,
          BindingResult result,
          @PageableDefault( // (1)
                  page = 0,    // (2)
                  size = 5,   // (3)
                  direction = Direction.DESC,  // (4)
                  sort = {     // (5)
                      "userId",
                      }
                  )
          Pageable pageable,
          Model model) {
	  
	  Page<SearchForm> page = searchService.searchUser(form, pageable);
      
      model.addAttribute("page", page);
      model.addAttribute("criteria", form);
      
      return "user/searchList";
  }

}
