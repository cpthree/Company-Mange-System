<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery-3.1.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>


    <link href="resources/css/login.css" rel="stylesheet">
    <link rel="icon" href="resources/images/ms_icon.ico">
    <title>统一身份验证平台</title>
</head>
<body>

<%--背景图div--%>
<div class="auth_bg">
    <img src="resources/images/login_background.jpg" alt="">
</div>

<%--整体div--%>
<div class="auth_page_wrapper">

    <%--顶部logo--%>
    <img src="resources/images/login_logo.png" alt="">

    <%--右侧登录--%>
    <div class="auth_login_content">
        <div class="auth_login_right">
            <div class="auth_tab">
                <div class="auth_tab_links">
                    <ul class="nav nav-tabs">
                        <li id="account_login" style="color: #ffffff;background-color:rgba(0, 0, 0, .6);">帐号登录</li>
                        <li id="code_login" style="color: #ffffff;background-color:rgba(0, 0, 0, .4);">二维码登录</li>
                    </ul>
                </div>

                <div id="account_login_form" class="auth_tab_content" style="background-color:rgba(0, 0, 0, .4);">

                    <form action="login" method="post">
                        <div class="form-group">
                            <label for="login_username" style="color:#ffffff;margin-left: 20px;font-size: 15px">用&nbsp;户&nbsp;名</label>
                            <input type="text" class="form-control" id="login_username" placeholder="Username" name="username">
                        </div>
                        <div class="form-group">
                            <label for="login_password" style="color:#ffffff;margin-left: 20px;font-size: 15px">密&nbsp;&nbsp;码</label>
                            <input type="password" class="form-control" id="login_password" placeholder="Password" name="password">
                        </div>
                        <div class="form-group">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" style="width: 16px;height: 16px;margin-left: 2px;">
                                    <label style="color:#ffffff;margin-left: 10px;font-size: 15px">记住用户名</label>
                                    <label style="color:#ffffff;margin-left: 20px;font-size: 14px">登录遇到问题？</label>
                                </label>
                            </div>
                            <button type="submit" class="btn btn-info btn-block" style="font-size: 16px;">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                        </div>
                    </form>

                </div>

                <div id="code_login_qrcode" class="auth_tab_content" style="background-color:rgba(0, 0, 0, .4);display: none">

                    <div style="margin-left: 34px;margin-top: 6px; color: #ffffff;">
                        <span style="font-size: 18px;">互联网公司</span><span style="font-size: 15px;margin-left: 10px">手机版扫码登录</span>
                    </div>
                    <div>
                        <img style="width: 120px;height: 120px;margin-left: 70px;margin-top: 26px;" src="resources/images/qr_code.jpg">
                    </div>
                    <div style="margin-left: 72px;margin-top: 36px;color: #ffffff;">
                        <span style="font-size: 15px;">官方App</span><span style="font-size: 15px;">&nbsp;&nbsp;立即下载</span>
                    </div>

                </div>

            </div>
        </div>
    </div>


        <script type="text/javascript">
            $(document).ready(function(){
                $("#code_login").mouseover(function(){
                    $("#account_login").css("background-color","rgba(0, 0, 0, .4)");
                    $("#code_login").css("background-color","rgba(0, 0, 0, .6)");
                    $("#account_login_form").hide();
                    $("#code_login_qrcode").show();
                });
                $("#account_login").mouseover(function(){
                    $("#code_login").css("background-color","rgba(0, 0, 0, .4)");
                    $("#account_login").css("background-color","rgba(0, 0, 0, .6)");
                    $("#account_login_form").show();
                    $("#code_login_qrcode").hide();
                });

            })
        </script>




    <%--底部div--%>
    <div class="auth_login_footer">
         <span>
             Copyright&nbsp;©&nbsp;2017 hit&nbsp;All&nbsp;Rights&nbsp;Reserved&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;
         </span>
    </div>

</div>

</body>
</html>