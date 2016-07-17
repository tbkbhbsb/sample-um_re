package um_tbkbhbsb.domain.model;

import java.io.Serializable;

public class RoleTable implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleTable [userId=" + userId + ", role=" + role + "]";
	}

}
