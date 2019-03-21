<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

    <button  onclick="dianji()">点击</button>
</body>
    <%--引入js--%>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <%--ajax请求springMVC--%>
    <script type="text/javascript">
        function dianji(){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/testJson",
                data:{"username":"tianqi","age":18},
                type: "post",
                success:function(data){
                    //成功的回调函数
                    for (var i = 0; i < data.length; i ++){
                        alert(data[i].id);
                        alert(data[i].username);
                        alert(data[i].age);
                    }
                }
            });
        }
    </script>
</html>
