package um_tbkbhbsb.domain.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;
import um_tbkbhbsb.domain.repository.RoleTableRepository;
import um_tbkbhbsb.domain.repository.UserTableRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Inject
	PasswordEncoder passwordEncoder;
	
	@Inject
	UserTableRepository userTableRepository;
	
	@Inject
	RoleTableRepository roleTableRepository;

	@Override
	public void registerOneUser(UserTable userTable, RoleTable roleTable) {
		
		Locale locale = Locale.getDefault();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale);

		String formattedDate = dateFormat.format(date);

		userTable.setLastUptate(formattedDate);
		userTable.setPassword(passwordEncoder.encode(userTable.getPassword()));
		
		userTable.setState("INIT");

	
		userTableRepository.createOneUser(userTable);
		roleTableRepository.createOneUser(roleTable);
		
	}

	
}
