package com.service;

import com.model.Userlist;

public interface UserManager {
	public void save(Userlist transientInstance) throws Exception;
	public void delete(Userlist transientInstance)throws Exception;
}
