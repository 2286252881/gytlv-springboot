<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="plugin/css/bootstrap.min.css" type="text/css" />
<script src="plugin/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="plugin/js/bootstrap.min.js" type="text/javascript"></script>
<script src="before/js/index.js" type="text/javascript"></script>
<link rel="stylesheet" href="before/css/index.css" type="text/css" />
<title>清风暮雨</title>
</head>
<body>
	<jsp:include page="package/menu.jsp" />
	<div class="thumbnail">
		<div class="col-xs-12 col-md-8" id="article">
			<ul class="list-group">
				<li class="list-group-item"><span class="badge" onclick="window.location.href='/'">5</span>最新发布</li>
			</ul>
		</div>
		<div class="col-xs-12 col-md-4" style="text-align: center;">
			<div class="thumbnail">
				<ul class="list-group">
					<li class="list-group-item"><span class="badge" onclick="window.location.href='/'">5</span>博主推荐</li>
				</ul>
				<div class="list-group" id="support"></div>
			</div>
			<div class="thumbnail">
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">8</span>热门排行</li>
				</ul>
				<div class="list-group" id="click"></div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
</body>
</html>