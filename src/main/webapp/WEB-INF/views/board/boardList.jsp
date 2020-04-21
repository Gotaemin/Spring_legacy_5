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

		<form action="./${board}List" style="float: right;margin-top: 50px;">
			
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
					<option value="bt">Title</option>
					<option value="bc">Contents</option>
					<option value="bw">Writer</option>
				</select>
			</div>
		</form>

		<table class="table table-hover" style="margin-top: 50px;clear: right;">
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
						<td>
							<c:catch>
								<c:forEach begin="1" end="${list.depth}">
									--
								</c:forEach>
							</c:catch>
							<a href="./${board}Select?num=${list.num}">${list.title}</a>
						</td>
						<td>${list.writer}</td>
						<td>${list.regdate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div style="text-align: center;">
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"><</a>
					</li>
				</c:if>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">

					<li><a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>

				</c:forEach>

				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">></a></li>
				</c:if>

			</ul>
		</div>

<%-- 		<c:if test="${not empty memberVO}"> --%>
<%-- 			<c:if test="${board eq 'notice'}"> --%>
<%-- 				<c:if test="${memberVO.id eq 'admin'}"> --%>
<!-- 					<div> -->
<%-- 						<a href="./${board}Write" class="btn btn-primary">Write</a> --%>
<!-- 					</div> -->
<%-- 				</c:if> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${board eq 'qna'}"> --%>
<!-- 				<div> -->
<%-- 					<a href="./${board}Write" class="btn btn-primary">Write</a> --%>
<!-- 				</div> -->
<%-- 			</c:if> --%>
<%-- 		</c:if> --%>
		<c:catch>
			<c:choose>
			<c:when test="${board eq 'notice'}">
				<c:if test="${memberVO.id eq 'admin'}">
					<div>
						<a href="./${board}Write" class="btn btn-primary">Write</a>
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty memberVO}">
					<div>
						<a href="./${board}Write" class="btn btn-primary">Write</a>
					</div>
				</c:if>
			</c:otherwise>
		</c:choose>
		</c:catch>
		
		
	</div>








</body>
</html>