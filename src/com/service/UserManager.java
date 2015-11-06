package com.service;

import com.model.Userlist;

public interface UserManager {
	public boolean save(Userlist transientInstance) ;
	public boolean delete(Userlist transientInstance) ;
	public int query(Userlist transientInstance) ;
	public boolean edit(Userlist transientInstance_new);
}
