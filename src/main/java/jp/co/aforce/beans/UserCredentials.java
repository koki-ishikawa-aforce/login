package jp.co.aforce.beans;

import java.io.Serializable;

public class UserCredentials implements Serializable{
	private String passwordHash;
	private String salt;
	
	public UserCredentials(String passwordHash, String salt) {
		this.passwordHash = passwordHash;
		this.salt = salt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	
	
	
}
