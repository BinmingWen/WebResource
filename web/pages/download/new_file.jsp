<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>资源上传</title>
		<script type="text/javascript">
  var num=0;
  function addFile(event){
  //创建一个div标签，用以包含一个input标签和删除按钮
  var innerdiv = document.createElement("div");
   
  //创建一个input标签
  var inputNode = document.createElement("input");
  inputNode.name = "fileName";
  inputNode.type="file";
   
  //创建一个删除按钮
  var delNode = document.createElement("input");
  delNode.name = "del";
  delNode.type = "button";
  delNode.value="删除";
   
  var submit = document.getElementById("submit");
   
  //删除当前删除按钮所在的标签,为此按钮点击事件创建一个处理函数
  delNode.onclick = function d(){
  this.parentNode.parentNode.removeChild(this.parentNode); 
  var fileNodes = document.getElementsByName("fileName");
  //当没有上传文件时，隐藏submit按钮
  if(fileNodes.length==0){
  submit.style.display="none";
  }
  };
   
  innerdiv.appendChild(inputNode);
  innerdiv.appendChild(delNode);
   
  var div = document.getElementById("file");
  div.appendChild(innerdiv);
   
  submit.style.display="block";
   
  }
 </script>
 
 <link rel="stylesheet" href="../../css/index.css" />
 <link rel="stylesheet" href="../../css/index-middle.css" />
 
 <style>
	 .message {
		 width: 100%;
		 height: 600px;
		 background-color: #E6F2FF;
	 }
	 
		.message-center {
		position: absolute;
		left: 40%;
	}
	.user-button1 {
		background:red repeat 0px 0px; 
		width: 100px; 
		height: 30px; 
		border-radius: 10px;
		display: block;
		line-height:30px; /* 设置行高，将行高和高度设置同一个值，可以让单行文本垂直居中 */
		text-align:center; /* 居中对齐文字 */
		text-decoration:none; /* 去掉下划线 */
		color: #FFFFFF;
	}
	
	.user-button2 {
		background:lightblue repeat 0px 0px; 
		width: 100px; 
		height: 30px; 
		border-radius: 10px;
		display: block;
		line-height:30px; /* 设置行高，将行高和高度设置同一个值，可以让单行文本垂直居中 */
		text-align:center; /* 居中对齐文字 */
		text-decoration:none; /* 去掉下划线 */
		color: #FFFFFF;
	}
	
	.welcome {
		text-align: center;
		line-height: 30px;
	}
 </style>
	</head>
	<body>
		<nav class="navbar navbar-default nav-bar-width nav-bar-height">
				<div class="navbar-header"></div>
				<div class="access-statistics"></div>
					<ul id="menu">
						<li ><a href="">首页</a></li>
						<li ><a href="">文章</a></li>
						<li ><a href="">代码库</a></li>
						<li ><a href="">留言</a></li>
						<li ><a href="">分享</a></li>
						<li ><a href="">联系站长</a></li>
					</ul>
					<div class="navbar-header"></div>
				<div class="welcome">欢迎</div>
				<div class="navbar-header"></div>
				<div>
					<a href="" class="user-button2">
						<span>个人界面</span>
					</a>
				</div>
				<div>
					<a href="" class="user-button1">
						<span>退出</span>
					</a>
				</div>
			</nav>
		<div class="message">
			<div class="message-center">
			<h2>资源信息</h2>
			<form>
				<ul>
					<li>资源名称<input id="" maxlength="30" name="filename"/></li>
					<li>资源类型
					<select name="">
						<option value="S1">HTML</option>
						<option value="S2">C++</option>
						<option value="S3">JAVA</option>
					</select>
					</li>
					<li>资源描述</li>
					<textarea cols="40" rows="6" wrap="soft"></textarea>
				</ul>
			</form>
			<h2>资源文件</h2>
			<form id="upload" action="${pageContext.request.contextPath }/servlet/FileUploadServlet" enctype="multipart/form-data" method="post">
			上传文件:<input type="button" value="添加文件" onclick="addFile(this.parentNode)"/> <br />
				<table>
					<div id="file">
   
					</div>
				</table>
			<input id="submit" type="submit" value="提交" style="display: none"/>
			</form>
			</div>
		</div>
	</body>
</html>
