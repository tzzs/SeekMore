<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!--先导入我们的easyUI的样式文件-->
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../themes/icon.css" />
<!--导入我们的js文件-->
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/head.css" />
</head>

<body id="headBody">
	<center>
		<h1>计算机学院成绩APP后台管理系统</h1>
	</center>
	<div id="div1">
		<a href="javascript:void(0)" id="mb" class="easyui-menubutton"
			data-options="menu:'#mm',iconCls:'icon-man'">席阳</a>
		<div id="mm" style="width: 150px;">
			<div data-options="iconCls:'icon-undo'">
				<a href="${pageContext.request.contextPath}/logout.action">注销</a>
			</div>
		</div>
	</div>
</body>
</html>