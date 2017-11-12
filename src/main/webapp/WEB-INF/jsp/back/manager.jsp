<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="plugin/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="plugin/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="after/css/manager.css" type="text/css" />
<script src="plugin/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="plugin/js/bootstrap.min.js" type="text/javascript"></script>
<script src="plugin/js/pagehelper/bootstrap-paginator.js" type="text/javascript"></script>
<script type="text/javascript" src="plugin/ztree/js/jquery.ztree.core.js"></script>
<script src="plugin/js/dialog.js" type="text/javascript"></script>
<script src="after/js/manager.js" type="text/javascript"></script>

<link rel="stylesheet" href="plugin/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="plugin/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="plugin/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="plugin/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="plugin/kindeditor/plugins/code/prettify.js"></script>
<title>清风暮雨</title>
<style type="text/css"></style>
</head>
<body>
	<div class="thumbnail">
		<ul class="list-group">
			<li class="list-group-item"><span>后台管理</span><span style="float: right;"><a href="javascript:void(0);" onclick="window.location.href='/'">首页>></a></span></li>
		</ul>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<div id="ztree" class="thumbnail ztree"></div>
			</div>
			<div class="col-sm-8" id="page"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	KindEditor.ready(function(K){});
</script>
</html>