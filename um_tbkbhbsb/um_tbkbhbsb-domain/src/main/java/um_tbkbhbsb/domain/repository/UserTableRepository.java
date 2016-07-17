package um_tbkbhbsb.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;


import um_tbkbhbsb.domain.Form.SearchForm;
import um_tbkbhbsb.domain.model.UserTable;

public interface UserTableRepository {

	UserTable findOneByUserId(String userId);

	void createOneUser(UserTable userTable);

	List<SearchForm> searchUserByAndQuery(
			@Param("criteria") SearchForm searchForm,
            @Param("pageable") Pageable pageable);
	
	long countUserByAndQuery(
			@Param("criteria") SearchForm criteria);

}
