<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="./template/boot.jsp"></c:import>

<title>Insert title here</title>
</head>
<body>
	<!-- 	BootStrapAPI_nav  -------------------------------------------------->
	
	<c:import url="./template/header.jsp"></c:import>
	
	<div class="container">
		<div class="jumbotron">
			<h1>Index page</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		
		<button id="btn">BUTTON</button>
		<script type="text/javascript">
			$("#btn").click(function() {
				//jQuery Ajax
				//GET방식일때
				alert("start");
				$.get("./notice/noticeSelect?num=143",function(result){
					console.log(result);
				});
				
				alert("finish");
			});
		</script>
		
		
	</div>
	
	
	
	
	<% String enc = config.getInitParameter("enc"); %>

</body>
</html>