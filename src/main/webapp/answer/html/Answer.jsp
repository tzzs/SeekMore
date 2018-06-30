<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/6/28
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.zhihu.pojo.Comment" %>
<%@ page import="jdk.internal.dynalink.linker.LinkerServices" %>
<%@ page import="com.zhihu.pojo.Answer" %>
<%@ page import="com.zhihu.pojo.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Question question = (Question) request.getAttribute("question");
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
    List<Answer> answers = (List<Answer>) request.getAttribute("answers");

%>
<html>
<head>
    <!-- META TAGS -->
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Hydrogen &mdash; A free HTML5 Template </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FREEHTML5.CO"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>
    <meta name="author" content="FREEHTML5.CO"/>

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <script src="../js/index.js"></script>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="../icons/搜索.svg">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    <!-- Animate.css -->
    <link rel="stylesheet" href="../css/animate1.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="../css/icomoon1.css">
    <!-- Magnific Popup -->
    <link rel="stylesheet" href="../css/magnific-popup1.css">
    <!-- Salvattore -->
    <link rel="stylesheet" href="../css/salvattore1.css">
    <!-- Theme Style -->
    <link rel="stylesheet" href="../css/styleIndex1.css">
    <!-- Modernizr JS -->
    <script src="${pageContext.request.contextPath}/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/modernizr-2.6.2.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="../css/index1.css">

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

    <script>


        $("#close").click(function () {
            $(".box-pwd").css({
                "display": "none"
            });

            $(".box-shadow").css({
                "display": "none"
            });

            /* 清空残留数据 */
            $("#id").val("");
            $("#title").val("");
            $("#topic").val("");
            $("#des").val("");
            // $(".submit").removeClass("add_submit").removeClass("add-question");
            $("#form").attr("action", "#");
        });
    </script>

    <link rel="shortcut icon" href="../images/favicon.png"/>


    <!-- Style Sheet-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel='stylesheet' id='main-css-css' href='${pageContext.request.contextPath}/answer/css/main5152.css?ver=1.0' type='text/css' media='all'/>

    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script></script>
    <![endif]-->

</head>
<body>

<!-- Start of Header -->

<div class="header">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="header-nav">

            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header left">
                    <a class="navbar-brand" href="#"><strong>Seek More</strong></a>
                </div>

                <!--上方标题栏-->
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active lr"><a href="${pageContext.request.contextPath}/html/index.html">首页 <span class="sr-only">(current)</span></a></li>
                        <li class="lr"><a href="${pageContext.request.contextPath}/html/index.html" onclick="">发现</a></li>
                        <li class="lr"><a href="${pageContext.request.contextPath}/html/index.html">话题</a></li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <div class="form-group right-40" method="post"
                             action="${pageContext.request.contextPath}/question/findByLike">
                            <input type="text" class="form-control" placeholder="搜索你感兴趣的内容">
                            <button type="submit" class="btn btn-default">
                                <img src="${pageContext.request.contextPath}/icons/搜索.svg" alt="搜索" height="20px" width="20px">
                            </button>
                        </div>
                        <button type="submit" class="btn btn-primary"><a href="${pageContext.request.contextPath}/editor/examples/editor.html"
                                                                         style="color: white;"
                                                                         class="">提问</a></button>
                    </form>


                    <ul class="nav navbar-nav navbar-right">

                        <a class="navbar-brand header-img" href="#">
                            <img alt="Brand" class="img-rounded" src="${pageContext.request.contextPath}/icons/通知.svg" height="20px" width="20px">
                        </a>

                        <!--<a class="navbar-brand header-img" href="#">-->
                        <!--<img alt="Brand" class="img-rounded" src="../images/img_2.jpg" height="25px" width="30px">-->
                        <!--</a>-->

                        <li class="dropdown">
                            <a class="dropdown-toggle header-img" href="#" data-toggle="dropdown" aria-haspopup="true">
                                <img alt="Brand" class="img-rounded" id="userIcon" src="${pageContext.request.contextPath}/images/img_2.jpg"
                                     height="25px" width="30px">
                            </a>
                            <!--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"-->
                            <!--aria-expanded="false">Dropdown <span class="caret"></span></a>-->
                            <ul class="dropdown-menu">
                                <li><a href="#">我的主页</a></li>
                                <li><a href="#">设置</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">退出</a></li>
                            </ul>
                        </li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </div>
    </nav>
</div>


<div id="fh5co-main">
    <div class="container">


        <!--左边部分 -->
        <!--修改为80%宽度-->
        <div class="row">
            <!-- start of page content -->
            <div class="span8 page-content">

                <div class="card">
                    <nav class="navbar navbar-default ">


                        <div style="cursor: pointer" class="card-title a-title" onclick="addQuestion()"><img
                                src="${pageContext.request.contextPath}/icons/常见问题.svg" class="card-icon" alt="">
                            提问
                        </div>
                        <a href="" class="card-title a-title"><img src="${pageContext.request.contextPath}/icons/查看回答.svg" class="card-icon" alt=""> 回答</a>
                        <a href="" class="card-title a-title"><img src="${pageContext.request.contextPath}/icons/填写日报.svg" class="card-icon" alt=""> 写文章</a>
                        <a href="" class="card-title a-title"><img src="${pageContext.request.contextPath}/icons/想法.svg" class="card-icon" alt="">
                            写想法</a>
                        <a href="" class="card-title a-title"></a>
                    </nav>
                </div>
                <%--<ul class="breadcrumb">
                    <li><a href="#">Knowledge Base Theme</a><span class="divider">/</span></li>
                    <li><a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a> <span class="divider">/</span></li>
                    <li class="active">Integrating WordPress with Your Website</li>
                </ul>--%>
                <div class="QuestionHeader-content" style="width: 98%; margin-left: 10px; border:solid 1px white;
                border-width:1px 1px 1px 1px;background-color: #f0f0f0;border-radius: 5px">
                    <div class="QuenstionHeadr-main">
                    <span class="tags">
                            <strong>Tags:&nbsp;&nbsp;</strong><a href="#" rel="tag">basic</a>, <a href="#" rel="tag">setting</a>, <a
                            href="http://knowledgebase.inspirythemes.com/tag/website/" rel="tag">website</a>
                    </span>
                        <%--<h1>历史上有哪些霸气的话？</h1>--%>
                        <h1><%=question.getqTitle()%>
                        </h1>
                        <div class="QuestionHeader-detail">
                            <div class="QuenstionRichText">
                                <div>
                                    <span class="RichText ztext" itemprop="text" style="color: blue;">
                                        <%=question.getqContent()%></span>
                                    <%--诸如犯我强汉者虽远必诛，数风流人物还看今朝这些耳熟能详的除外--%>
                                    <!--<button type="button" class="Bution QuenstionRichText-more Button-plain">显示全部</button>
                                    <svg viewBox="0 0 10 6" class="Icon QuenstionRichText-more-icon Icon--arrow" width="10" height="16" aria-hidden="true" style="height: 16px;width: 10px;">
                                        <title></title>
                                        <g>
                                            <path d="M8.716.217L5.002 4 1.285.218C.99-.072.514-.072.22.218c-.294.29-.294.76 0 1.052l4.25 4.512c.292.29.77.29 1.063 0L9.78 1.27c.293-.29.293-.76 0-1.052-.295-.29-.77-.29-1.063 0z"></path>
                                        </g>
                                    </svg>-->
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <div class="Sticky QuenstionHeadr-bottom">
                        <div class="QuenstionHeadr-inner">
                            <div class="QuenstionButtonGruop" style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">
                                <button type="button" class="Button" id="Button">关注</button>
                                <button type="button" class="btn-btn-primary" id="btn-btn-primary"
                                        data-toggle="collapse"
                                        data-target="#comment-main">
                                    <!--写回答-->
                                    <!--<button type="button" class="Button-Comment">-->
                                    <span style="display: inline-flex; align-items: center;">&#8203;
                                        <svg class="Zi Zi--Comment Button-zi" fill="currentColor" viewBox="0 0 24 24"
                                             width="1.2em" height="1.2em">
                                            <path d="M10.241 19.313a.97.97 0 0 0-.77.2 7.908 7.908 0 0 1-3.772 1.482.409.409 0 0 1-.38-.637 5.825 5.825 0 0 0 1.11-2.237.605.605 0 0 0-.227-.59A7.935 7.935 0 0 1 3 11.25C3 6.7 7.03 3 12 3s9 3.7 9 8.25-4.373 9.108-10.759 8.063z"
                                                  fill-rule="evenodd"></path>
                                        </svg>
                                    </span>
                                    回答
                                </button>

                                <button type="button" class="Button-Invite" id="Button-Invite">邀请回答</button>
                            </div>
                        </div>
                    </div>
                </div>

                <form>
                    <div id="comment-main" class="panel-collapse collapse" style="margin-left: 10px;">
                        <div>
                            <label for="comment">回答</label>
                            <textarea class="span-comment" name="comment" id="comment" cols="50" rows="1"></textarea>
                        </div>


                        <div>
                            <input class="btn-1" name="submit" type="submit" id="submit-1" value="提交回答">
                        </div>
                    </div>

                </form>
                <%
                    if (answers != null) {
                        int index = 0;
                        for (Answer answer : answers) {


                %>

                <article class=" type-post format-standard hentry clearfix"
                             style="width: 98%; margin-left: 10px;border:solid 1px white;border-width:1px 1px 1px 1px;background-color: #f0f0f0;border-radius: 5px">

                        <a href="#">
                            <%--<img alt="" src="http://0.gravatar.com/avatar/2df5eab0988aa5ff219476b1d27df755?s=60&amp;d=http%3A%2F%2F0.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D60&amp;r=G" class="avatar avatar-60 photo" height="60" width="60">--%>
                            <img alt="" src="${pageContext.request.contextPath}/images/img_10.jpg" class="avatar avatar-60 photo" height="60" width="60">
                        </a>

                    <div class="comment-meta">

                        <h5 class="author">
                            <cite class="fn"><a href="#" rel="external nofollow"
                                                class="url"><%--<%=answer.getUser().getUserInfo().getUserRole()%>--%></a></cite>
                            - <a class="comment-reply-link"
                                 href="#"><%--<%=answer.getUser().getUserInfo().getUserName()%>--%></a>
                        </h5>

                    </div>
                    <!--
                   <div class="post-meta clearfix">
                           <span class="date">25 Feb, 2013</span>
                           <span class="category"><a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a></span>
                           <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3 Comments</a></span>
                           <span class="like-count">66</span>
                   </div>-->

                    <!-- end of post meta -->
                    <div>
                        <%--<p style="color: #1d0d0b">面对两个台湾女人在发反中传单，马来西亚这几个华人老大叔怒斥:“中国今天多么好，你们要这样搞中国！你们这些汉奸，走狗！马来西亚不欢迎你们这些汉奸走狗。”最后边做手势边说：“要是可以杀人我头一个杀了你！”</p>--%>
                        <p style="color: #1d0d0b"><%=answer.getaContent()%>
                        </p>
                        <%--<p><%=answer.getaContent()%></p>--%>
                    </div>
                </article>


                <div class="like-btn" style="margin-left: 10px;margin-top: 10px">

                    <form id="like-it-form" action="#" method="post">
                        <span class="like-it " style="height: 28px;width: 50px;text-align: center;background-color: #dddddd">66</span>
                        <input type="hidden" name="post_id" value="99">
                        <input type="hidden" name="action" value="like_it">

                        <button type="button" class="btn-btn-primary" data-toggle="collapse"
                                data-target="#collapse<%=index%>">
                                <span style="display: inline-flex; align-items: center;">&#8203;
                                    <svg class="Zi Zi--Comment Button-zi" fill="currentColor" viewBox="0 0 24 24"
                                         width="1.2em" height="1.2em">
                                        <path d="M10.241 19.313a.97.97 0 0 0-.77.2 7.908 7.908 0 0 1-3.772 1.482.409.409 0 0 1-.38-.637 5.825 5.825 0 0 0 1.11-2.237.605.605 0 0 0-.227-.59A7.935 7.935 0 0 1 3 11.25C3 6.7 7.03 3 12 3s9 3.7 9 8.25-4.373 9.108-10.759 8.063z"
                                              fill-rule="evenodd"></path>
                                    </svg>
                                </span>
                            评论
                        </button>

                        <button type="button" name="collect" id="collect">收藏</button>
                    </form>
                </div>


                <div id="collapse<%=index%>" class="panel-collapse collapse"
                     style="width: 98%; margin-left: 10px;background-color: #f0f0f0;border-radius: 5px;border:solid 1px white;border-width:1px 1px 1px 1px;">
                    <section id="comments">
                        <h3 id="comments-title">评论</h3>

                        <%
                            if (comments != null) {
                                for (Comment comment : comments) {


                        %>
                        <ol class="commentlist">


                            <li class="comment even thread-odd thread-alt depth-1" id="li-comment-4">
                                <article id="comment-4">

                                    <%--<a href="#">
                                        <img alt=""
                                             src="${pageContext.request.contextPath}/images/<%=comment.getUser().getUserInfo().getUserIcon()%>;r=G"
                                             class="avatar avatar-60 photo" height="60" width="60">
                                    </a>--%>

                                    <a href="#">
                                        <%--<img alt="" src="http://1.gravatar.com/avatar/50a7625001317a58444a20ece817aeca?s=60&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D60&amp;r=G" class="avatar avatar-60 photo" height="60" width="60">--%>
                                        <img alt="" src="${pageContext.request.contextPath}/images/img_1.jpg" class="avatar avatar-60 photo" height="60" width="60">
                                    </a>

                                    <div class="comment-meta">

                                        <h5 class="author">
                                            <cite class="fn">
                                                <a href="#" rel="external nofollow" class="url">John Doe</a></cite>
                                            - <a class="comment-reply-link"
                                                 href="#"><%--<%=comment.getUser().getUserInfo().getUserName()%>--%></a>
                                        </h5>


                                    </div><!-- end .comment-meta -->

                                    <div class="comment-body">
                                        <p><%=comment.getcComment()%>
                                        </p>
                                        <div class="like-btn">
                                            <form id="like-it-form1" action="#" method="post">
                                                <span class="like-it "><%=comment.getLikeNum()%></span>
                                                <input type="hidden" name="post_id" value="99">
                                                <input type="hidden" name="action" value="like_it">
                                            </form>
                                        </div>
                                    </div><!-- end of comment-body -->

                                </article><!-- end of comment -->
                            </li>
                        </ol>
                        <%
                                }
                            }
                        %>
                        <div id="respond">

                            <h3 style="">你的评论</h3>

                            <div class="cancel-comment-reply">
                                <a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Click
                                    here to cancel reply.</a>
                            </div>


                            <form action="" method="post" id="commentform">

                                <div>
                                    <label for="comment">评论</label>
                                    <textarea class="span8" name="comment" id="comment1" cols="50" rows="1" style="resize: none"></textarea>
                                </div>


                                <div>
                                    <input class="btn" name="submit" type="submit" id="submit1" value="提交评论">
                                </div>

                            </form>

                        </div>

                    </section><!-- end of comments -->
                </div>


                <%
                            index++;
                        }
                    }
                %>

            </div>
        </div>
        <!--end of page content-->


        <!-- start of sidebar -->

        <!--右边部分-->
        <div class="right-card"
             style="position: fixed;height: 30%; width: 20%;right:200px; top: 70px;  left: 70%;  bottom: auto;">
            <div class="list-card">
                <ul class="list-group">
                    <a href="" class="list-group-item"><img src="${pageContext.request.contextPath}/icons/收藏.svg" alt="" class="card-icon"><span
                            class="badge">14</span> 我的收藏</a>
                    <a href="" class="list-group-item"><img src="${pageContext.request.contextPath}/icons/常见问题.svg" alt="" class="card-icon"><span
                            class="badge">14</span>
                        我关注的问题</a>
                    <a href="" class="list-group-item"><img src="${pageContext.request.contextPath}/icons/信息.svg" alt="" class="card-icon" height="20px"
                                                            width="20px"><span> 社区服务中心</span></a>
                    <a href="" class="list-group-item"><img src="${pageContext.request.contextPath}/icons/版权.svg" alt=""
                                                            class="card-icon"><span> 版权服务中心</span></a>
                    <a href="" class="list-group-item"><img src="${pageContext.request.contextPath}/icons/编辑.svg" alt=""
                                                            class="card-icon"><span> 公共编辑动态</span></a>
                </ul>
            </div>

            <!--右侧信息-->
            <footer class="card-footer">
                <a href="">Seek 猫</a>
                <span>·</span>
                <a href="">千寻指南</a>
                <span>·</span>
                <a href="">千寻协议</a>
                <span>·</span>
                <a href="">隐私政策</a>
                <br>
                <a href="">应用</a>
                <span>·</span>
                <a href="">工作</a>
                <span>·</span>
                <a href="">申请开通千寻机构号</a>
                <br>
                <a href="">侵权举报</a>
                <span>·</span>
                <a href="">网上有害信息举报专区</a>
                <br>
                <span>违法和不良信息举报：010-82716601</span>
                <br>
                <a href="">儿童色情信息举报专区</a>
                <br>
                <a href="">联系我们</a>
                <span>&copy;2018 千寻</span>

            </footer>

        </div>

        <!--页脚-->
        <footer id="fh5co-footer">
            <div class="container">
                <div class="row-padded">
                    <div class="col-md-12 text-center">
                        <p class="fh5co-social-icons">
                            <a href="#"><i class="icon-twitter"></i></a>
                            <a href="#"><i class="icon-facebook"></i></a>
                            <a href="#"><i class="icon-instagram"></i></a>
                            <a href="#"><i class="icon-dribbble"></i></a>
                            <a href="#"><i class="icon-youtube"></i></a>
                            <a href="https://github.com/tzz3/SeekMore"><i class="icon-github"></i></a>
                        </p>
                        <p>
                            <small>&copy; Power by 凌晨四点. <br> All Rights Reserved.</small>
                        </p>
                    </div>
                </div>
            </div>
        </footer>


        <!-- 提问弹窗 -->
        <div class="box-pwd">
            <form action="" id="form" method="post">
                <div class="close-box" style="cursor: pointer">
                    <img src="${pageContext.request.contextPath}/icons/关闭.svg" onclick="close_box()" alt="X" height="20px" width="20px">
                </div>
                <div class="h3 text-center">写下你的问题</div>
                <div class="h5 text-center">描述精确的问题更易得到解答</div>

                <div>
                    <input type="text" name="id" id="id" class="id" style="display: none"/>
                </div>

                <div class="box-th title-th">
                    <textarea name="title" class="q-title" form="form" id="title" cols="57"
                              placeholder="问题标题"></textarea>
                </div>


                <div class="box-th">
                    <input type="text" name="topic" id="topic" class="topic" placeholder="添加话题"/>
                </div>

                <div style="margin-left: 15%;">问题描述(可选)：</div>
                <div class="box-th title-th">
                    <textarea name="des" class="q-title" form="form" id="des" cols="57"
                              placeholder="问题背景、条件等详细信息"></textarea>
                </div>
                <!--<div class="box-th">-->
                <!--<input type="des" name="des" id="des" class="des" placeholder="问题背景、条件等详细信息"/>-->
                <!--</div>-->
                <div class="info-pwd" id="info-pwd">
                </div>
                <input type="submit" class="submit" id="submit" value="提交"/>
            </form>
        </div>
        <div class="box-shadow"></div>


        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- Waypoints -->
        <script src="${pageContext.request.contextPath}/js/jquery.waypoints.min.js"></script>
        <!-- Magnific Popup -->
        <script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
        <!-- Salvattore -->
        <script src="${pageContext.request.contextPath}/js/salvattore.min.js"></script>
        <!-- Main JS -->
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
        <!--end of sidebar-->

    </div>
</div>
<!-- End of Page Container -->

<a href="#top" id="scroll-top"></a>
<!-- script -->
<script type='text/javascript' src='../js/jquery-1.8.3.min.js'></script>
<script type='text/javascript' src='../js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='../js/prettyphoto/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='../js/jflickrfeed.js'></script>
<script type='text/javascript' src='../js/jquery.liveSearch.js'></script>
<script type='text/javascript' src='../js/jquery.form.js'></script>
<script type='text/javascript' src='../js/jquery.validate.min.js'></script>
<script type='text/javascript' src='../js/custom.js'></script>

<script type="text/javascript">
    var userName = "${user.userName}";
    var aComment = $(this).parents("tr").find("td").eq(0).html();
    $("#userName").val(userName);

    $(".btn-1").click(function () {
        alert("添加回答");
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/question/addComment?userName=" + userName,
            data: {aComment: aComment},
            async: false,
            success: function (data) {
                // alert(data.msg);
            }
        });
    });
    //添加评论
    var thisValue =  $("#span8").value;
    $(".btn").click(function () {
        alert("添加评论");
        alert(222);
        alert(thisValue);
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/comment/addComment?userName=" + userName,
            data: $("#form").serialize(),
            async: false,
            success: function (data) {
                // alert(data.msg);
                window.location.reload();
            }
        })
    })
    //关注
    $(".Button").click(function () {
        alert(1111);
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/answer/addAnswer",
            data: $()
        })
    })
</script>
</body>
</html>
