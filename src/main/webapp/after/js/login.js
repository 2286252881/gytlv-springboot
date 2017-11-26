$(function(){
	$(".btn").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var rememberMe = $("#rememberMe").is(':checked');
		console.log(rememberMe);
		login(username, password,rememberMe);
	});
});
function login(username, password,rememberMe) {
	$.ajax({
		url : '/checkLogin',
		type : 'post',
		cache : false,
		async : false,
		datatype : 'json',
		data : {
			'username' : username,
			'password' : password,
			'rememberMe': rememberMe
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
				$("#loginForm").attr("action", "/").attr("method", "post");
				$("#loginForm").submit();
			}
		}
	});
};