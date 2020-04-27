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
		
		<div id="result">
			<table class="table table-hover" style="margin-top: 50px;clear: right;">
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
							<td><input type="checkbox" name="del" class="ch" title="id${i.index}" id="id${i.index}"></td>
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
		</div>
		
		<div>
			<a href="./${member}Write" class="btn btn-primary">Write</a>
			<button style="float: right;" id="btn-del" class="btn btn-danger">DELETE</button>	
		</div>
	</div>

<script type="text/javascript">

	//chAll와 ch 체크버튼 연동
// 	$("#chAll").click(function(){
// 		var chAllstatus = $("#chAll").prop("checked");
// 		$(".ch").prop("checked",chAllstatus);
// 	});
	
	
	$("#result").on("click","#chAll",function(){
		var chAllstatus = $("#chAll").prop("checked");
		$(".ch").prop("checked",chAllstatus);
	});
	
	
	//ch중 하나라도 비어있을시 chAll에 체크 해제
// 	$(this).click(function() {
// 		var status = true;

// 		$(".ch").each(function() {
// 			chStatus = $(this).prop("checked");

// 			if (!chStatus) {
// 				status = false;
// 			}

// 		});
// 		$("#chAll").prop("checked", status);
// 	});
	
	
	$("#result").on("click",".ch",function(){
		var status = true;
		$(".ch").each(function() {
			chStatus = $(this).prop("checked");
			if (!chStatus) {
				status = false;
			}
		});
		$("#chAll").prop("checked", status);
	});
	
	
	
	
	//삭제버튼 클릭시 id값 읽어오기 
// 	$("#result").on("click","#btn-del",function(){
	$("#btn-del").click(function(){
		var ids = [];
		$(".ch").each(function(){
			if($(this).prop("checked")){
				var id = $(this).attr("title");
				ids.push($("#"+id).text());
			}
		});
		
		
		$.ajax({
			type:"get",
			url: "./userDeletes",
			traditional : true,
			data : { ids:ids },
			success: function(result){
				$.get("./userLists",function(result){
					$("#result").html(result);
					
				})
			}
			
		});
	});
	
	
	
</script>


</body>
</html>
























