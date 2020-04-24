 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath }">Point Project</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
				</li>
				<li><a href="${pageContext.request.contextPath }/notice/noticeList">Notice</a></li>
				<li><a href="${pageContext.request.contextPath }/qna/qnaList">QNA</a></li>
				<li><a href="${pageContext.request.contextPath }/user/userList">Member</a></li>
				<li><a href="${pageContext.request.contextPath }/memo/memoList">Memo</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			
			<c:if test="${empty memberVO}">
				<li><a href="${pageContext.request.contextPath}/user/userJoin"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/user/userLogin"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</c:if>
			
			
			<c:if test="${not empty memberVO}">
				<li><a href="${pageContext.request.contextPath}/user/userPage?user=${user}"><span class="glyphicon glyphicon-user"></span>
						myPage</a></li>
				<li><a href="${pageContext.request.contextPath}/user/userLogout"><span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li>
			</c:if>
				
			
				
			</ul>
		</div>
	</nav>
