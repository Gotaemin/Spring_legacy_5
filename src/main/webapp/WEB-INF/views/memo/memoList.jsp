<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/boot.jsp"></c:import>
<title>Insert title here</title>

<style type="text/css">

#result{
	margin-top: 50px;
}
</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
		<div class="container">
		<div class="row">
			<h1>Memo</h1>
			<div class="form-group">
				<label for="writer">writer:</label> 
				<input type="text" class="form-control" id="writer">
			</div>
			<div class="form-group">
				<label for="contents">contents:</label>
				<textarea class="form-control" rows="5" id="contents"></textarea>
			</div>
			<button id="btn" class="btn btn-info">WRITE</button>
		</div>
		
		<div class="row">
			<table class="table" >
				<thead>
					<tr>
						<td>번호</td>
						<td>내용</td>
						<td>작성자</td>
						<td>날짜</td>	
					</tr>
				</thead>
				<tbody id="result">
				
				</tbody>
				
			</table>
		</div>
		
		<div id="more" class="btn btn-primary">더보기</div>
		
	</div>
	
	<script type="text/javascript">
		var count = 1;
	
		function getList(curPage){
			$.get("getList?curPage="+curPage,function(result){
				$("#result").append(result);
			});
		}
		
		function getList2(curPage){
			$.get("getList?curPage="+curPage,function(result){
				$("#result").html(result);
			});
		}
	
		getList(count);
		
		
		$("#more").click(function() {
			count++;
			getList(count);
		});
	
	
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			
			$("#writer").val("");
			$("#contents").val("");
			
			
			$.post("./memoInsert",{writer:writer,contents:contents},function(result){
				result = result.trim();
				
				if(result>0){
// 					count = 1;
// 					getList2(count);	
					location.reload();
				}else{
					alert("Warinng!!");
				}
			});
		});
	</script>
	
	
</body>
</html>
























