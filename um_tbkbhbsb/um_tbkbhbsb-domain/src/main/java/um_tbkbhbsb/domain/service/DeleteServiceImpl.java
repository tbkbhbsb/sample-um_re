package um_tbkbhbsb.domain.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;
import um_tbkbhbsb.domain.repository.RoleTableRepository;
import um_tbkbhbsb.domain.repository.UserTableRepository;

@Service
public class DeleteServiceImpl implements DeleteService{
	
	@Inject
	UserTableRepository userTableRepository;
	
	@Inject
	RoleTableRepository roleTableRepository;

	@Override
	public void deleteOneUser(UserTable userTable, RoleTable roleTable) {
		
		Locale locale = Locale.getDefault();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale);
		String formattedDate = dateFormat.format(date);
		
		userTable.setLastUptate(formattedDate);
		
		userTable.setState("RMVD");
		
		
		
		userTableRepository.updateOneUser(userTable);
		roleTableRepository.updateOneUser(roleTable);
		
	}

}
