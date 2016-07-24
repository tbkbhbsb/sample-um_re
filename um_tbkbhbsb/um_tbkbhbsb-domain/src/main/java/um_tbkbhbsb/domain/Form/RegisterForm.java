package um_tbkbhbsb.domain.Form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import um_tbkbhbsb.domain.validator.DateCheck;

public class RegisterForm implements Serializable{
	
private static final long serialVersionUID = 1L;

	@NotBlank
//	@Size(min=4, max=4)
	@Pattern(regexp = "[0-9]{4}")
	private String userId;
	
	@NotBlank
	@Size(min=1, max=50)
	private String name;
	
	@NotBlank
	@DateCheck
	private String birthday;
	
	@NotBlank
	@Size(min=1, max=100)
	private String address;
	
	@NotBlank
	@Size(min=1, max=15)
	@Pattern(regexp = "[0-9]{1,15}")
	private String tel;
	
	@NotBlank
	private String role;
	
//	@NotBlank
	private String state;
	
	@NotBlank
	@Size(min=8, max=24)
	private String password;
	
	@NotBlank
	@Size(min=8, max=24)
	private String passwordConfirm;
	
	
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
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "RegisterForm [userId=" + userId + ", name=" + name + ", birthday=" + birthday + ", address=" + address
				+ ", tel=" + tel + ", role=" + role + ", state=" + state + ", password=" + password
				+ ", passwordConfirm=" + passwordConfirm + "]";
	}

}
