<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8" />
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<shiro:hasRole name="admin">
	<div class="row thumbnail">
		<div class="form-group">
			<label for="title">文章标题</label> <input type="text" class="form-control" id="title" placeholder="请填写标题">
		</div>
		<div class="form-group">
			<label for="artype">文章分类</label> <select id="articleType" onchange="onseltd(this);" class="form-control">
			</select>
		</div>
	</div>
	<div class="row thumbnail">
		<div class="form-group">
			<label for="type">推荐</label>
			<div class="checkbox">
				<label><input name="tj" type="radio" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp; <input name="tj" type="radio" value="0" checked="checked" />否 </label>
			</div>
		</div>
		<div class="form-group">
			<label for="type">文章内容</label>
			<div>
				<textarea name="content" cols="100" rows="8" style="width:100%; height: 300px;"></textarea>
			</div>
		</div>
	</div>
	<button type="button" class="btn btn-default">Submit</button>
</shiro:hasRole>
<shiro:lacksRole name="admin"><jsp:include page="/noAuthc"/></shiro:lacksRole>
<script src="after/js/addarticle.js" type="text/javascript"></script>
<script type="text/javascript">
	flsel();
</script>