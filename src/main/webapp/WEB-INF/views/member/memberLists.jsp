<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover" style="margin-top: 50px; clear: right;">
	<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>phone</th>
			<th>email</th>
			<th style="width: 50px;"><input type="checkbox" id="chAll"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${list}" varStatus="i">
			<tr>
				<td id="id${i.index}">${list.id}</td>
				<td>${list.name}</td>
				<td>${list.phone}</td>
				<td>${list.email}</td>
				<td><input type="checkbox" name="del" class="ch"
					title="id${i.index}" id="id${i.index}"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div style="text-align: center;">
	<ul class="pagination">
		<c:if test="${pager.curBlock gt 1}">
			<li><a
				href="./${member}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"><</a>
			</li>
		</c:if>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">

			<li><a
				href="./${member}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>

		</c:forEach>

		<c:if test="${pager.curBlock lt pager.totalBlock}">
			<li><a
				href="./${member}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">></a></li>
		</c:if>

	</ul>
</div>