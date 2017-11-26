//news 5
$
		.ajax({
			url : '/article',
			type : 'POST', // GET
			success : function(data) {
				$
						.each(
								data,
								function(i) {
									var str = "<div>"
									str += '<h4 class="title" style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"><a href="javascript:void(0);" onclick="detail('
											+"'"+data[i].id+"'" + ');">'
									str += data[i].articlename
									str += '</a></h4><p id="desc" style="font-size: 8px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">'
									str += '<span>'
											+ data[i].nickname
											+ '</span>&nbsp;&nbsp;&nbsp;<span>'
											+ data[i].articletime
											+ '</span>&nbsp;&nbsp;&nbsp;<span><a href="/">'
											+ data[i].articletypename
											+ '</a></span>&nbsp;&nbsp;&nbsp; <a href="#" style="text-decoration: none;" title="点击量">'
											+ data[i].articleclick
											+ '</a>&nbsp;阅读</p>'
									str += '<div id="content">'
											+ data[i].articlecontent
											+ '......</div>'
									str += "</div><br/>"
									$("#article").append(str);
								})
			}
		});
// top5
$
		.ajax({
			url : '/support',
			type : 'POST', // GET
			success : function(data) {
				$
						.each(
								data,
								function(i) {
									var str = '<a class="list-group-item glyphicon glyphicon-hand-right" onclick="detail('
										+"'"+data[i].id+"'" 
											+ ')"title="阅读人数:'
											+ data[i].articleclick
											+ '">&nbsp;'
											+ data[i].articlename + '</a>';
									$("#support").append(str);
								});
			}
		});
// click 10
$.ajax({
	url : '/click',
	type : 'POST', // GET
	success : function(data) {
		$.each(data, function(i) {
			var str = '<a class="list-group-item glyphicon" onclick="detail('
				+"'"+data[i].id+"'" + ')" title="阅读人数:' + data[i].articleclick
					+ '">&nbsp;' + data[i].articlename + '</a>';
			$("#click").append(str);
		});
	}
});
function detail(id) {
	window.location.href =id;
}