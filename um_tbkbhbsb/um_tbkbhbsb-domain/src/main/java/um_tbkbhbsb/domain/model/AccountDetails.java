package um_tbkbhbsb.domain.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AccountDetails extends User {
	
	private static final long serialVersionUID = 1L;

    private final UserTable userTable;

    
    public AccountDetails(UserTable userTable, Collection<GrantedAuthority> authorities ) {
    	super(userTable.getUserId(), userTable.getPassword(), authorities);
    	
        this.userTable = userTable;
    }

    public UserTable getUserTable() {
        return userTable;
    }

}
