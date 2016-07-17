package um_tbkbhbsb.domain.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.repository.RoleTableRepository;

@Service
public class RoleTableSharedServiceImpl implements RoleTableSharedService {
	@Inject
	RoleTableRepository roleTableRepository;

	@Transactional(readOnly = true)
	@Override
	public RoleTable findOneByUserId(String userId) {

		RoleTable roleTable = roleTableRepository.findOneByUserId(userId);

		if (roleTable == null) {
			throw new ResourceNotFoundException("The given user is not found! userId=" + userId);
		}

		return roleTable;
	}

	@Override
	public void createOneUser(RoleTable roleTable) {
		roleTableRepository.createOneUser(roleTable);

	}

}
