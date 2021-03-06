<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head_project.jsp"%>
<%--jqury+ajaxs 用样式解决页面跳转问题--%>
<script type="text/javascript">
    $(function(){

        //        新建
        $(".add_button").click(
            function ()
            {
                $("#addForm").attr("action","<%=basePath%>addProject");
                $("#addForm").submit();
            }
        );

//        编辑
        $(".edit_button").click(
            function ()
            {
                $("#editForm").attr("action","<%=basePath%>editProject");
                $("#userid").attr("value",$(this).parent().prevAll(".project_id_class").text());
                $("#editForm").submit();
            }
        );

//        删除
        $(".delete_button").click
        (
            function ()
            {
                if (confirm("确定要删除这个项目吗？"))
                {
                    $.ajax({
                        type: "POST",
                        url: "<%=basePath%>deleteProject",
                        data: {id: $(this).parent().prevAll(".project_id_class").text()},
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

    })
</script>

<div id="table_form_id" class="table_form_div">
<%--employee_manager主页内容--%>

    <%--编辑--%>
    <form id="editForm" method="post">
        <input type="hidden" id="userid" name="id" />
    </form>

    <%--附件--%>
    <form id="attachmentForm" method="post">
        <input type="hidden" id="attachment_id" name="attachment_name"/>
    </form>


    <div class="div_blank"></div>
    <%--新建项目--%>
    <form id="addForm" method="get">
        <div class="row">
            <div class="col-xs-6 col-md-4"></div>
            <div class="col-xs-6 col-md-4"></div>
            <div class="col-xs-6 col-md-4">
                <button class="add_button" style="background-color: rgba(0, 204, 102, .6);border-color: rgba(0, 204, 102, .9); color: #ffffff;
width: 100px; height: 35px; margin-left: 100px; margin-top: -16px;">新&nbsp;&nbsp;&nbsp;&nbsp;建</button>
            </div>
        </div>
    </form>

    <div class="div_blank"></div>

    <table class="table table-hover table-bordered">
        <thead id="userList">
        <tr style="background-color: rgba(242,242,242, .6);">
            <th>项目名</th>
            <th>项目地点</th>
            <th>用地面积</th>
            <th>建筑面积</th>
            <th>审核状态</th>
            <th>通过时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="project">
            <tr style="background-color: rgba(242,242,242, .4);">
                <th style="display:none" class="project_id_class">${project.id}</th>
                <th id="projectName">${project.projectName}</th>
                <th id="location">${project.location}</th>
                <th id="landArea">${project.landArea}</th>
                <th id="buildArea">${project.buildArea}</th>
                <th id="auditFlag">
                    <c:if test="${project.auditFlag == 0}">未送审</c:if>
                    <c:if test="${project.auditFlag == 1}">已送审</c:if>
                    <c:if test="${project.auditFlag == 2}">处理中</c:if>
                    <c:if test="${project.auditFlag == 3}">已通过</c:if>
                    <c:if test="${project.auditFlag == 4}">已退回</c:if>
                </th>
                <th id="successDate">
                    <fmt:formatDate value="${project.successDate}" type="both" dateStyle="long" />
                </th>
                <th><button class='btn btn-primary edit_button' type='submit'>编&nbsp;辑</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class='btn btn-primary delete_button' type='submit'>删&nbsp;除</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class='btn btn-primary attachment_button' data-toggle='modal' data-target='#attachment_modal'>附&nbsp;件</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${project.auditFlag == 0}">
                        <button class='btn btn-primary send' type='button' data-toggle='modal' data-target='#audit_modal'>送&nbsp;审</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${project.auditFlag == 4}">
                        <button class='btn btn-primary send' type='button' data-toggle='modal' data-target='#audit_modal'>重&nbsp;新&nbsp;送&nbsp;审</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                </th>
            </tr>
        </c:forEach>
        </thead>
    </table>

    <%--分页--%>
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
                        <a href="${pageContext.request.contextPath}/project_manager?pn=1">首页</a>
                    </li>
                    <!-- 如果还有前页就访问当前页码-1的页面， -->
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/project_manager?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                        <li ><a href="${pageContext.request.contextPath}/project_manager?pn=${page_Nums}">${page_Nums}</a></li>
                    </c:if>
                    </c:forEach>
                    </li>
                    <!-- 如果还有后页就访问当前页码+1的页面， -->
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/project_manager?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/project_manager?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>



    <!-- 附件模态框（Modal） -->
    <div class="modal fade" id="attachment_modal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">
                        附件管理
                    </h4>
                </div>
                <div class="modal-body" style=" max-height: 300px;overflow:auto;">
                    <table class="table table-hover table-bordered">
                        <thead id="content1">
                        <tr style="background-color:#EEEEEE;">
                            <th>选择</th>
                            <th>附件名</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <input type="hidden" id="ruleId"/>
                <div class="modal-footer">
                    <form action="upload" id="uploadForm" method="post" enctype="multipart/form-data">
                        <div class="col-xs-6 col-md-4">
                            <input type="button" class="btn btn-default" id="upload_button" value="上传附件" />
                            <input type="button" class="btn btn-default" id="delBtn" value="删除" />
                        </div>
                        <div class="col-xs-6 col-md-4"></div>
                        <div class="col-xs-6 col-md-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </form>

                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- 附件模态框（Modal） -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="audit_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabe2">
                        审批操作
                    </h4>
                </div>
                <form class="form-horizontal" name="sendForm" method="post" enctype='multipart/form-data' style="margin-top: 20px;">

                    <div class="control-group" style="font-size: 16px">
                        <label class="control-label" style="margin-left: 50px;color: #666666;">描述</label>
                        <div class="controls">
                            <textarea style="margin-left: 50px;width:500px; height:100px;" name="remark" id="remark"></textarea>
                        </div>
                    </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="subBtn" data-dismiss="modal">
                        送审
                    </button>
                    <button type="button" class="btn btn-default btn1"
                            data-dismiss="modal">关闭
                    </button>

                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>



    <%--工作区结束--%>

    <%--table_form_div--%>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax_upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/attachment.js"></script>

<%@include file="common/foot.jsp"%>