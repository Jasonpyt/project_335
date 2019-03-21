<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="/test/print">打印1</a>
<a href="${pageContext.request.contextPath}/test/print">打印2</a>

<form action="${pageContext.request.contextPath}/test/print?age>10" method="post">
    <input type="text" name="age">
    <input type="submit">
</form>
</body>
</html>
