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
		try {
			uM.save(new Userlist("À²À²À²", "hahaha"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
