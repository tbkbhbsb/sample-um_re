package um_tbkbhbsb.domain.service;

import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;

public interface DeleteService {
	void deleteOneUser(UserTable userTable, RoleTable roleTable);

}
