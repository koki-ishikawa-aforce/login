package jp.co.aforce.beans;

import java.io.Serializable;

public class User implements Serializable{
	private int userNo;
	private String userId;
	private String password;
	private String registrationDate;

	public User() {

	}
	public User(int userNo, String userId, String password, String registrationDate) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
		this.registrationDate = registrationDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	

		
}
