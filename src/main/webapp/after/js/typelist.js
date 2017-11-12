// 文章分类
var wzfl = function() {
	$.ajax({
		url : '/showType',
		type : 'post',
		async : true,
		dataType : 'json',
		data : {
			page : 1,
			size : 0
		},
		success : function(data) {
			$("#tb1 tr").remove();
			$.each(data.data, function(i) {
				var str = "<tr>"
				str += '<td>' + data.data[i].id + '</td>'
				str += '<td>' + data.data[i].username + '</td>'
				str += '<td>' + data.data[i].nickname + '</td>'
				str += '<td>' + data.data[i].articletypename + '</td>'
				str += '<td>' + data.data[i].createtime + '</td>'
				str += '<td>' + data.data[i].articleCount + '&nbsp;篇</td>'
				str += "</tr>"
				$("#tb1").append(str);
			});
			var options = {
				bootstrapMajorVersion : 3,
				currentPage : data.page, // 当前页数
				totalPages : data.count, // 总页数
				itemTexts : function(type, page, current) {
					switch (type) {
					case "first":
						return "首页";
					case "prev":
						return "上一页";
					case "next":
						return "下一页";
					case "last":
						return "末页";
					case "page":
						return page;
					}
				},
				onPageClicked : function(event, originalEvent, type, page) {
					$.ajax({
						url : '/showType',
						type : 'post',
						dataType : 'json',
						data : {
							page : page,
							size : 0
						},
						success : function(data) {
							$("#tb1 tr").remove();
							$.each(data.data, function(i) {
								var str = "<tr>"
								str += '<td>' + data.data[i].id + '</td>'
								str += '<td>' + data.data[i].username + '</td>'
								str += '<td>' + data.data[i].nickname + '</td>'
								str += '<td>' + data.data[i].articletypename
										+ '</td>'
								str += '<td>' + data.data[i].createtime
										+ '</td>'
								str += '<td>' + data.data[i].articleCount
										+ '&nbsp;篇' + '</td>'
								str += "</tr>"
								$("#tb1").append(str);
							});
						}
					});
				}
			}
			$('#parger').bootstrapPaginator(options);
		}
	});
}
