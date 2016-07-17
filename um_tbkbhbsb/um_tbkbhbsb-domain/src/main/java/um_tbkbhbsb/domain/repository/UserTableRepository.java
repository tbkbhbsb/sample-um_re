package um_tbkbhbsb.domain.repository;

import java.util.List;

import um_tbkbhbsb.domain.Form.SearchForm;
import um_tbkbhbsb.domain.model.UserTable;

public interface UserTableRepository {

	UserTable findOneByUserId(String userId);

	void createOneUser(UserTable userTable);

	List<SearchForm> searchUserByAndQuery(SearchForm searchForm);

}
