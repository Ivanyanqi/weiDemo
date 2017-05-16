<%--
  Created by IntelliJ IDEA.
  User: 仙人球
  Date: 2017/1/17
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户注册</title>
	<meta name="description" content="这是一个 index 页面">
	<meta name="keywords" content="index">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/icons/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
</head>

<body data-type="generalComponents">
<jsp:include page="header.jsp"/>
<div class="tpl-page-container tpl-page-header-fixed">
<jsp:include page="meun.jsp"/>
	<div class="tpl-content-wrapper">
		<div class="tpl-content-page-title">
			用户注册
		</div>
		<ol class="am-breadcrumb">
			<li><a href="#" class="am-icon-home">首页</a></li>
			<li class="am-active">用户注册</li>
		</ol>
		<div class="tpl-portlet-components">
			<%--<div class="portlet-title">
				<div class="caption font-green bold">
					<span class="am-icon-code"></span> 表单
				</div>
				<div class="tpl-portlet-input tpl-fz-ml">
					<div class="portlet-input input-small input-inline">
						<div class="input-icon right">
							<i class="am-icon-search"></i>
							<input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
					</div>
				</div>
			</div>--%>
			<div class="tpl-block ">
				<div class="am-g tpl-amazeui-form">
					<div class="am-u-sm-12 am-u-md-9">
						<form class="am-form am-form-horizontal" id="registerForm">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">用户名 / Name</label>
								<div class="am-u-sm-9">
									<input type="text" id="user-name" placeholder="姓名 / Name" name="userName">
									<small id="user-name-msg">输入你的名字，让我们记住你。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-password" class="am-u-sm-3 am-form-label">密码 / Password</label>
								<div class="am-u-sm-9">
									<input type="password" id="user-password" placeholder="输入你的密码 / Password" name="password">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-rePassword" class="am-u-sm-3 am-form-label">确认密码 /  Confirm Password</label>
								<div class="am-u-sm-9">
									<input type="password" id="user-rePassword" placeholder="确认密码 /  Confirm Password">
									<small id="user-password-msg"></small>
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
								<div class="am-u-sm-9">
									<input type="email" id="user-email" placeholder="输入你的电子邮件 / Email" name="email">
									<small>邮箱你懂得...</small>
								</div>
							</div>

							<%--<div class="am-form-group">
								<label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
								<div class="am-u-sm-9">
									<input type="tel" id="user-phone" placeholder="输入你的电话号码 / Telephone">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-QQ" class="am-u-sm-3 am-form-label">QQ</label>
								<div class="am-u-sm-9">
									<input type="number" pattern="[0-9]*" id="user-QQ" placeholder="输入你的QQ号码">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-weibo" class="am-u-sm-3 am-form-label">微博 / Twitter</label>
								<div class="am-u-sm-9">
									<input type="text" id="user-weibo" placeholder="输入你的微博 / Twitter">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-intro" class="am-u-sm-3 am-form-label">简介 / Intro</label>
								<div class="am-u-sm-9">
									<textarea class="" rows="5" id="user-intro" placeholder="输入个人简介"></textarea>
									<small>250字以内写出你的一生...</small>
								</div>
							</div>--%>

							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<button type="button" class="am-btn am-btn-primary">注册</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript">
	$(function () {
		$("#user-name").blur(function () {
			var userName = $("#user-name").val();
			if($.trim(userName) == ''){
				$("#user-name-msg").text('用户名不能为空');
				$("#user-name-msg").css('color','red');
				return;
			}
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/getUserName',
				data:{'userName':userName},
				dataType:'text',
				success:function (data) {
					if(data == 0){
						$("#user-name-msg").text('用户名可以使用');
					}else{
						$("#user-name-msg").text('用户名已注册');
						$("#user-name-msg").css('color','red');
					}
				}
			});
		});
		$("#user-rePassword").blur(function () {
			var password = $("#user-password").val();
			var rePassword = $("#user-rePassword").val();
			if($.trim(password) != $.trim(rePassword)){
				$("#user-password-msg").text('密码不一致');
				$("#user-password-msg").css('color','red');
			}else{
				$("#user-password-msg").text('');
			}
		});
	});
</script>
</body>
</html>
