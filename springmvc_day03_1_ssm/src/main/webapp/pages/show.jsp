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
<table class="table table-bordered">
    <caption>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/pages/save.jsp">添加</a>
    </caption>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>money</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%--c:foreach 循环标签
        items :要遍历的集合属性名
        var : 遍历中的每一集合元素
    --%>
        <c:forEach items="${accountList}" var="account">
            <tr>
                <td>${account.id}</td>
                <td>${account.name}</td>
                <td>${account.money}</td>
                <td>
                    <a class="btn btn-danger" href="javascript:delById(${account.id})">删除</a>
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/account/updateUI?id=${account.id}">修改</a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>

</body>
    <!-- 引入JS文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function delById(id){
            if(confirm("您确定要删除吗?")){
                location.href="${pageContext.request.contextPath}/account/delById?id="+id
            }
        }
    </script>
</html>
