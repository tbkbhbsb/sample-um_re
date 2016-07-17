package um_tbkbhbsb.domain.repository;

import java.util.List;

import um_tbkbhbsb.domain.model.RoleTable;

public interface RoleTableRepository {

	RoleTable findOneByUserId(String userId);

	void createOneUser(RoleTable roleTable);

	List<RoleTable> searchUserByOrQuery(RoleTable roleTable);

}
