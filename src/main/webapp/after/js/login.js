$(function() {
	$("#login").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var rememberMe = $("#rememberMe").is(':checked');
		console.log(rememberMe);
		login(username, password, rememberMe);
	});
	$("#reg").click(function() {
		window.location.href = '/reg';
	});
	$("#doReg").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var passwordt = $("#passwordt").val();
		var randomcode = $("#randomcode").val();
		doReg(username, password, passwordt,randomcode);
	});
});
function doReg(username, password, passwordt,randomcode) {
	if (username == "") {
		$('#doReg').attr("disabled", "disabled");
		var d = dialog({
			title : '提示消息',
			content : '登录用户不能为空!',
			cancelValue : '确 定',
			cancel : function() {
				$('#doReg').removeAttr("disabled");
			}
		});
		d.show();
		return;
	}
	;
	if (password == "") {
		$('#doReg').attr("disabled", "disabled");
		var d = dialog({
			title : '提示消息',
			content : '登录密码不能为空!',
			cancelValue : '确 定',
			cancel : function() {
				$('#doReg').removeAttr("disabled");
			}
		});
		d.show();
		return;
	}
	;
	if (password != passwordt) {
		$('#doReg').attr("disabled", "disabled");
		var d = dialog({
			title : '提示消息',
			content : '两次输入的密码不一致!',
			cancelValue : '确 定',
			cancel : function() {
				$('#doReg').removeAttr("disabled");
			}
		});
		d.show();
		return;
	}
	;
	if (randomcode =="") {
		$('#doReg').attr("disabled", "disabled");
		var d = dialog({
			title : '提示消息',
			content : '请填写数字验证码!',
			cancelValue : '确 定',
			cancel : function() {
				$('#doReg').removeAttr("disabled");
			}
		});
		d.show();
		return;
	}
	$.ajax({
		url : '/doReg',
		type : 'post',
		cache : false,
		async : false,
		datatype : 'json',
		data : {
			'username' : username,
			'password' : password,
			'randomcode':randomcode
		},
		success : function(res) {
			if (res.status == '500') {
				$('#doReg').attr("disabled", "disabled");
				var d = dialog({
					title : '提示消息',
					content : '该用户名已经被注册!',
					cancelValue : '确 定',
					cancel : function() {
						$('#doReg').removeAttr("disabled");
					}
				});
				d.show();
				return;
			};
			if (res.status == '501') {
				$('#doReg').attr("disabled", "disabled");
				var d = dialog({
					title : '提示消息',
					content : '验证码输入不正确!',
					cancelValue : '确 定',
					cancel : function() {
						$('#doReg').removeAttr("disabled");
					}
				});
				d.show();
				return;
			}
			if (res.status == '200') {
				$("#regForm")[0].reset();
				var d = dialog({
					title : '提示消息',
					content : '注册成功,请登录!',
					cancelValue : '确 定',
					cancel : function() {
						$('#doReg').removeAttr("disabled");
						window.location.href="/login";
					}
				});
				d.show();
			}
		}
	});
}

function randomcode_refresh() {
	$("#randomcode_img").attr('src',
			'/validatecode?time' + new Date().getTime());
}

function login(username, password, rememberMe) {
	$.ajax({
		url : '/checkLogin',
		type : 'post',
		cache : false,
		async : false,
		datatype : 'json',
		data : {
			'username' : username,
			'password' : password,
			'rememberMe' : rememberMe
		},
		success : function(res) {
			if (res.status == '500') {
				$('#login').attr("disabled", "disabled");
				var d = dialog({
					title : '提示消息',
					content : '用户与密码不匹配!',
					cancelValue : '确 定',
					cancel : function() {
						$('#login').removeAttr("disabled");
					}
				});
				d.show();
				return;
			}
			if (res.status == '200') {
				$("#loginForm").attr("action", "/").attr("method", "post");
				$("#loginForm").submit();
			}
		}
	});
};