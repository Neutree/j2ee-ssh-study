package com.service;

import javax.jws.soap.SOAPBinding.Use;

import com.model.Userlist;
import com.model.UserlistDAO;

public class UserManagerImpl implements UserManager {

	private UserlistDAO userListDAO;
	public UserlistDAO getUserListDAO() {
		return userListDAO;
	}

	public void setUserListDAO(UserlistDAO userListDAO) {
		this.userListDAO = userListDAO;
	}

	@Override
	public boolean save(Userlist transientInstance)  {
		// TODO Auto-generated method stub
		try{
			userListDAO.save(transientInstance);
		}catch(Exception e){
			System.out.println(e+"...."+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Userlist transientInstance) {
		// TODO Auto-generated method stub
		try{
			userListDAO.delete(transientInstance);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean edit(Userlist transientInstance_new){
		try{
			userListDAO.merge(transientInstance_new);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public int query(Userlist user){
		try{
			Userlist a=new Userlist();
			a=userListDAO.findById(user.getUsername());
			System.out.println(a+"...");
			System.out.println(user+"....");
			if(a==null){
				System.out.println("��ѯʧ�ܣ������ڸ��û�");
				return 0;
			}
			if(user.getUserpassword().equals(a.getUserpassword()))
			{
				System.out.println("��ѯ�ɹ���");
				return 1;
			}
			else
			{
				System.out.println("�û����ڣ������������");
				return -1;
			}
		}catch(Exception e){
			System.out.println("�׳��쳣��"+e.getMessage());
			return -2;
		}
	}
	
}
