package com.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.model.Message;
import com.model.Userlist;
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
	private String passWord_old;
	private String passWord2;
	private UserManager userManager;
	public UserManager getUserManager() {
		return userManager;
	}

	public String getPassWord_old() {
		return passWord_old;
	}

	public void setPassWord_old(String passWord_old) {
		this.passWord_old = passWord_old;
	}

	public String getPassWord2() {
		return passWord2;
	}

	public void setPassWord2(String passWord2) {
		this.passWord2 = passWord2;
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

	public String signIn()
	{
		System.out.println("signIn ... ...");
		HttpServletRequest request=ServletActionContext.getRequest();
		Message MessageBean=new Message();
		request.setAttribute("MessageBean",MessageBean);//将会更新id是MessageBean的bean
		
		int result=userManager.query(new Userlist(userName,passWord));
		switch(result){
		case -1:
			MessageBean.setBackNews("登录失败了哦！密码错误，请仔细填写用户名和密码哦");
			return "complete";
		case -2:
			MessageBean.setBackNews("登录失败了哦！请确保有网络哦！！");
			return "complete";
		case 0:
			MessageBean.setBackNews("登录失败了哦！不存在该用户");
			return "complete";
		case 1:
			MessageBean.setBackNews("登录成功");
			break;
		}
		//在这里设置session里面的信息
		
		System.out.println(request.getCharacterEncoding());
		HttpSession session=request.getSession(true);
		Userlist userBean = (Userlist) session.getAttribute("userBean");
		if(userBean==null){
			System.out.println("第一次登录，保存信息");
			userBean=new Userlist();
			session.setAttribute("userBean", userBean);
		}
		else{
			System.out.println("不是第一次登录"+userBean);
		}
		String name=userBean.getUsername();
		if(name==null){
			userBean.setUsername(userName);
		}
		else if(name.equals(userName)){
			System.out.println("已经登录过了");
		}
		else{
			userBean.setUsername(userName);
		}
		
//		Map<> session=ActionContext.getContext().getSession();
//		session.put("user.name", userName);
		System.out.println("登录成功");
		return "signInSuccess";
		
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
	
	public String logOut(){
		//在这里设置session里面的信息
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getCharacterEncoding());
		HttpSession session=request.getSession(true);
		
		Userlist userBean=(Userlist)session.getAttribute("userBean");
		if(userBean!=null){
			session.removeAttribute("userBean");
			session.invalidate();
			System.out.println("退出成功");
		}
		else{
			System.out.println("未登录，不用退出，退出成功");
		}
		
		return "success";
	}
	public String editUser(){
			logOut();
			HttpServletRequest request=ServletActionContext.getRequest();
			Message MessageBean=new Message();
			request.setAttribute("MessageBean",MessageBean);//将会更新id是MessageBean的bean
			
			if(!passWord.equals(passWord2) || passWord.equals("") ||passWord2.equals("") || passWord_old.equals(""))
			{
				MessageBean.setBackNews("请填写完整哦，两次新密码也必须一样哦");
				return "error";
			}
			System.out.println("更改用户信息：填写信息格式检查成功");
			Userlist user=new Userlist(userName,passWord_old);
			
			int result=userManager.query(user);
			switch(result){
			case -1:
				MessageBean.setBackNews("密码错误，请仔细填写用户名和密码哦");
				return "error";
			case -2:
				MessageBean.setBackNews("请确保有网络哦！！");
				return "error";
			case 0:
				MessageBean.setBackNews("不存在该用户");
				return "error";
			case 1://找到相应用户，可以实施修改操作
				user.setUserpassword(passWord);
				System.out.println(user);
				if(!userManager.edit(user)){
					MessageBean.setBackNews("更改用户信息失败");
					return "error";
				}
				MessageBean.setBackNews("更改用户信息成功");
				break;
			}
		return "success";
	}
	public String deleteUser(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		Message MessageBean=new Message();
		request.setAttribute("MessageBean",MessageBean);//将会更新id是MessageBean的bean
		HttpSession session=request.getSession(true);
		
		Userlist user=(Userlist)session.getAttribute("userBean");
		if(user!=null && user.getUsername()!=null){
			logOut();
			if(!userManager.delete(user)){
				MessageBean.setBackNews("删除用户信息失败");
				return "error";
			}
			MessageBean.setBackNews("删除用户信息成功");
			return "success";
		}
		else{
			MessageBean.setBackNews("没有登录哦！，请登录后再执行");
			return "error";
		}
	}
}
