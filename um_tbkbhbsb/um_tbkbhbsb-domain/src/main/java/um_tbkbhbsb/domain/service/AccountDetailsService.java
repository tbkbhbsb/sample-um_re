package um_tbkbhbsb.domain.service;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import um_tbkbhbsb.domain.model.AccountDetails;
import um_tbkbhbsb.domain.model.RoleTable;
import um_tbkbhbsb.domain.model.UserTable;

@Service
public class AccountDetailsService implements UserDetailsService{
	
	@Inject
	UserTableSharedService userTableSharedService;
	
	@Inject
	RoleTableSharedService roleTableSharedService;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		try {
			UserTable userTable = userTableSharedService.findOneByUserId(userId);
			RoleTable roleTable = roleTableSharedService.findOneByUserId(userId);
			
			Collection<GrantedAuthority> authorities = null;
			
			if (roleTable.getRole().equals("ADMIN")) {
				authorities = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
			}else{
				authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
			}
			
			return new AccountDetails(userTable, authorities);
			
		} catch (ResourceNotFoundException e) {
			throw new UsernameNotFoundException("user not found", e);
		}
	}

}
