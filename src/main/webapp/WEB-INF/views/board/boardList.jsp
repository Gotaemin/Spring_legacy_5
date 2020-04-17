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
		<table class="table table-hover">
			<thead>
				<tr>
					<th>num</th>
					<th>title</th>
					<th>writer</th>
					<th>date</th>
					<th>hit</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.num}</td>
						<td><a href="./${board}Select?num=${list.num}">${list.title}</a></td>
						<td>${list.writer}</td>
						<td>${list.regdate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<div>
			<a href="./${board}Write" class="btn btn-primary">Write</a>		
		</div>
</div>








</body>
</html>