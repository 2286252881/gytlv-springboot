<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<shiro:hasRole name="admin">
	<div class="thumbnail">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>编号</th>
					<th>创建人</th>
					<th>用户昵称</th>
					<th>文章标题</th>
					<th>文章类型</th>
					<th>创建时间</th>
				</tr>
			</thead>
			<tbody id="tb2">
			</tbody>
		</table>
	</div>
	<ul id="parger2" class="pagination"></ul>
</shiro:hasRole>
<shiro:lacksRole name="admin"><jsp:include page="/noAuthc"/></shiro:lacksRole>
<script src="after/js/articlelist.js" type="text/javascript"></script>
<script type="text/javascript">
	wzlb();
</script>