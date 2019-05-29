<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head_project.jsp"%>

<div id="table_form_id" class="table_form_div">
    <%--employee_manager主页内容--%>

    <div class="div_blank"></div>
    <div class="div_blank"></div>

    <form class="form-horizontal" action="saveProjectAdd" name="form1" method = "post" enctype='multipart/form-data'>

        <div class="form-group">

            <label for="inputText1" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">项目名</label>
            <div class="col-sm-3">
                <input  name="projectName" type="text" class="form-control input-medium" id="inputText1" placeholder="ProjectName" >
            </div>

            <label for="inputText2" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">项目地点</label>
            <div class="col-sm-3">
                <input  name="location" type="text" class="form-control input-medium" id="inputText2" placeholder="location" >
            </div>

        </div>

        <div class="form-group">

            <label for="inputText3" class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">用地面积</label>
            <div class="col-sm-3">
                <input type="number" name="landArea" id="inputText3" class="form-control input-medium"  placeholder="landArea" >
            </div>

            <label for="inputText4" class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">建筑面积</label>
            <div class="col-sm-3">
                <input type="number" name="buildArea" id="inputText4" class="form-control input-medium"   placeholder="buildingArea"  >
            </div>

        </div>
        <div class="form-group">

            <label class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">层数</label>
            <div class="col-sm-3">
                <div class="btn-group">
                    <input type="number" name="floor" id="inputText5" class="form-control input-medium"   placeholder="floor"  >
                </div>
            </div>

            <label class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">状态</label>
            <div class="col-sm-3">
                <div class="btn-group">
                    <input type="number" name="auditFlag" id="inputText6" class="form-control input-medium"   placeholder="audit_flag"  >
                </div>
            </div>

        </div>


        <div class="form-group">
            <label for="inputText10" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">环评人</label>
            <div class="col-sm-3">
                <input  name="eiaPeople" type="text" class="form-control input-medium" id="inputText10" placeholder="eia_people" >
            </div>
            <label for="inputText12" class="col-sm-2 control-label"
                   style="color: #ffffff; font-size: 16px;">许可证</label>
            <div class="col-sm-3">
                <input  name="permit" type="text" class="form-control input-medium" id="inputText12" placeholder="permit" >
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-2 control-label"
                   style="color: #ffffff;font-size: 16px;">通过时间</label>
            <div class="col-sm-3">
                <!-- 格式化日期 -->
                <fmt:formatDate value="${user.successDate}" type="both" dateStyle="long" var="successDate"/>
                <input type="text" name="successDate" class="form-control input-medium" value="${successDate}" id="successDate" disabled>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-5"></div>
            <label class="col-sm-5 control-label">
                <button type="submit" class="btn btn-primary">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
            </label>
        </div>

    </form>


        <script type="text/javascript">
            $(document).ready(function(){

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
                Date.prototype.Format = function(fmt)
                { //author: meizz
                    var o = {
                        "M+" : this.getMonth()+1,                 //月份
                        "d+" : this.getDate(),                    //日
                        "h+" : this.getHours(),                   //小时
                        "m+" : this.getMinutes(),                 //分
                        "s+" : this.getSeconds(),                 //秒
                        "q+" : Math.floor((this.getMonth()+3)/3), //季度
                        "S"  : this.getMilliseconds()             //毫秒
                    };
                    if(/(y+)/.test(fmt))
                        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
                    for(var k in o)
                        if(new RegExp("("+ k +")").test(fmt))
                            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
                    return fmt;
                }


                $("#successDate ").val(new Date().Format("yyyy/MM/dd hh:mm:ss"))
            })
        </script>


    <%--工作区结束--%>

    <%--table_form_div--%>
</div>


<%@include file="common/foot.jsp"%>