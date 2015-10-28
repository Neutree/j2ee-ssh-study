package com.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hebernate.HibernateSessionFactory;
import com.model.Userlist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("testing......\n");
		
//		Userlist user=new Userlist();
//		user.setUsername("¹þ¹þ¹þ¹þ");
//		user.setUserpassword("123456789");
//		System.out.println(user.getUsername()+"..."+user.getUserpassword());
		
		Userlist user2=new Userlist();
		user2.setUsername("À²À²..À²");
		user2.setUserpassword("123456789");
		
		
		Session session=HibernateSessionFactory.getSession();
//		SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
//		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("testing......\n");
	}

}
