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

		<form action="./${member}List" style="float: right;margin-top: 50px;">
			
			<div class="input-group col-xs-3" style="float: right;">
				<input type="text" class="form-control" placeholder="Search" name="search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
			<div class="form-group col-xs-2" style="float: right;">
				<select class="form-control" id="sel1" name="kind" >
					<option value="mid">id</option>
					<option value="mname">name</option>
					<option value="mphone">phone</option>
					<option value="memail">email</option>
				</select>
			</div>
		</form>

		<table class="table table-hover" style="margin-top: 50px;clear: right;">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>phone</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>${list.phone}</td>
						<td>${list.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div style="text-align: center;">
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a href="./${member}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"><</a>
					</li>
				</c:if>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">

					<li><a href="./${member}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>

				</c:forEach>

				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./${member}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">></a></li>
				</c:if>

			</ul>
		</div>


		<div>
			<a href="./${member}Write" class="btn btn-primary">Write</a>
		</div>
	</div>








</body>
</html>