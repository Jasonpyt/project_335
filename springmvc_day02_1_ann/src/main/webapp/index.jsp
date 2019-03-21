<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<form action="${pageContext.request.contextPath}/test/update" method="post">
    <input type="hidden" value="5">
    用户名:<input type="text" name="username">

    <input type="submit">
</form>
</body>
</html>
