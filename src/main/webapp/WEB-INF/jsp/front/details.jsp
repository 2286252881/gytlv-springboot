<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="plugin/css/bootstrap.min.css" type="text/css" />
<script src="plugin/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="plugin/js/bootstrap.min.js" type="text/javascript"></script>
<title>清风暮雨</title>
</head>
<body>
	<jsp:include page="package/menu.jsp" />
	<div class="thumbnail" style="margin: 2%">
		<c:if test="${article!=null}">
			<div>
				<h4 class="title" style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;text-align: center;">
					<a href="javascript:void(0);">'${article.articlename}</a>
				</h4>
				<p id="desc" style="font-size: 8px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
					<span>${article.nickname}</span>&nbsp;&nbsp;&nbsp;<span>${article.articletime}</span>&nbsp;&nbsp;&nbsp;<span><a href="/">${article.articletypename}</a></span>&nbsp;&nbsp;&nbsp; <a href="#" style="text-decoration: none;" title="点击量">${article.articleclick}</a>&nbsp;阅读
				</p>
				<div id="content" style="text-indent: 2em;line-height: 30px;font-size: 16px">${article.articlecontent}</div>
			</div>
		</c:if>
	</div>
</body>
</html>