<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<form class="form-horizontal" action="${board}Update" method="post">
			<h3>${boardVO.num}</h3>
			<input type="hidden" name="num" value="${boardVO.num}">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">title:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title"placeholder="Enter title" name="title" value="${boardVO.title}">
				</div>
			</div>
				<div class="form-group">
				<label class="control-label col-sm-2" for="email">writer:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer"placeholder="Enter writer" name="writer" value="${boardVO.writer}">
				</div>
			</div>
				<div class="form-group">
				<label class="control-label col-sm-2" for="contents">contents:</label>
				<div class="col-sm-10">
					<textarea id="contents" class="form-control" rows="5" cols="80" name="contents" placeholder="Enter contents">${boardVO.contents}</textarea>
				</div>
			</div>
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>

<script type="text/javascript">
	$("#contents").summernote({
		height:400
	});
</script>

</body>
</html>