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
		request.setAttribute("MessageBean",MessageBean);//�������id��MessageBean��bean
		
		int result=userManager.query(new Userlist(userName,passWord));
		switch(result){
		case -1:
			MessageBean.setBackNews("��¼ʧ����Ŷ�������������ϸ��д�û���������Ŷ");
			return "complete";
		case -2:
			MessageBean.setBackNews("��¼ʧ����Ŷ����ȷ��������Ŷ����");
			return "complete";
		case 0:
			MessageBean.setBackNews("��¼ʧ����Ŷ�������ڸ��û�");
			return "complete";
		case 1:
			MessageBean.setBackNews("��¼�ɹ�");
			break;
		}
		//����������session�������Ϣ
		
		System.out.println(request.getCharacterEncoding());
		HttpSession session=request.getSession(true);
		Userlist userBean = (Userlist) session.getAttribute("userBean");
		if(userBean==null){
			System.out.println("��һ�ε�¼��������Ϣ");
			userBean=new Userlist();
			session.setAttribute("userBean", userBean);
		}
		else{
			System.out.println("���ǵ�һ�ε�¼"+userBean);
		}
		String name=userBean.getUsername();
		if(name==null){
			userBean.setUsername(userName);
		}
		else if(name.equals(userName)){
			System.out.println("�Ѿ���¼����");
		}
		else{
			userBean.setUsername(userName);
		}
		
//		Map<> session=ActionContext.getContext().getSession();
//		session.put("user.name", userName);
		System.out.println("��¼�ɹ�");
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
		//����������session�������Ϣ
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getCharacterEncoding());
		HttpSession session=request.getSession(true);
		
		Userlist userBean=(Userlist)session.getAttribute("userBean");
		if(userBean!=null){
			session.removeAttribute("userBean");
			session.invalidate();
			System.out.println("�˳��ɹ�");
		}
		else{
			System.out.println("δ��¼�������˳����˳��ɹ�");
		}
		
		return "success";
	}
	public String editUser(){
			logOut();
			HttpServletRequest request=ServletActionContext.getRequest();
			Message MessageBean=new Message();
			request.setAttribute("MessageBean",MessageBean);//�������id��MessageBean��bean
			
			if(!passWord.equals(passWord2) || passWord.equals("") ||passWord2.equals("") || passWord_old.equals(""))
			{
				MessageBean.setBackNews("����д����Ŷ������������Ҳ����һ��Ŷ");
				return "error";
			}
			System.out.println("�����û���Ϣ����д��Ϣ��ʽ���ɹ�");
			Userlist user=new Userlist(userName,passWord_old);
			
			int result=userManager.query(user);
			switch(result){
			case -1:
				MessageBean.setBackNews("�����������ϸ��д�û���������Ŷ");
				return "error";
			case -2:
				MessageBean.setBackNews("��ȷ��������Ŷ����");
				return "error";
			case 0:
				MessageBean.setBackNews("�����ڸ��û�");
				return "error";
			case 1://�ҵ���Ӧ�û�������ʵʩ�޸Ĳ���
				user.setUserpassword(passWord);
				System.out.println(user);
				if(!userManager.edit(user)){
					MessageBean.setBackNews("�����û���Ϣʧ��");
					return "error";
				}
				MessageBean.setBackNews("�����û���Ϣ�ɹ�");
				break;
			}
		return "success";
	}
	public String deleteUser(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		Message MessageBean=new Message();
		request.setAttribute("MessageBean",MessageBean);//�������id��MessageBean��bean
		HttpSession session=request.getSession(true);
		
		Userlist user=(Userlist)session.getAttribute("userBean");
		if(user!=null && user.getUsername()!=null){
			logOut();
			if(!userManager.delete(user)){
				MessageBean.setBackNews("ɾ���û���Ϣʧ��");
				return "error";
			}
			MessageBean.setBackNews("ɾ���û���Ϣ�ɹ�");
			return "success";
		}
		else{
			MessageBean.setBackNews("û�е�¼Ŷ�������¼����ִ��");
			return "error";
		}
	}
}
