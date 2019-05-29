<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head_project.jsp"%>

<div id="table_form_id" class="table_form_div">
    <%--employee_manager主页内容--%>

    <div class="div_blank"></div>
    <div class="div_blank"></div>

    <form class="form-horizontal" action="saveProjectEdit" name="form1" method = "post" enctype='multipart/form-data'>
        <input type="hidden" id="userid" name="id" value="${user.id}"/>

        <div class="form-group">

            <label for="inputText1" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">项目名</label>
            <div class="col-sm-3">
                <input  name="projectName" value="${user.projectName}" type="text" class="form-control input-medium" id="inputText1"  >
            </div>

            <label for="inputText2" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">项目地点</label>
            <div class="col-sm-3">
                <input  name="location" value="${user.location}" type="text" class="form-control input-medium" id="inputText2"  >
            </div>

        </div>

        <div class="form-group">

            <label for="inputText3" class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">用地面积</label>
            <div class="col-sm-3">
                <input type="number" name="landArea" value="${user.landArea}" id="inputText3" class="form-control input-medium" >
            </div>

            <label for="inputText4" class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">建筑面积</label>
            <div class="col-sm-3">
                <input type="number" name="buildArea" value="${user.buildArea}" id="inputText4" class="form-control input-medium" >
            </div>

        </div>
        <div class="form-group">

            <label class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">层数</label>
            <div class="col-sm-3">
                <div class="btn-group">
                    <input type="number" name="floor" value="${user.floor}" id="inputText5" class="form-control input-medium"  >
                </div>
            </div>

            <label class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">审核状态</label>
            <div class="col-sm-3">
                <div class="btn-group">
                    <input type="number" name="auditFlag" value="${user.auditFlag}" id="inputText6" class="form-control input-medium" >
                </div>
            </div>

        </div>

        <%--<div class="form-group">--%>
            <%--<label class="col-sm-2 control-label"--%>
                   <%--style="color: #ffffff;font-size: 16px;">最后时间</label>--%>
            <%--<div class="col-sm-3">--%>
                <%--<fmt:formatDate value="${user.successDate}" type="date" pattern="yyyy-MM-dd" var="successDate"/>--%>
                <%--<input type="datetime-local" name="successDat" class="form-control input-medium" value="${successDate}" id="datetimepicker1">--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <label for="inputText10" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">环评人</label>
            <div class="col-sm-3">
                <input  name="eiaPeople" type="text" value="${user.eiaPeople}"class="form-control input-medium" id="inputText10" placeholder="eia_people" >
            </div>
            <label for="inputText12" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">许可证</label>
            <div class="col-sm-3">
                <input  name="permit" type="text" value="${user.permit}" class="form-control input-medium" id="inputText12" placeholder="permit" >
            </div>

        </div>


        <div class="form-group">
            <div class="col-sm-5"></div>
            <label class="col-sm-5 control-label">
                <button type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
            </label>
        </div>


    </form>


    <%--工作区结束--%>

    <%--table_form_div--%>
</div>


<%@include file="common/foot.jsp"%>