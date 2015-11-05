package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.action.UserAction;
import com.model.Userlist;
import com.service.UserManager;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext ctx=new FileSystemXmlApplicationContext("src/applicationContext.xml");
		UserManager uM=(UserManager)ctx.getBean("userManage");
		uM.save(new Userlist("율율율율0", "hahaha"));

	}

}
