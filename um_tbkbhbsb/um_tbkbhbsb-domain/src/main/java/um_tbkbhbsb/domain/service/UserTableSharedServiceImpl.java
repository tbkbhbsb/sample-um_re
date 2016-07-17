package um_tbkbhbsb.domain.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import um_tbkbhbsb.domain.model.UserTable;
import um_tbkbhbsb.domain.repository.UserTableRepository;

@Service
public class UserTableSharedServiceImpl implements UserTableSharedService{

	
	private static final Logger logger = LoggerFactory
            .getLogger(UserTableSharedServiceImpl.class);

	@Inject
	UserTableRepository userTableRepository;

	@Transactional(readOnly=true)
	@Override
	public UserTable findOneByUserId(String userId) {
		
		UserTable userTable = userTableRepository.findOneByUserId(userId);
		
		if (userTable == null) {
            throw new ResourceNotFoundException("The given user is not found! userId="
                    + userId);
		}
		
		return userTable;
		
	}

	@Transactional
	@Override
	public void createOneUser(UserTable userTable) {
		userTableRepository.createOneUser(userTable);
		logger.info("登録"
				+ userTable.toString());
		
	}
	
}
