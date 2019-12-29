<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/29
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>请先登录</title>
    <script type="text/javascript">
        function countDown(secs,surl){
            //alert(surl);
            var jumpTo = document.getElementById('jumpTo');
            jumpTo.innerHTML=secs;
            if(--secs>0){
                setTimeout("countDown("+secs+",'"+surl+"')",1000);
            }
            else
            {
                location.href=surl;
            }
        }
    </script>
</head>
<body><span id="jumpTo">5</span>秒后自动跳转到登录页面
<script type="text/javascript">
    countDown(5,'//localhost:8080/UserLoginServlet');
</script>
</body>
</html>

