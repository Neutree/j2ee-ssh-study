<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="userBean" class="com.model.Userlist" scope="session"/>
<jsp:useBean id="MessageBean" class="com.model.Message" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>User's page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<style type="text/css">
		div{
			
		}
		 input[type="submit"] {
		  font-size: 1em;
		  font-weight: 800;
		  color: white;
		  padding: 10px 10px;
		  width: 100%;
		  outline:none;
		  border: 0;
		  border-radius:5px;
		  background-color:#3B5998;
		  margin: 0.5em auto 0.5em auto;
		}
		input[type="submit"]:hover {
		  font-size: 1em;
		  font-weight: 800;
		  color: white;
		  padding: 10px 10px;
		  width: 100%;
		  outline:none;
		  border: 0;
		  cursor:pointer;
		  border-radius:5px;
		  background-color:#2098d1;
		  margin: 0.5em auto 0.5em auto;
		}
		.tickets_dis{
			background-color:white;
			width:900px;
			margin:30px auto;
			border-radius:20px;
			padding:50px;
		}
		#customers
		{
			font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
			width:100%;
			border-collapse:collapse;
			color:gray;
		}
		#customers td, #customers th 
		{
			font-size:1em;
			border:1px solid #98bf21;
			padding:3px 7px 2px 7px;
		}
		
		#customers th 
		{
			font-size:1.1em;
			text-align:left;
			padding-top:5px;
			padding-bottom:4px;
			background-color:#A7C942;
			color:#ffffff;
		}
		
		#customers tr.alt td 
		{
			color:#000000;
			background-color:#EAF2D3;
		}
	</style>
  </head>
  
  <body id="wrapper" class="login page_bg">
	<!-- start here-->	
	<!-- header -->
	<jsp:include page="header.html"/>
	<div >
		<h3 id="hint"></h3>
		<%
			if(userBean.getUsername()==null){//用户未登录
				out.print("<h2><strong>用户名:</strong>"+"游客"+"</h2>");
				out.print("<h2><strong>用户类型:</strong>"+"游客"+"</h2>");
				%><form action="login.jsp" method="post">
					<input type="submit" value="登录" class="transition8" />
				</form><%
			}
			else{//已经登录了
				out.print("<h2><strong>用户名:</strong>"+userBean.getUsername()+"</h2>");
				
				%><form action="logOut_user" method="post">
					<input type="submit" value="退出" class="transition8" />
				</form>
				<form action="./userEdit.jsp" method="post">
					<input type="submit" value="编辑个人信息" class="transition8" />
				</form>
				<form action="deleteUser_user" method="post">
					<input type="submit" value="删除个人信息（！！无法恢复）" class="transition8" />
				</form>
				<%
			}
			%>
			<div class="tickets_dis">
				<div><h2 style="color:red;"><jsp:getProperty property="backNews" name="MessageBean"/></h2></div>
				<div >
					<h1 style="color:gray;">我的购物车</h1>
				</div>
				<table id="customers">
					
					
				</table>
			</div>
			<div class="tickets_dis">
				<div >
					<h1 style="color:gray;">我的电影票</h1>
					<table id="customers">
					
					
				</table>
				</div>
			</div>
			
		<%
		%>
		
	</div>	
	<!-- footer -->
	<jsp:include page="footer.html"/>
	<!--end here-->
 </body>
</html>