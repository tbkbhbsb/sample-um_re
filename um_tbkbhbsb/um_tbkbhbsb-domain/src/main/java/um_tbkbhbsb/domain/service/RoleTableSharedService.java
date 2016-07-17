package um_tbkbhbsb.domain.service;

import um_tbkbhbsb.domain.model.RoleTable;

public interface RoleTableSharedService {
	RoleTable findOneByUserId(String userId);

	void createOneUser(RoleTable roleTable);

}
