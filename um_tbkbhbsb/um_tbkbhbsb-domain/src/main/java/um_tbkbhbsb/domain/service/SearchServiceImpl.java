package um_tbkbhbsb.domain.service;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import um_tbkbhbsb.domain.Form.SearchForm;
import um_tbkbhbsb.domain.repository.UserTableRepository;

@Transactional
@Service
public class SearchServiceImpl implements SearchService{
	
	@Inject
	UserTableRepository userTableRepository;

	@Transactional(readOnly=true)
	@Override
	public Page<SearchForm> searchUser(
			SearchForm criteria, 
			Pageable pageable) {
		
		long total = userTableRepository.countUserByAndQuery(criteria);
		List<SearchForm> resultList;
		
		if (0 < total) {
			resultList = userTableRepository.searchUserByAndQuery(criteria, pageable);
		}else {
			resultList = Collections.emptyList();
		}
		
		return new PageImpl<>(resultList, pageable, total);

	}

}
