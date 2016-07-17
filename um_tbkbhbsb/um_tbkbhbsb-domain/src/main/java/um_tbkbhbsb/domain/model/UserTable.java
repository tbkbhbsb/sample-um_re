package um_tbkbhbsb.domain.model;

import java.io.Serializable;

public class UserTable implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String name;
	private String birthday;
	private String address;
	private String tel;
	private String password;
	private String state;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLastUptate() {
		return lastUpdate;
	}

	public void setLastUptate(String lastUptate) {
		this.lastUpdate = lastUptate;
	}

	@Override
	public String toString() {
		return "UserTable [userId=" + userId + ", name=" + name + ", birthday=" + birthday + ", address=" + address
				+ ", tel=" + tel + ", password=" + password + ", state=" + state + ", lastUptate=" + lastUpdate + "]";
	}

}
