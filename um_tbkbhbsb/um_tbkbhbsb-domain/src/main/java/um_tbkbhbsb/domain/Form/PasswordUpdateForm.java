package um_tbkbhbsb.domain.Form;

import java.io.Serializable;

public class PasswordUpdateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String state;
	private String password;
	private String passwordConfirm;
	private String lastUpdate;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "PasswordUpdateForm [userId=" + userId + ", state=" + state + ", password=" + password
				+ ", passwordConfirm=" + passwordConfirm + ", lastUpdate=" + lastUpdate + "]";
	}

}
