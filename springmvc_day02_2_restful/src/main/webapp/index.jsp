<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

    <%--测试get请求--%>
    <a href="${pageContext.request.contextPath}/user/user/1" >根据id查询</a>
    <%--测试post请求--%>
    <form action="${pageContext.request.contextPath}/user/user/1" method="post">
        <input type="submit" value="post请求">
    </form>
    <%--测试put请求--%>
    <form action="${pageContext.request.contextPath}/user/user/1" method="post">
        <%--指定请求方式为put请求
            注意：表单的请求方式必须是post
            put和delete请求的方法上必须标记@ResponseBody
        --%>
        <input name="_method" type="hidden" value="PUT">
        <input type="submit" value="put请求">
    </form>
    <%--测试Delete请求--%>
    <form action="${pageContext.request.contextPath}/user/user/1" method="post">
        <%--指定请求方式为put请求
            注意：表单的请求方式必须是post
            put和delete请求的方法上必须标记@ResponseBody
        --%>
        <input name="_method" type="hidden" value="DELETE">
        <input type="submit" value="delete请求">
    </form>
</body>
</html>
