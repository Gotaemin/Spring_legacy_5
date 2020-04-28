<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<h3>${boardVO.num}</h3>
		<h1>${fn:toUpperCase(board)} Update Form</h1>
	
		<form class="form-horizontal" action="${board}Update" method="post" enctype="multipart/form-data">
			
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
				<label class="control-label col-sm-2" for="files"></label>
				<div id="addfile" class="col-sm-10">
					<input type="button" id="add" class=" btn btn-info" value="AddFile">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="files">files:</label>
				<div  class="col-sm-10">
					<c:forEach var="fileVO" items="${boardVO.boardFileVOs}">
						<p>${fileVO.oriName}<i id="${fileVO.fnum}" title="${fileVO.board}" class="glyphicon glyphicon-remove remove fileDelete"></i></p>
					</c:forEach>
				</div>
				
			</div>
			
			
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>


<script type="text/javascript" src="../resources/js/boardForm.js"></script>

<script type="text/javascript">
	$("#contents").summernote({
		height:400
	});
	
	var size = ${boardVO.boardFileVOs.size()};
	size = ${fn:length(boardVO.boardFileVOs)};
	
 	
	count = count+size;
	
	$(".fileDelete").click(function(){
		
		var check = confirm("정말 삭제하시겠습니까?");
		if(check){
			var s = $(this);
			alert($(this).attr("id"));
			$.post("../boardFile/fileDelete",{fnum:$(this).attr("id"), board:$(this).attr("title")},function(result){
				
				console.log(s);
				
				if(result.trim() > 0){
					alert("success");
					s.parent().remove();
					count--;
				}else{
					alert("file delete fail");
				}
			});
		}
		
	});
	
</script>



</body>
</html>











