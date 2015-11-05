package com.service;

import com.model.Userlist;

public interface UserManager {
	public void save(Userlist transientInstance);
	public void delete(Userlist transientInstance);
}
