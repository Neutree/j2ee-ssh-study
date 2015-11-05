package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Userlist;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserManager;
import com.service.UserManagerImpl;

public class UserSignUpAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2997250919777519138L;
	private String userName;
	private String passWord;
	private String passWord2;
	
	private UserManagerImpl userManamger;
	
	
	public UserManagerImpl getUserManamger() {
		return userManamger;
	}
	public void setUserManamger(UserManagerImpl userManamger) {
		this.userManamger = userManamger;
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
	public String getPassWord2() {
		return passWord2;
	}
	public void setPassWord2(String passWord2) {
		this.passWord2 = passWord2;
	}
	
	@Override
	public String execute() throws Exception {
	

	 if(passWord.equals(passWord2)&&!passWord.equals(""))
	 	{
			 try{
				 userManamger.save(new Userlist(userName, passWord));
			 }catch(Exception e)
			 {
				 return "error";
			 }			
			 return "success";
	 	}
	 else
		 return "error";
	}
	
}
