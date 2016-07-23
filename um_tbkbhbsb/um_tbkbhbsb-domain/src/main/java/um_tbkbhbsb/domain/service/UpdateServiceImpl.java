package um_tbkbhbsb.domain.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import um_tbkbhbsb.domain.Form.PasswordUpdateForm;
import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;
import um_tbkbhbsb.domain.repository.RoleTableRepository;
import um_tbkbhbsb.domain.repository.UserTableRepository;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Inject
	UserTableRepository userTableRepository;

	@Inject
	RoleTableRepository roleTableRepository;

	@Inject
	PasswordEncoder passwordEncoder;

	@Override
	public void updateOneUser(UserTable userTable, RoleTable roleTable) {

		UserTable targetUser = userTableRepository.findOneByUserId(userTable.getUserId());

		Locale locale = Locale.getDefault();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale);
		String formattedDate = dateFormat.format(date);

		userTable.setLastUptate(formattedDate);

		if (userTable.getPassword().isEmpty()) {
			userTable.setPassword(targetUser.getPassword());
			System.out.println("pass no change");
		} else {
			userTable.setPassword(passwordEncoder.encode(userTable.getPassword()));
			System.out.println("pass change");
		}

		userTableRepository.updateOneUser(userTable);
		roleTableRepository.updateOneUser(roleTable);
	}

	@Override
	public void updateOneUserPassword(PasswordUpdateForm passwordUpdateForm) {

		UserTable targetUser = userTableRepository.findOneByUserId(passwordUpdateForm.getUserId());

		Locale locale = Locale.getDefault();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale);
		String formattedDate = dateFormat.format(date);

		targetUser.setPassword(passwordEncoder.encode(passwordUpdateForm.getPassword()));
		targetUser.setState("ACTV");
		targetUser.setLastUptate(formattedDate);

		userTableRepository.updateOneUser(targetUser);

	}

}
