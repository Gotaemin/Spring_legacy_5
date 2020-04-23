<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<p>title : ${list.title}</p>
	<p>writer : ${list.writer }</p>
	<p>Contents : ${list.contents}</p>
</div>

<c:forEach var="file" items="${list.boardFileVOs}">
	<div>
		<a href="../boardFile/fileDown?fnum=${file.fnum}&board=${file.board}">${file.oriName}</a>
	</div>
</c:forEach>


<div>
	<a href="./${board}Update?num=${list.num}" class="btn btn-primary">Update</a>
	<a href="./${board}Delete?num=${list.num}" class="btn btn-danger">Delete</a>
	<c:if test="${board ne 'notice'}">
		<a href="./${board}Reply?num=${list.num}" class="btn btn-info">Reply</a>
	</c:if>
</div>

</body>
</html>