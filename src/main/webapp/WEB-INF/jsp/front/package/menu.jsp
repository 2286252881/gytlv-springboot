<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<c:forEach items="${ms}" var="m">
				<c:if test="${selected == m.url}">
					<li class="active"><a href="${m.url}">${m.menuName}</a></li>
				</c:if>
				<c:if test="${selected != m.url}">
					<li><a href="${m.url}">${m.menuName}</a></li>
				</c:if>
			</c:forEach>
			<shiro:guest> 
				<li><a href="/login" style="color: red">登录</a></li>
			</shiro:guest>
			<shiro:user> 
			 <li><a href="/back" style="color: #46d225">欢迎：<shiro:principal property="username"/></a></li><li><a href="/logout" style="color: #19b518">退出</a></li>
			</shiro:user>
		</ul>
	</div>
</nav>