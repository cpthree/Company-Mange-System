<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head_admin.jsp"%>

<div id="table_form_id" class="table_form_div">
<%--employee_manager主页内容--%>

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
            <th>文件名</th>
            <th>发件人</th>
            <th>部门</th>
            <th>状态</th>
            <th>操作</th>
            <th>发文时间</th>

        </tr>
        <c:forEach items="${sendfiles}" var="sendfile">
            <tr style="background-color: rgba(242,242,242, .4);">
                <th style="display:none" class="sid">${sendfile.id}</th>
                <th id="file_name">${sendfile.fileName}</th>
                <th id="sender">${sendfile.sender}</th>
                <th id="department_id">${sendfile.department.departmentName}</th>
                <th id="state">已送审</th>
                <th><button class='btn btn-primary edit_button' type='submit'>编&nbsp;辑</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class='btn btn-primary delete_button' type='submit'>送&nbsp;审</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class='btn btn-primary delete_button' type='submit' data-toggle='modal' data-target='#sendfile_attachment'>附&nbsp;件</button></th>
                <th id="sendDate"><fmt:formatDate value="${sendfile.sendDate}" type="both"
                                               dateStyle="long" /></th>
            </tr>
        </c:forEach>
        </thead>
    </table>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="sendfile_attachment" tabindex="-1" role="dialog"
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
                            <input type="button" class="btn btn-default" id="button" value="上传附件" />
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

    <!-- 模态框（Modal） -->

    <%--工作区结束--%>

    <%--table_form_div--%>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajaxupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sendfile_modal.js"></script>

<%@include file="common/foot.jsp"%>