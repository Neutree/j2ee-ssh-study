package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hebernate.HibernateSessionFactory;
import com.model.Userlist;


public class Register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Register() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Userlist user = new Userlist();
		String username=request.getParameter("username").trim();//��ȡ�û���
		username=handleString(username);//���û���ת��Ϊ���ĸ�ʽ
		String password=request.getParameter("password").trim();//��ȡ����
		String confirmpassword=request.getParameter("confirmpassword").trim();//��ȡ����ȷ��ֵ
		if(!password.equals(confirmpassword))
		{
			response.setContentType("text/html");
			response.setContentType("text/html; charset=utf-8");   
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>���벻ͬ!<br></TITLE>");
			out.println("<meta http-equiv=\"Refresh\" content=\"5;url=index.jsp\" /></HEAD>");
			out.println("  <BODY>");
			out.println("�������벻��ͬ��5��󷵻�");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			return ;
		}
		user.setUsername(username);
		user.setUserpassword(password);
		int result=0;
		Session session=HibernateSessionFactory.getSession();
		if(!session.isConnected())
			result=-1;
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
		}catch(HibernateException e){
			if(!session.isConnected())
				result=-1;
			else
				result=2;
		}
		if (result!=-1&&result!=2)
			result=1;
		if(1==result)
		{//��ӳɹ�
			response.setContentType("text/html");
			response.setContentType("text/html; charset=utf-8");   
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("�����û��ɹ���      �û�����"+username+"  ���룺"+password);
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		else if(result==-1)
		{//���ݿ�����ʧ��
			response.setContentType("text/html");
			response.setContentType("text/html; charset=utf-8");   
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>Connect SQL failed!<br></TITLE>");
			out.println("<meta http-equiv=\"Refresh\" content=\"5;url=index.jsp\" /></HEAD>");
			out.println("  <BODY>");
			out.println("�������ݿ�ʧ�ܣ�5��󷵻�");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		else if(result==-2)
		{//�����û�ʧ�ܣ��û����Ѿ�����
			response.setContentType("text/html");
			response.setContentType("text/html; charset=utf-8");   
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>Connect SQL failed!<br></TITLE>");		
			out.println("<meta http-equiv=\"Refresh\" content=\"5;url=index.jsp\" /></HEAD>");
			out.println("  <BODY>");
			out.println("�û����Ѿ����� <br> �����û�ʧ�ܣ�����û�����5��󷵻�");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		else 
		{//�����Ĵ���
			switch(result)
			{
				//,....................
			}
		}


	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	public String handleString(String s){
		if (s==null)
			return new String("nocontent");
		try {
			s= new String(s.getBytes("iso-8859-1") , "utf-8" );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
