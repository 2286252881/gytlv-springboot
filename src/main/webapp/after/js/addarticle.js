//加载文本编辑器
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		filePostName : "uploadFile",
		uploadJson : '/pic/upload',
		dir : "image"
	});
});
// addArticle
flsel = function() {
	$.ajax({
		url : '/showArticlesTypesAgain',
		type : 'get',
		dataType : 'json',
		success : function(data) {
			$("#articleType option").remove();
			$("#articleType").append('<option value="0">请选择</option>');
			$.each(data, function(i) {
				$("#articleType").append(
						" <option value=\"" + data[i].id + "\">"
								+ data[i].articletypename + "</option>");
			});
		}
	});
}
// selected
onseltd = function(obj) {
	var typeid = $(obj).children('option:selected').val();
}
// 提交表单
$(".btn").click(function() {
	var articlename = $("#title").val();
	var articletype = $("#articleType").val();
	var articlesupport = $("input[name='tj']:checked").val();
	var articlecontent = editor.html();
	if (articlename == '') {
		var d = dialog({
			title : '提示消息',
			content : '文章标题不能为空!',
			cancelValue : '确 定',
			cancel : function() {
			}
		});
		d.show();
		return;
	}
	if (articletype == '0') {
		var d = dialog({
			title : '提示消息',
			content : '请选择文章类型!',
			cancelValue : '确 定',
			cancel : function() {
			}
		});
		d.show();
		return;
	}
	if (articlecontent == '') {
		var d = dialog({
			title : '提示消息',
			content : '请填写文章内容!',
			cancelValue : '确 定',
			cancel : function() {
			}
		});
		d.show();
		return;
	}
	$.ajax({
		url : '/addArticle',
		type : 'post',
		cache : false,
		async : false,
		datatype : 'json',
		data : {
			'articlename' : articlename,
			'articletype' : articletype,
			'articlesupport' : articlesupport,
			'articlecontent' : articlecontent
		},
		success : function(res) {
			if (res.status = '200') {
				var d = dialog({
					title : '提示消息',
					content : '添加文章成功!',
					cancelValue : '确 定',
					cancel : function() {
					}
				});
				d.show();
				$("#title").val("");
				$("#articleType").val("");
				$("input[name='tj']:checked").val("");
				editor.html("");
			}
		}
	});
});
