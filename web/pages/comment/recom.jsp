<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>回复帖子</title>
	<link rel="stylesheet" id="templatecss" type="text/css" href="../../css/ys.css">
</head>
<body>
	<form action="" method="post" class="basic-grey">	
		<label>
			<span>帖子评论 :</span>
			<textarea id="message" name="message" placeholder="评论内容"></textarea>
		</label>
		
		<label>
			<span>&nbsp;</span>
			<input type="button" class="button" value="Send" />
		</label>
	</form>
	<div class="main">	
		<p>用户名</p>
		<span>评论评论评论评论评论评论评论评论评论内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容</span>
    </div>
	<script>
		function changeStyle() {
	   var template = document.getElementById("template");
	   var index = template.selectedIndex;
	   var templatevalue = template.options[index].value;
	   var templatecss = document.getElementById("templatecss");
	   templatecss.setAttribute("href","css/" + templatevalue + ".css");
	   document.getElementsByTagName("form")[0].setAttribute("class",templatevalue);
	 }
	</script>
</body>
</html>