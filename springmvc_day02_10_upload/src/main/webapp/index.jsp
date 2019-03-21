<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--
    上传文件的表单的前提
        文件上传的表单必须是post提交方式
         表单enctype： multipart/form-data
         表单中必须有一个file表单属性
--%>
<form action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="upload">
    <input type="text" name="username">
    <input type="submit">
</form>

</body>

</html>
