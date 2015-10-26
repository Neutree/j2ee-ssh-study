package com.model;

/**
 * AbstractUserlist entity provides the base persistence definition of the
 * Userlist entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserlist implements java.io.Serializable {

	// Fields

	private String username;
	private String userpassword;

	// Constructors

	/** default constructor */
	public AbstractUserlist() {
	}

	/** full constructor */
	public AbstractUserlist(String userpassword) {
		this.userpassword = userpassword;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

}