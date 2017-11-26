<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<!-- layui -->
<link rel="stylesheet" href="/plugin/layui/css/layui.css" media="all">


<link rel="stylesheet" href="plugin/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="plugin/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="plugin/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="plugin/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="plugin/kindeditor/plugins/code/prettify.js"></script>
<title>清风暮雨</title>
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">
				<a href="/"><font style="font-size: 18px; color: white;">gytlv</font></a>
			</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="/toManager">控制台</a></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img src="http://t.cn/RCzsdCq" class="layui-nav-img"><shiro:principal property="username"/>
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
						<dd>
							<a href="/logout">退出</a>
						</dd>
					</dl>
				</li>
			</ul>
		</div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
					<c:forEach items="${nodes}" var="pNode" varStatus="i">
						<c:if test="${i.index eq 0 }">
							<li class="layui-nav-item layui-nav-itemed"><a>${pNode.name}</a>
								<dl class="layui-nav-child">
									<c:forEach items="${pNode.children}" var="node" varStatus="j">
										<c:if test="${j.index eq 0 }">
											<dd class="layui-this">
												<a href="${node.ahref}" target="view_frame">${node.name}</a>
											</dd>
										</c:if>
										<c:if test="${j.index gt 0 }">
											<dd>
												<a href="${node.ahref}" target="view_frame">${node.name}</a>
											</dd>
										</c:if>
									</c:forEach>
								</dl></li>
						</c:if>
						<c:if test="${i.index gt 0 }">
							<li class="layui-nav-item"><a class="" target="view_frame">${pNode.name}</a>
								<dl class="layui-nav-child">
									<c:forEach items="${pNode.children}" var="node" varStatus="j">
										<c:if test="${j.index eq 0 }">
											<dd class="layui-this">
												<a href="${node.ahref}" target="view_frame">${node.name}</a>
											</dd>
										</c:if>
										<c:if test="${j.index gt 0 }">
											<dd>
												<a href="${node.ahref}" target="view_frame">${node.name}</a>
											</dd>
										</c:if>
									</c:forEach>
								</dl></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<iframe name="view_frame" width="100%" height="500" scrolling="auto" frameborder=0></iframe>
			</div>
		</div>
		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© www.gytlv.com - 底部固定区域
		</div>
	</div>
</body>
<script src="/plugin/js/jquery-3.2.1.min.js" charset="utf-8"></script>
<script src="/plugin/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
	layui.config({
		version : '1511048241431' //为了更新 js 缓存，可忽略
	});
	layui.use([ 'element' ], function() {
		var element = layui.element; //元素操作
	});
	KindEditor.ready(function(K) {
	});
</script>
</html>