<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="box-footer">
    <div class="pull-left">
        <div class="form-group form-inline">
            总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页
            <select class="form-control" onchange="gotoPage(1)" id="pageSize">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select> 条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li><a href="javascript:gotoPage(1)" aria-label="Previous">首页</a></li>
            <li><a href="javascript:gotoPage(${pageInfo.prePage})">上一页</a></li>
            <c:forEach begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}" var="i">
                <li><a href="javascript:gotoPage(${i})">${i}</a></li>
            </c:forEach>
            <li><a href="javascript:gotoPage(${pageInfo.nextPage})">下一页</a></li>
            <li><a href="javascript:gotoPage(${pageInfo.pages})" aria-label="Next">尾页</a></li>
        </ul>
    </div>

</div>

<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    $("#pageSize option[value=${pageInfo.pageSize}]").prop("selected","selected");

    function gotoPage(pageNum){
        if( pageNum < 1){
            return ;
        }
        if( pageNum > ${pageInfo.pages}){
            return ;
        }
        var pageSize = $("#pageSize").val();
        location.href='${pageContext.request.contextPath}/<%=url%>/findAll?pageNum='+ pageNum+"&pageSize="+pageSize;
    }
</script>


