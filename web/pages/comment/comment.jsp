<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>留言</title>
	<link rel="stylesheet" id="templatecss" type="text/css" href="../../css/ys.css">
</head>
<body>
<div class="img">
	<form action="${pageContext.request.contextPath}/PostServlet" method="post" class="basic-grey">
		<label>
			<span>内容 :</span>
			<textarea id="message" name="message" placeholder="请输入内容"></textarea>

		</label>
		
		<label>
			<span>&nbsp;</span>
            <input type="submit" class="button" value="评论"/>
		</label>
	</form>
    <br>
	<c:forEach var="post" items="${pageInfo.list}">
	<div class="main">
		<p>用户名：${post.name}</p>
		<p>${post.postDate}</p>
		<span>${post.content}</span>
        <form action="${pageContext.request.contextPath}/RecommentServlet" method="post">
            <div class="recomm">
                <textarea id="recomm" name="recomm" placeholder="请输入评论"></textarea>
                <input type="submit"  class="button" value="评论">
                <input type="hidden"  name="postId" value="${post.postId}">
                    <%--<input type="submit" class="button" value="评论" href="/>--%>
                <%--<a href="${pageContext.request.contextPath}/RecommentServlet?recomm&postId=${post.postId}"><input type="button" value="评论"></a>--%>
            </div>
        </form>
        <c:forEach var="comment" items="${list}">
            <c:if test="${post.postId eq comment.com_postId}">
                <div class="usertext">
                    <a>${post.name}</a>
                    <span>${comment.comContent}</span>
                </div>
            </c:if>
        </c:forEach>
    </div>
        <br>
	</c:forEach>
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
</div>
</body>
</html>