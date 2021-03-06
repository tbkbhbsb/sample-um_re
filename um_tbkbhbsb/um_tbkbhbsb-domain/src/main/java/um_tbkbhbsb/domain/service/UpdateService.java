package um_tbkbhbsb.domain.service;

import um_tbkbhbsb.domain.Form.PasswordUpdateForm;
import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;

public interface UpdateService {
	void updateOneUser(UserTable userTable, RoleTable roleTable);
	
	void updateOneUserPassword(PasswordUpdateForm passwordUpdateForm);
}
