$(function(){
	$(".btn").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		login(username, password);
	});
});
function login(username, password) {
	$.ajax({
		url : '/checkLogin',
		type : 'post',
		cache : false,
		async : false,
		datatype : 'json',
		data : {
			'username' : username,
			'password' : password
		},
		success : function(res) {
			if (res.status == '500') {
				var d = dialog({
					title : '提示消息',
					content : '用户与密码不匹配!',
					cancelValue : '确 定',
					cancel : function() {
					}
				});
				d.show();
				return false;
			}
			if (res.status == '200') {
				$("#loginForm").attr("action", "/back").attr("method", "post");
				$("#loginForm").submit();
			}
		}
	});
};