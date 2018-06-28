<%@ page import="com.zhihu.pojo.UserInfo" %>
<%@ page import="com.zhihu.pojo.Role" %><%--
  Created by IntelliJ IDEA.
  User: 林少瑜
  Date: 2018/6/27
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="ace ace-card-on ace-tab-nav-on ace-main-nav-on ace-sidebar-on" data-theme-color="#c0e3e7">
<%
    // UserInfo u=new UserInfo();
    // Role r=new Role();
    // r.setId("1");
    // r.setrRole("1");
    // u.setId("11503070339");
    // u.setUserName("林少瑜");
    // u.setUserSex("男");
    // u.setUserPassword("123");
    // u.setUserEmail("332547960@qq.com");
    // u.setUserIntro("我就是我，不一样的烟火。");
    // u.setUserIcon("images/filUp/1530165973502.jpg");
    // u.setUserRole(r);
    // request.getSession().setAttribute("u", u);
    UserInfo user=(UserInfo)request.getSession().getAttribute("u");
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>个人主页</title>
    <meta name="description" content="">

    <!-- Icon Fonts -->
    <link href="../fonts5/icomoon/style.css" rel="stylesheet">

    <!-- Styles -->
    <link href="../js/plugins/highlight/solarized-light.css" rel="stylesheet">
    <link href="../css/userstyle.css" rel="stylesheet">

    <!-- Modernizer -->
    <script type="text/javascript" src="../js/vendor/modernizr-3.3.1.min.js"></script>
</head>
<body>
<div class="ace-wrapper">
    <header id="ace-header" class="ace-container-shift ace-logo-in ace-head-boxed ace-nav-right">
        <div class="ace-head-inner">
            <div class="ace-head-container ace-container">
                <div class="ace-head-row">
                    <div id="ace-head-col1" class="ace-head-col text-left">
                        <a id="ace-logo" class="ace-logo" href="userIndex.jsp">
                            <img src="../img/uploads/brand/logo.svg" alt="ace resume"><span>QianXun</span>
                        </a>
                    </div>

                    <div id="ace-head-col2" class="ace-head-col text-right">
                        <div class="ace-nav-container ace-container hidden-sm hidden-xs">
                            <nav id="ace-main-nav">
                                <ul class="clear-list">
                                    <li><a href="${pageContext.request.contextPath}/html/userIndex.jsp">个人资料</a></li>
                                    <li><a href="${pageContext.request.contextPath}/html/userAlter.jsp">修改资料</a></li>
                                    <li><a href="${pageContext.request.contextPath}/html/userPasw.jsp">修改密码</a></li>
                                    <li><a href="${pageContext.request.contextPath}/users/findMessge">通知</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>

                    <div id="ace-head-col3" class="ace-head-col text-right">
                        <button id="ace-sidebar-btn" class="btn btn-icon btn-light btn-shade">
                            <span class="ace-icon ace-icon-side-bar-icon"></span>
                        </button>
                    </div>
                </div>
            </div><!-- .ace-container -->
        </div><!-- .ace-head-inner -->
    </header><!-- #ace-header -->



    <article id="ace-card" class="ace-card bg-primary">
        <div class="ace-card-inner text-center">
            <img class="avatar avatar-195" src="../img/uploads/avatar/avatar-195x195.png" style="width: 195px;height: 195px;" alt="" id="userIcon" >
            <h1 class="text-muted" id="bigName"></h1>
            <ul class="ace-social clear-list">
                <li><a><span class="ace-icon ace-icon-facebook"></span></a></li>
                <li><a><span class="ace-icon ace-icon-twitter"></span></a></li>
                <li><a><span class="ace-icon ace-icon-google-plus"></span></a></li>
                <li><a><span class="ace-icon ace-icon-instagram"></span></a></li>
                <li><a><span class="ace-icon ace-icon-pinterest"></span></a></li>
            </ul>
        </div>

        <footer class="ace-card-footer">
            <a class="btn btn-lg btn-block btn-thin btn-upper " href="index.html">返回首页</a>
        </footer>
    </article><!-- #ace-card -->

    <div id="ace-content" class="ace-container-shift">
        <div class="ace-container">

            <div id="ace-nav-wrap" class="hidden-sm hidden-xs">
                <div class="ace-nav-cont">
                    <div id="ace-nav-scroll">
                        <nav id="ace-nav" class="ace-nav">
                            <ul class="clear-list">
                                <li>
                                    <a href="${pageContext.request.contextPath}/html/userIndex.jsp" data-tooltip="我"><img class="avatar avatar-195" src="../img/uploads/avatar/avatar-195x195.png" style="width: 42px;height: 42px;" alt="" id="userIcon1" ></a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/users/findMessge" data-tooltip="通知"><span class="ace-icon ace-icon-contact"></span></a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/html/userAlter.jsp" data-tooltip="修改资料"><span class="ace-icon ace-icon-blog"></span></a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/html/userPasw.jsp" data-tooltip="修改密码"><img src="../img/uploads/修改.png" style="width: 29.27px;height: 28px;"></a>
                                </li>
                            </ul>
                        </nav>
                    </div>

                    <div id="ace-nav-tools" class="hidden">
                        <span class="ace-icon ace-icon-dots-three-horizontal"></span>

                        <button id="ace-nav-arrow" class="clear-btn">
                            <span class="ace-icon ace-icon-chevron-thin-down"></span>
                        </button>
                    </div>
                </div>
                <div class="ace-nav-btm"></div>
            </div><!-- .ace-nav-wrap -->

            <div class="ace-paper-stock">
                <main class="ace-paper clearfix">
                    <div class="ace-paper-cont clear-mrg">

                        <!-- START: PAGE CONTENT -->
                        <div class="padd-box clear-mrg">
                            <section class="section brd-btm">
                                <div class="row">
                                    <div class="col-sm-12 clear-mrg text-box">
                                        <h2 class="title-lg text-upper">个人介绍</h2>
                                        <b id="userIntro1"></b><br>
                                        <p id="userIntro">1111111111111111111111111</p>

                                        <p class="text-right">
                                            <img src="../img/uploads/brand/logo.svg" alt="ace resume"><span>QianXun</span>
                                        </p>
                                    </div>
                                </div>
                            </section><!-- .section -->

                            <section class="section brd-btm">
                                <div class="row">
                                    <div class="col-sm-6 clear-mrg">
                                        <h2 class="title-thin text-muted">个人资料</h2>

                                        <dl class="dl-horizontal clear-mrg">
                                            <dt class="text-upper">账号</dt>
                                            <dd id="userId">未知</dd>

                                            <dt class="text-upper">用户名</dt>
                                            <dd id="userName">未知</dd>

                                            <dt class="text-upper">性别</dt>
                                            <dd id="userSex">未知</dd>

                                            <dt class="text-upper">e-mail</dt>
                                            <dd id="userEmail">未知</dd>

                                            <dt class="text-upper">手机号码</dt>
                                            <dd id="userPhone">未知</dd>

                                        </dl>
                                    </div><!-- .col-sm-6 -->

                                </div><!-- .row -->
                            </section><!-- .section -->

                        </div><!-- .padd-box -->
                        <!-- END: PAGE CONTENT -->

                    </div><!-- .ace-paper-cont -->
                </main><!-- .ace-paper -->
            </div><!-- .ace-paper-stock -->

        </div><!-- .ace-container -->
    </div><!-- #ace-content -->

    <div id="ace-sidebar">
        <button id="ace-sidebar-close" class="btn btn-icon btn-light btn-shade">
            <span class="ace-icon ace-icon-close"></span>
        </button>

        <div id="ace-sidebar-inner">
            <nav id="ace-main-nav-sm" class="visible-xs visible-sm text-center">

            </nav><!-- #ace-main-nav-sm -->

            <article class="ace-card bg-primary">
                <div class="ace-card-inner text-center">
                    <img class="avatar avatar-195" src="../img/uploads/avatar/avatar-195x195.png" style="width: 195px;height: 195px;" alt="" id="side_userIcon" >
                    <h1 class="text-muted" id="side_bigName"></h1>
                    <ul class="ace-social clear-list">
                        <li><a><span class="ace-icon ace-icon-facebook"></span></a></li>
                        <li><a><span class="ace-icon ace-icon-twitter"></span></a></li>
                        <li><a><span class="ace-icon ace-icon-google-plus"></span></a></li>
                        <li><a><span class="ace-icon ace-icon-instagram"></span></a></li>
                        <li><a><span class="ace-icon ace-icon-pinterest"></span></a></li>
                    </ul>
                </div>
            </article><!-- #ace-card -->

            <aside class="widget-area">


                <section class="widget widget_posts_entries">
                    <h2 class="widget-title" >账号</h2>
                    <ul>
                        <li>
                            <div class="post-content">
                                <h3 style="text-align: center;color: #AEEEEE;" id="side_id">
                                    账号
                                </h3>
                            </div>
                        </li>
                    </ul>

                    <h2 class="widget-title">用户名</h2>
                    <ul>
                        <li>
                            <div class="post-content">
                                <h3 class="widget-title1" style="text-align: center;color: #AEEEEE;" id="side_name">
                                    用户名
                                </h3>
                            </div>
                        </li>
                    </ul>

                    <h2 class="widget-title">手机</h2>
                    <ul>
                        <li>
                            <div class="post-content">
                                <h3 class="widget-title1" style="text-align: center;color: #AEEEEE;" id="side_phone">
                                    手机
                                </h3>
                            </div>
                        </li>
                    </ul>

                    <h2 class="widget-title">邮箱</h2>
                    <ul>
                        <li>
                            <div class="post-content">
                                <h3 class="widget-title1" style="text-align: center;color: #AEEEEE;" id="side_email">
                                    邮箱
                                </h3>
                            </div>
                        </li>
                    </ul>

                </section>


            </aside>

        </div><!-- #ace-sidebar-inner -->
    </div><!-- #ace-sidebar -->

    <!-- Triangle Shapes -->
    <svg id="ace-bg-shape-1" class="hidden-sm hidden-xs" height="519" width="758">
        <polygon points="0,455,693,352,173,0,92,0,0,71" style="fill:#d2d2d2;stroke:purple;stroke-width:0; opacity: 0.5" />
    </svg>

    <svg id="ace-bg-shape-2" class="hidden-sm hidden-xs" height="536" width="633">
        <polygon points="0,0,633,0,633,536" style="fill:#c0e3e7;stroke:purple;stroke-width:0" />
    </svg>
</div><!-- .ace-wrapper -->

<!-- Scripts -->
<script type="text/javascript" src="../js/vendor/jquery-2.1.1.min.js"></script>


<!---<script type="text/javascript" src="http://ditu.google.cn/maps/api/js?key=AIzaSyDiwY_5J2Bkv2UgSeJa4NOKl6WUezSS9XA"></script>--->
<script type="text/javascript" src="../js/plugins/highlight/highlight.pack.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="../js/plugins/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="../js/plugins/progressbar.min.js"></script>
<script type="text/javascript" src="../js/plugins/slick.min.js"></script>

<script type="text/javascript" src="../js/options.js"></script>
<script type="text/javascript" src="../js/main5.js"></script>   
</body>
<script type="text/javascript">
    document.getElementById("userIcon").src="${pageContext.request.contextPath}/<%=user.getUserIcon()%>";
    document.getElementById("userIcon1").src="${pageContext.request.contextPath}/<%=user.getUserIcon()%>";
    document.getElementById("side_userIcon").src="${pageContext.request.contextPath}/<%=user.getUserIcon()%>";
    document.getElementById("bigName").innerHTML="<%=user.getUserName()%>";
    document.getElementById("userId").innerHTML="<%=user.getUserName()%>";
    document.getElementById("userIntro1").innerHTML="大家好，我是<%=user.getUserName()%>";
    document.getElementById("userIntro").innerHTML="<%=user.getUserIntro()%>";
    document.getElementById("userName").innerHTML="<%=user.getUserName()%>";
    document.getElementById("userSex").innerHTML="<%=user.getUserSex()%>";
    document.getElementById("userPhone").innerHTML="<%=user.getUserPhone()%>";
    document.getElementById("userEmail").innerHTML="<%=user.getUserEmail()%>";

    document.getElementById("side_bigName").innerHTML="<%=user.getUserName()%>";
    document.getElementById("side_id").innerHTML="<%=user.getUserName()%>";
    document.getElementById("side_name").innerHTML="<%=user.getUserName()%>";
    document.getElementById("side_phone").innerHTML="<%=user.getUserPhone()%>";
    document.getElementById("side_email").innerHTML="<%=user.getUserEmail()%>";
</script>
</html>
