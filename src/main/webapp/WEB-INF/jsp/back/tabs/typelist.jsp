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
					<th>类型名称</th>
					<th>创建时间</th>
					<th>文章数</th>
				</tr>
			</thead>
			<tbody id="tb1">
			</tbody>
		</table>
	</div>
	<ul id="parger" class="pagination"></ul>
</shiro:hasRole>
<shiro:lacksRole name="admin">对不起，你没有权限访问！</shiro:lacksRole>
<script src="after/js/typelist.js" type="text/javascript"></script>
<script type="text/javascript">
	wzfl();
</script>