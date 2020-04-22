<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<div class="row">
	
		<h1>Id : ${sessionScope.memberVO.id}</h1>
		<h1>Name : ${memberVO.name}</h1>
		<h1>Email : ${memberVO.email}</h1>
		<h1>Phone : ${memberVO.phone}</h1>
		<div><a href="./fileDelete?id=${sessionScope.memberVO.id}">FileDelete</a> </div>
		<h1><img alt="" src="../resources/memberUpload/${file.fileName}"> </h1>
		<button class="btn btn-primary" id="update">Update</button>
		<button class="btn btn-danger" id="del">Delete</button>
	</div>

</div>
<script type="text/javascript">
	//js  document.getElementById
	//js  document.querySelector
	//jquery $(선택자)
	$("#update").on("click", function() {
		location.href="./memberUpdate";
	});
	
	$("#del").click(function() {
		var result = confirm("탈퇴 할거냐???");
		if(result){
			location.href="./memberDelete";	
		}
		
	});

</script>
</body>
</html>



