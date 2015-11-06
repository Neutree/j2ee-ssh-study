<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Twenty sign up</title>

	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="sign up page">
	
	<link href="assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="assets/css/font-awesome.min.css" rel='stylesheet' type='text/css' />

  </head>
  
<body class="login page_bg">
	<!--sign up form start here-->	
	<!-- header -->
	<jsp:include page="header.html"/>
	<h1>USER INFO EDIT</h1>
	<div class="login_">
		<form action="editUser_user" method="post" name="form">
			<input type="text" value="" name="userName"class="transition8" placeholder="用户名(长度10以内（包含10）)" autofocus="autofocus" />
			<br/><input type="password" name="passWord_old" class="transition8" value="" placeholder="密码   长度大于5（不包含5）小于10（包含10）" />
			<br/><input type="password" name="passWord" class="transition8" value="" placeholder="密码   长度大于5（不包含5）小于10（包含10）" />
			<br/><input type="password" name="passWord2" class="transition8" value="" placeholder="确认密码  长度大于5（不包含5）小于10（包含10）" />
			<br/><input type="submit" class="transition8" value="确认更改"/>
		</form>		
	</div>
	
	<!-- footer -->
	<jsp:include page="footer.html"/>
	<!--login form end here-->
</body>
</html>
