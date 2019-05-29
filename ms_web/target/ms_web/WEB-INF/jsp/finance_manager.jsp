<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head_finance.jsp"%>

<%--jqury+ajaxs 用样式解决页面跳转问题--%>
<script type="text/javascript">
    $(function(){

        //        新建
        $(".add_button").click(
            function ()
            {
                $("#addForm").attr("action","<%=basePath%>addEmployee");
                $("#addForm").submit();
            }
        );

//        编辑
        $(".edit_button").click(
            function ()
            {
                $("#editForm").attr("action","<%=basePath%>editEmployee");
                $("#userid").attr("value",$(this).parent().prevAll(".sid").text());
                $("#editForm").submit();
            }
        );

//        停用
        $(".delete_button").click
        (
            function ()
            {
                if (confirm("确定要停用该用户么？"))
                {
                    $.ajax({
                        type: "POST",
                        url: "<%=basePath%>deleteEmployee",
                        data: {id: $(this).parent().prevAll(".sid").text()},
                        async : false,
                        dataType: "json",
                        success: function (data){
                            alert("操作成功");
                            if(data=="success")
                                window.location.reload(true);
                        }
                    });
                }
            }
        );

//        部门分类
        $("#department1").change(function(){
            $("#selectById").attr("action","<%=basePath%>searchDepartment");
            $("#hi").attr("value",$("#department1").val());
            $("#selectById").submit();
        })
    })
</script>
<div id="table_form_id" class="table_form_div">
                            <%--employee_manager主页内容--%>

    <%--部门分类--%>
<form id="selectById"  method="get">
    <input type="hidden" id="hi" name="id">
</form>

    <%--编辑--%>
<form id="editForm" method="post">
    <input type="hidden" id="userid" name="id" />
</form>

                                <%--新增员工--%>
    <form id="addForm" method="get">
    <div class="row">
        <div class="col-xs-6 col-md-4"></div>
        <div class="col-xs-6 col-md-4"></div>
        <div class="col-xs-6 col-md-4">
            <button class="add_button" style="background-color: rgba(0, 204, 102, .6);border-color: rgba(0, 204, 102, .9); color: #ffffff;
width: 100px; height: 35px; margin-left: 100px; margin-top: -16px;">新&nbsp;&nbsp;&nbsp;&nbsp;增</button>
        </div>
    </div>
    </form>


<%--<form id="queryForm" action="<%=basePath %>searchEmployee" method="get">--%>
    <%--<div class="row">--%>
        <%--<div class="col-xs-6 col-md-4">--%>
            <%--<select class="form-control" data-style="btn-primary" name="deptId" id="department1"--%>
                    <%--style="width: 150px; height: 36px; margin-left: 30px;">--%>
                <%--<option value="-1">全部</option>--%>
                <%--<c:forEach items="${departments }" var="department" varStatus="i">--%>
                    <%--<option value="${department.id}" ${department.id==did?"selected":""} >${department.departmentName}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
        <%--</div>--%>
        <%--<div class="col-xs-6 col-md-4">--%>
            <%--<input class="form-control" type="text" placeholder="姓名" name="realName" style="width: 150px; height: 36px; margin-left: 30px; margin-top: -3px;"/>--%>
        <%--</div>--%>
        <%--<div class="col-xs-6 col-md-4">--%>

        <%--</div>--%>
    <%--</div>--%>
<%--</form>--%>

<div class="div_blank"></div>

<table class="table table-hover table-bordered">
    <thead id="userList">
    <tr style="background-color: rgba(242,242,242, .6);">
        <th>交易对象</th>
        <th>预付定金</th>
        <th>总金额</th>
        <th>付款状态</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${pageInfo.list}" var="employee">
        <tr style="background-color: rgba(242,242,242, .4);">
            <th style="display:none" class="sid">${employee.id}</th>
            <th id="payName">${employee.payName}</th>
            <th id="payAdvance">${employee.payAdvance}</th>
            <th id="payTotal">${employee.payTotal}</th>
            <th id="payState">
                <c:if test="${employee.payState == 0}">未预付</c:if>
                <c:if test="${employee.payState == 1}">已预付</c:if>
                <c:if test="${employee.payState == 2}">未付全款</c:if>
                <c:if test="${employee.payState == 3}">已付全款</c:if>
                <c:if test="${employee.payState == 4}">已退回</c:if>
            </th>
            <th><button class='btn btn-primary edit_button' type='submit'>付&nbsp;款</button>&nbsp;&nbsp;&nbsp;&nbsp;
                <button class='btn btn-primary delete_button' type='submit'>退&nbsp;款</button></th>
        </tr>
    </c:forEach>
    </thead>
</table>

<div class="row">
    <div class="col-xs-6 col-md-4" style="color: #ffffff; font-size: 16px;">
        当前&nbsp;${pageInfo.pageNum}&nbsp;页,共&nbsp;${pageInfo.pages }&nbsp;页,总&nbsp;${pageInfo.total }&nbsp;条记录
    </div>
    <div class="col-xs-6 col-md-4"></div>
    <div class="col-xs-6 col-md-4">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <!--
                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
                        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
                      -->
                <li>
                    <a href="${pageContext.request.contextPath}/employee_manager?pn=1">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/employee_manager?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <li>
                    <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                    <c:if test="${page_Nums==pageInfo.pageNum }">
                <li class="active"><a href="#">${page_Nums}</a></li>
                </c:if>
                <c:if test="${page_Nums!=pageInfo.pageNum }">
                    <li ><a href="${pageContext.request.contextPath}/employee_manager?pn=${page_Nums}">${page_Nums}</a></li>
                </c:if>
                </c:forEach>
                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/employee_manager?pn=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/employee_manager?pn=${pageInfo.pages}">末页</a></li>
            </ul>
        </nav>
    </div>
</div>



                                <%--工作区结束--%>

<%--table_form_div--%>
</div>


<%@include file="common/foot.jsp"%>