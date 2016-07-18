package um_tbkbhbsb.domain.Form;

import java.io.Serializable;

public class DeleteForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String name;
	private String birthday;
	private String address;
	private String tel;
	private String role;
	private String state;
	private String password;
	private String lastUpdate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
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

	@Override
	public String toString() {
		return "DeleteForm [userId=" + userId + ", name=" + name + ", birthday=" + birthday + ", address=" + address
				+ ", tel=" + tel + ", role=" + role + ", state=" + state + ", password=" + password + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
	
	

}
