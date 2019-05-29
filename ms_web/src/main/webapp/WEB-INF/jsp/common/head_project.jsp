<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <!-- Bootstrap core CSS -->
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../resources/js/jquery-3.1.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../resources/js/bootstrap.min.js"></script>


    <link href="../../resources/css/head.css" rel="stylesheet">
    <link rel="icon" href="../../resources/images/ms_icon.ico">
    <title>互联网公司</title>
</head>
<body>

<%--背景图div--%>
<div class="auth_bg">
    <img src="../../resources/images/home_background.jpg" alt="">
</div>

<%--顶部div--%>
<div class="top_div">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <a href="https://crawlersite.com/" title="公司官网" target="_blank">
                <img src="../../resources/images/home_logo.png" title="公司官网">
            </a>
        </div>
        <div class="col-xs-6 col-md-6" style="color: #ffffff; font-size: 16px;"></div>
        <div class="col-xs-6 col-md-2" style="color: #ffffff; font-size: 16px;">
            <img id="icon_man" src="../../../resources/images/icon_man.jpg" width="60px" height="60px" style="border-radius: 50%;">
        </div>
    </div>
</div>

<%--办公区div--%>
<div class="work_div">

    <div class="row_bar">
        <div class="icon_div_working">
            <img class="icon_div_icon" src="../../resources/images/icon_working1.png"/>
            <div class="icon_div_div">待&nbsp;处&nbsp;理</div>
        </div>
        <div class="icon_div_worked">
            <img class="icon_div_icon" src="../../resources/images/icon_worked1.png"/>
            <div class="icon_div_div">已&nbsp;完&nbsp;成</div>
        </div>
        <div class="icon_div_notice">
            <img class="icon_div_icon" src="../../resources/images/icon_notice1.png"/>
            <div class="icon_div_div">新&nbsp;消&nbsp;息</div>
        </div>
        <div class="icon_div_history">
            <img class="icon_div_icon" src="../../resources/images/icon_history1.png"/>
            <div class="icon_div_div">历&nbsp;史&nbsp;记&nbsp;录</div>
        </div>
    </div>

    <div class="col_bar_table_div">

        <div class="col_bar">
            <a href="project_manager">
                <div class="icon_span_head" id="col_bar_home">
                    <img class="icon_span_icon_left" src="../../resources/images/icon_home1.png"/>
                    <span class="icon_span_div">主&nbsp;&nbsp;页</span>
                    <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
                </div>
            </a>
            <div class="icon_span_head" id="col_bar_work">
                <img class="icon_span_icon_left" src="../../resources/images/icon_work1.png"/>
                <span class="icon_span_div">办&nbsp;&nbsp;公</span>
                <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
            </div>
            <div class="icon_span_head">
                <img class="icon_span_icon_left" src="../../resources/images/icon_file1.png"/>
                <span class="icon_span_div">发&nbsp;&nbsp;文</span>
                <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
            </div>
            <div class="icon_span_head">
                <img class="icon_span_icon_left" src="../../resources/images/icon_set1.png"/>
                <span class="icon_span_div">设&nbsp;&nbsp;置</span>
                <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
            </div>
            <div class="icon_span_head">
                <img class="icon_span_icon_left" src="../../resources/images/icon_community1.png"/>
                <span class="icon_span_div">社&nbsp;&nbsp;区</span>
                <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
            </div>
        </div>


        <%--办公--%>
        <div class="department_col_bar" id="department_col_bar_id">
            <div class="icon_span">
                <a href="#">
                    <span class="icon_span_div">待&nbsp;办&nbsp;项&nbsp;目</span>
                    <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
                </a>
            </div>
            <div class="icon_span">
                <a href="#">
                    <span class="icon_span_div">已&nbsp;办&nbsp;项&nbsp;目</span>
                    <img class="icon_span_icon_right" src="../../resources/images/icon_arrow1.png"/>
                </a>
            </div>
        </div>


        <%--顶部弹出卡片--%>
        <div id="top_card" class="top_card">
            <div class="row">
                <div class="col-xs-6 col-md-4">
                    <img src="../../../resources/images/icon_man.jpg" width="80px" height="80px" style="border-radius: 50%;">
                </div>
                <div class="col-xs-6 col-md-8">
                    <div class="row" style="margin-top: 20px" items="${employees}" var="employee">
                        <div class="col-xs-6 col-md-2"></div>
                        <div class="col-xs-6 col-md-10" style="color: #ffffff; font-size: 16px;">${employee.realName}</div>
                    </div>
                    <div style="margin-top: 10px" >
                        <span style="color: #ffffff; font-size: 14px;">&nbsp;&nbsp;&nbsp;${employee.department.departmentName}</span>
                        <span style="color: #ffffff; font-size: 14px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${employee.role.roleName}</span>
                    </div>
                </div>
            </div>

            <div style="margin-top: 30px;color: #ffffff; font-size: 14px;">
                <span style="margin-left: 10px;background-color:rgba(0, 0, 0, .3);width: 100px;height: 60px; padding: 10px;border-radius: 10%" >
                    我&nbsp;的&nbsp;主&nbsp;页
                </span>
                <span style="margin-left: 20px;background-color:rgba(0, 0, 0, .3);width: 100px;height: 60px; padding: 10px;border-radius: 10%" >
                    个&nbsp;人&nbsp;设&nbsp;置
                </span>
            </div>

            <div style="margin-top: 25px;color: #ffffff; font-size: 14px;">
                <span style="margin-left: 10px;background-color:rgba(0, 0, 0, .3);width: 100px;height: 60px; padding: 10px;border-radius: 10%" >
                    切&nbsp;换&nbsp;账&nbsp;号
                </span>
                <a href="login_out">
                <span style="color: #ffffff;margin-left: 20px;background-color:rgba(0, 0, 0, .3);width: 100px;height: 60px; padding: 10px;border-radius: 10%" >
                    退&nbsp;出&nbsp;登&nbsp;录
                </span>
                </a>
            </div>

        </div>


        <script type="text/javascript">
            $(function(){

                // 点击办公，出现办公选项
                $("#col_bar_work").mouseover(function(){
                    $("#department_col_bar_id").toggle();
                });

                // 弹出头像卡片
                $("#icon_man").mouseover(function(){
                    $("#top_card").toggle();
                });


            })
        </script>


<%--head_admin.jsp is over--%>