package com.model;

/**
 * Userlist entity. @author MyEclipse Persistence Tools
 */
public class Userlist extends AbstractUserlist implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Userlist() {
	}

	/** full constructor */
	public Userlist(String userpassword) {
		super(userpassword);
	}

	public Userlist(String userName, String passWord) {
		// TODO Auto-generated constructor stub
		this.setUsername(userName);
		this.setUserpassword(passWord);
	}

}
