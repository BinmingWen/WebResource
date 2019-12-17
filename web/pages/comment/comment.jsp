<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>留言</title>
	<link rel="stylesheet" id="templatecss" type="text/css" href="../../css/ys.css">
    <link rel="stylesheet" href="../../css/index.css" />
    <link rel="stylesheet" href="../../css/index-middle.css" />
</head>
<body>
<jsp:include page="../../assert/headTwo.jsp"/>
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
		<span class="un" style="font-size: 20px;display: block;">${post.name}</span>
		<span class="un" style="font-size: 16px">${post.postDate}</span>
        <br>
        <c:if test="${post.isExcellent eq 1}">
            <span class="un" style="font-size: 20px">优</span>
            <br>
        </c:if>
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
                    <a>${comment.comName}</a>
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