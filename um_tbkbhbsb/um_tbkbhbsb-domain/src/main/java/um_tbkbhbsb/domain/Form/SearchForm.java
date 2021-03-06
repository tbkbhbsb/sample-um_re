package um_tbkbhbsb.domain.Form;

import java.io.Serializable;

public class SearchForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String name;
	private String birthday;
	private String address;
	private String tel;
	private String role;
	private String state;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "SearchForm [userId=" + userId + ", name=" + name + ", birthday=" + birthday + ", address=" + address
				+ ", tel=" + tel + ", role=" + role + ", state=" + state + "]";
	}

}
