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
		<button id="btn2">BUTTON2</button>
		
		<script type="text/javascript">
			$("#btn").click(function() {

				$.get("./json/json1",function(data){
					//0.받아온 데이터가 String인지 Json Object인지 판별
					//console.log(result);  -> "name":"iu" (String)
					//						-> object (json object)
					
					//1.JSON Object로 변환
					//- String 이라면 jsonObject로 변환
					
// 					data = data.trim();
// 					data = JSON.parse(data);
					console.log(data);
					
					console.log(data[0].num);
					console.log(data[0].title);
					
				});
			});
			
			
			
			$("#btn2").click(function(){
				$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY",function(data){
					console.log(data);
					console.log(data[1]);
					console.log(data[1].rate);
				});
			});
		</script>
		
		
	</div>
	
	
	
	
	<% String enc = config.getInitParameter("enc"); %>

</body>
</html>