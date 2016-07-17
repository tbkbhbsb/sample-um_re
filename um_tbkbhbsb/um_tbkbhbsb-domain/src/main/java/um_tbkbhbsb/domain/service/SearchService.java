package um_tbkbhbsb.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import um_tbkbhbsb.domain.Form.SearchForm;

public interface SearchService {
	
	Page<SearchForm> searchUser(SearchForm criteria, Pageable pageable);

}
