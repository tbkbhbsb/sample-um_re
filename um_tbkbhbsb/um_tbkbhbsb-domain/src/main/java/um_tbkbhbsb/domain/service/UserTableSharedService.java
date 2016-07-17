package um_tbkbhbsb.domain.service;

import um_tbkbhbsb.domain.model.UserTable;

public interface UserTableSharedService {

	UserTable findOneByUserId(String userId);

	void createOneUser(UserTable userTable);
}
