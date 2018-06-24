<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">

<title>成绩管理主页</title>
<!--先导入我们的easyUI的样式文件-->
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/head.css" />
<!--导入我们的js文件-->
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

</head>

<body class="easyui-layout">
	<div data-options="region:'north', href:'head.html'"
		style="height: 100px"></div>
	<div data-options="region:'center'">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west'" style="width: 180px">
				<div id="accordion" class="easyui-accordion" style="width: 180px;">
					<div title="成绩查询" data-options="iconCls:'icon-search'"
						style="overflow: auto; padding: 10px;">
						<ul id="tree" class="easyui-tree"
							data-options="lines:false,animate:true">
							<li><span>绩点查询</span>
								<ul>
									<li>绩点</li>
								</ul></li>
							<li><span>所有成绩查询</span>
								<ul>
									<li>成绩单</li>
								</ul></li>
							<li><span>未及格成绩查询</span>
								<ul>
									<li>未及格成绩单</li>
								</ul></li>
						</ul>
					</div>
					<div title="成绩统计" data-options="iconCls:'icon-sum'"
						style="overflow: auto; padding: 10px;">
						<ul id="tree" class="easyui-tree"
							data-options="lines:false,animate:true">
							<li><span>成绩统计</span>
								<ul>
									<li>成绩单上传</li>
									<li>成绩单下载</li>
								</ul></li>
					</div>
					<div title="学生信息管理" data-options="iconCls:'icon-tip'"
						style="padding: 10px;">
						<ul id="tree" class="easyui-tree"
							data-options="lines:false,animate:true">
							<li><span>学生信息</span>
								<ul>
									<li>学生列表</li>
								</ul></li>
						</ul>
					</div>
					<div title="教师信息管理" data-options="iconCls:'icon-tip'"
						style="padding: 10px;">
						<ul id="tree" class="easyui-tree"
							data-options="lines:false,animate:true">
							<li><span>教师信息</span>
								<ul>
									<li>教师信息列表</li>
								</ul></li>
					</div>
					<div title="课程信息管理" data-options="iconCls:'icon-tip'"
						style="padding: 10px;">
						<ul id="tree" class="easyui-tree"
							data-options="lines:false,animate:true">
							<li><span>课程信息</span>
								<ul>
									<li>本专业应修课程列表</li>
								</ul></li>
						</ul>
					</div>
					<div title="系统管理" data-options="iconCls:'icon-man'"
						style="padding: 10px;">
						<ul id="tree" class="easyui-tree"
							data-options="lines:false,animate:true">
							<li><span>学生用户</span>
								<ul>
									<li>学生用户</li>
								</ul></li>
							<li><span>教师用户</span>
								<ul>
									<li>教师用户</li>
								</ul></li>
							<li><span>管理员</span>
								<ul>
									<li>管理员</li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
			<div data-options="region:'center'">
				<div id="tt1" class="easyui-tabs"
					data-options="fit:true,plain:true,border:false,tabWidth:150"
					style="width: 500px; height: 250px;"></div>
			</div>
		</div>
	</div>
</body>

</html>