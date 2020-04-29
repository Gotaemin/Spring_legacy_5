/**
 * 
 */


$('#contents').summernote({
	height:300,
	callbacks : {
		onImageUpload : function(files, editor) {

			var formData = new FormData(); //html의 폼태그와 같은 역할
			formData.append('files',files[0]); //<input type="file" name="">
			
			$.ajax({
				type:"post",
				url:"../boardFile/fileInsert",
				data:formData,
				enctype:"multipart/form-data",
				cache:false,
				contentType:false,
				processData:false,
				success:function(imageName){
					imageName = imageName.trim();
					console.log(imageName);
					$("#contents").summernote('editor.insertImage',imageName);
					
				}

			});

		},
		
		onMediaDelete:function(files){
			
			var fileName = $(files[0]).attr("src");
			fileName = fileName.substring(fileName.lastIndexOf("/"));
			console.log(fileName);
			
			$.ajax({
				type:"post",
				url:"../boardFile/summerDelete",
				data:{fileName:fileName},
				success:function(data){
					data = data.trim();
					console.log(data);
				}
			})
		}
		
	}
});



// 	var btn = document.getElementById("btn");
// 	btn.addEventListener("click",function(){
// 		alert('click');
// 	});

var count = 1;


$("#addfile").on("click",".remove", function() {
	$(this).parent().remove();
	count--;
});

	
$("#add").click(function() {
	if(count < 6){
		$("#addfile").append('<div class="all"><input name="files" class="form-control files" type="file"/><i class="glyphicon glyphicon-remove remove"></i></div>');
		count++;
	}else{
		alert("파일은 5개까지 가능합니다.")
	}

	$(".files").css("margin-top","10px");
	$(".files").css("width","930px");
	$("input").css("display","inline");
	$(".remove").css("cursor","pointer");



})



$("#btn").click(function() {
	//title,contents데이터 유무 검증

//	var contents = $("#contents").val();
//	contents = $("#contents").summernote('code');
//	console.log(title=="");
//	console.log(contents=="");
//	console.log(title.length > 0);
//	console.log(contents.length);
//	console.log($("#contents").summernote('isEmpty'));

	var title = $("#title").val();

	var ch1 = title!="";
	var ch2 = !$("#contents").summernote('isEmpty');
	var ch3 = true;
	$(".files").each(function(){
		if($(this).val()==""){
			ch3 = false;
		}
	});

	console.log(ch1)
	console.log(ch2)
	console.log(ch3)

	if(ch1 && ch2 && ch3){
		//submit이벤트 강제 발생
		$("#frm").submit();

	}else{
		alert("비어있는 항목이 존재합니다.");
	}

});

//$("#contents").summernote({
//	height: 400,
//	minHeight:400,
//	
//	callbacks:{
//		onImageUpload: function(files){
//			alert("upload");
////			$summernote.summernote('insertNode', imgNode);
//		}
//	}
//});























