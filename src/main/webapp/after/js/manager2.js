var zTreeObj;
var setting = {
	callback : {
		onClick : zTreeOnClick
	}
};
function zTreeOnClick(event, treeId, treeNode) {
	if (!treeNode.isParent) {
		var url = treeNode.ahref;
		var toPage = '';
		if (url != '') {
			$("#page").load(url);
		}
	}
};
var zNodes;
$(function() {
	$.ajax({
		type : 'post',
		url : '/getAllTree',
		async : true,
		dataType : 'json',
		success : function(data) {
			zTreeObj = $.fn.zTree.init($("#ztree"), setting, data);
			zTreeObj.expandAll(true);
			var treeNode = zTreeObj.getNodeByParam("id", 6);
			zTreeObj.selectNode(treeNode);
			$("#page").load(treeNode.ahref);
		}
	});
});