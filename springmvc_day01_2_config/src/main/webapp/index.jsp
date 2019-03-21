<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

    <form action="${pageContext.request.contextPath}/user/testParam">
        <input type="text" name="username"><br>
        <input type="hidden" value="100" name="id"><br>
        <input type="text" name="price"><br>
        <%--复选框:checkbox--%><br>
        爱好：<input type="checkbox" name="array" value="chouyan"> 抽烟
            <input type="checkbox" name="array" value="hejiu"> 喝酒
            <input type="checkbox" name="array" value="tangtou"> 烫头
            <input type="checkbox" name="array" value="写代码"> 写代码<br>
        <%--映射list集合;元素的简单类型--%>
        <input type="text" name="list[0]">
        <input type="text" name="list[1]"><br>
        <%--映射list集： 元素为pojo类型--%>
        <%--第一个角色--%>
        <input type="text" name="roleList[0].id">
        <input type="text" name="roleList[0].roleName">
        <%--第二个角色--%><br>
        <input type="text" name="roleList[1].id">
        <input type="text" name="roleList[1].roleName"><br>
        <%--map集合--%>
        <input type="text" name="map[one]">
        <input type="text" name="map[two]"><br>
        <%--map集合映射pojo类型--%>
        <input type="text" name="roleMap[one].id">
        <input type="text" name="roleMap[one].roleName">
        <input type="text" name="roleMap[two].id">
        <input type="text" name="roleMap[two].roleName">
        <input type="submit">
    </form>
    <br>
    传递日期类型参数
    <%--传递日期类型参数--%>
    <form action="${pageContext.request.contextPath}/user/testParam">
        <input type="date" name="birthday">
        <input type="submit">
    </form>

    测试servletApi
    <form action="${pageContext.request.contextPath}/user/testServletApi">
        <input type="date" name="birthday">
        <input type="submit">
    </form>
</body>
</html>
