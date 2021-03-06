<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form class="form-horizontal" action="./userJoin" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label class="control-label col-sm-2" for="id">ID:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="id" value="${id}"
							placeholder="Enter ID" name="id">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="pwd"
							placeholder="Enter Password" name="pwd">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Name:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name"
							placeholder="Enter Name" name="name">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email"
							placeholder="Enter Email" name="email">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="phone">Phone:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="phone"
							placeholder="Enter Phone" name="phone">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="age">Age:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="age"
							placeholder="Enter Age" name="age">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pic">Avatar:</label>
					<div class="col-sm-10">
						<input type="file" class="form-control" id="Avatar"
							placeholder="Enter Avatar" name="avatar">
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>

		</div>
	</div>

	<script type="text/javascript">
		// 	$("#id").blur(function() {
		// 		var id = $("#id").val();
		// 		if(id != ""){
		// 			$.post("./memberIdCheck",{id:id},function(result){
		// 				result = result.trim();
		// 				if(result == 0){
		// 					alert("이미 아이디가 존재합니다.");
		// 				}else{
		// 					alert("사용가능한 아이디 입니다.");
		// 				}
		// 			});
		// 		}else{
		// 			alert("아이디를 입력해주세요");
		// 		}
		// 	});
		
		
		$("#id").blur(function() {
			var id = $("#id").val();
			
			$.ajax({
				type: "post",	//method형식 지정
				url: "./memberIdCheck",	//URL경로 지정
				data: {id:id},	//Parameter 지정
				success: function(result){
					console.log(result);
					result = result.trim();
					if(result == 0){
						alert("이미 아이디가 존재합니다.");
					}else{
						alert("사용가능한 아이디 입니다.");
					}
				},
				error: function(){}
				
			});
		});
	</script>

</body>
</html>

























