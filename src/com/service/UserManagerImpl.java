package com.service;

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
	public void save(Userlist transientInstance) {
		// TODO Auto-generated method stub
		try{
			userListDAO.save(transientInstance);
		}catch(Exception e){
			System.out.println("����ʧ��");
			return ;
		}
		System.out.println("����ɹ�");
	}

	@Override
	public void delete(Userlist transientInstance) {
		// TODO Auto-generated method stub
		userListDAO.delete(transientInstance);
	}
	
	
}
