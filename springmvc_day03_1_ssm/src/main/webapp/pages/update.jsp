<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2019/1/10
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/account/update">
    <%--使用隐藏域隐藏id的值--%>
    <input type="hidden" name="id" value="${account.id}">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">账户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" value="${account.name}"
                   placeholder="请输入账户名">
        </div>
    </div>
    <div class="form-group">
        <label for="money" class="col-sm-2 control-label">金额</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="money" name="money" value="${account.money}"
                   placeholder="请输入金额">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">修改</button>
        </div>
    </div></form>
</body>
<!-- 引入JS文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</html>
