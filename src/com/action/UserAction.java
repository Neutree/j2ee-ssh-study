package com.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.model.UserlistDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserManager;

@Component("userSignUp")
@Scope("prototype")
public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1572209882148568525L;

	private String userName;
	private String passWord;
	
	private UserManager userManager;
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String save()
	{
		System.out.println("saving ... ...");
		return "success";
		
	}
	
	public String delete()
	{
		System.out.println("deleting ... ...");
		return "success";
		
	}
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(userName.equals("123"))
			return "success";
		else
			return "error";
	}
	
	
}
