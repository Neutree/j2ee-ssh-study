<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Refresh" content="5;url=index.jsp" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="assets/css/font-awesome.min.css" rel='stylesheet' type='text/css' />
	<script type="text/javascript">
		var interval=setInterval(countTime,1000);
		var time_count=5;
		function countTime(){
			document.getElementById("hint").innerHTML="页面将在"+time_count+"秒后自动跳转回主页";
			--time_count;
		}
	</script>
  </head>
  
  <body class="login page_bg">
		<jsp:include page="header.html"/>
		<h1>成功了</h1> <br>
		<h3 id="hint"></h3>
		<!-- footer -->
		<jsp:include page="footer.html"/>
  </body>
</html>
