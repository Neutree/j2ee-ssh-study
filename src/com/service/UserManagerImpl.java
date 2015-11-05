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
	public void save(Userlist transientInstance) throws Exception{
		// TODO Auto-generated method stub
			userListDAO.save(transientInstance);
	}

	@Override
	public void delete(Userlist transientInstance) throws Exception{
		// TODO Auto-generated method stub
		userListDAO.delete(transientInstance);
	}
	
	
}
