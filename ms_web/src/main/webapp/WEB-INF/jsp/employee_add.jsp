<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head_employee.jsp"%>

<div id="table_form_id" class="table_form_div">
    <%--employee_manager主页内容--%>

        <div class="div_blank"></div>
        <div class="div_blank"></div>


        <form class="form-horizontal" action="saveEmployeeAdd" name="formAdd" method = "post" enctype='multipart/form-data'>

            <div class="form-group">
                <label for="inputText1" class="col-sm-2 control-label"
                       style="color: #ffffff; font-size: 16px;">姓名</label>
                <div class="col-sm-3">
                    <input  name="realName" type="text" class="form-control input-medium" id="inputText1" placeholder="name" nullmsg="请输入姓名！">
                </div>

                <label for="inputText2" class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">手机</label>
                <div class="col-sm-3">
                    <input type="number" name="telephone" id="inputText2" class="form-control input-medium"  placeholder="telephone" nullmsg="请输入手机号码！" errormsg="请输入手机号码！">
                </div>

            </div>

            <div class="form-group">
                <label for="inputText3" class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">登录名</label>
                <div class="col-sm-3">
                    <input type="text" name="loginName"  id="inputText3" class="form-control input-medium"   placeholder="username"  nullmsg="请输入用户名！" errormsg="用户名至少6个字符,最多18个字符！">
                </div>

                <label class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">部门</label>
                <div class="col-sm-3">
                    <div class="btn-group">
                        <select id="department_select" class="form-control" value="${user.departmentId}" data-style="btn-primary" name="departmentId" style="width: 136px">
                            <c:forEach items="${departments }" var="department" varStatus="i">
                                <option value="${department.id}" >${department.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>


            </div>

            <div class="form-group">

                <label for="inputPassword1" class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">密码</label>
                <div class="col-sm-3">
                    <input type="password" name="loginPassword"  id="inputPassword1" class="form-control input-medium"  placeholder="password"  nullmsg="请输入密码！" errormsg="密码至少6个字符,最多18个字符！" >
                </div>

                <label class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">角色</label>
                <div class="col-sm-3">
                    <div class="btn-group">
                        <select id="role_select" class="form-control" value="${user.roleId}" data-style="btn-primary" name="roleId"  style="width: 136px">
                            <c:forEach items="${roleSet }" var="role" varStatus="i">
                                <option value="${role.id}">${role.roleName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

            </div>

            <div class="form-group">

                <label class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">出生日期</label>
                <div class="col-sm-3">
                    <fmt:formatDate value="${user.birthDate}" type="date" pattern="yyyy-MM-dd" var="birthDate"/>
                    <input type="date" name="birthDat" class="form-control input-medium" value="${birthDate}" id="datetimepicker1">
                </div>

                <label class="col-sm-2 control-label"
                       style="color: #ffffff;font-size: 16px;">入职日期</label>
                <div class="col-sm-3">
                    <fmt:formatDate value="${user.entryDate}" type="date" pattern="yyyy-MM-dd" var="entryDate"/>
                    <input type="date" name="entryDat" class="form-control input-medium" value="${entryDate}" id="datetimepicker2" >
                </div>

            </div>

            <div class="form-group">
                <label for="inputText1" class="col-sm-2 control-label"
                       style="color: #ffffff; font-size: 16px;">性别</label>
                <div class="col-sm-3" style="color: #ffffff;font-size: 14px">
                    <label class="radio-inline">
                        <input type="radio" id="inlineCheckbox1" name="sexId" value="0"  datatype="*" nullmsg="请选择性别！" errormsg="请选择性别！" <c:if test="${user.sex == 0}">checked="checked"</c:if>>男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="inlineCheckbox2" name="sexId" value="1"  <c:if test="${user.sex == 1}">checked="checked"</c:if>>女
                    </label>
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