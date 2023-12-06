<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
<div class="row">

	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="<c:url value="/"/>">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Đăng nhập</li>
    </ul>
	<hr class="soft"/>
	
	<div class="row">
		<div class="span4">
			<div class="well">
			<h5>Đăng ký tài khoản</h5><br/>
			<h3>${status }</h3>
			Nhập địa chỉ email để đăng ký tài khoản.<br/><br/><br/>
			<form:form action="dang-ky" method="POST" modelAttribute="user">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Địa chỉ email</label>
				<div class="controls">
				  <form:input class="span3"  type="email" path="user" placeholder="Email" required="True"/>
				</div>
								<label class="control-label" for="inputEmail">Mật khẩu</label>
				<div class="controls">
				  <form:input class="span3"  type="password" path="password" placeholder="Nhập mật khẩu" required="True"/>
				</div>
								<label class="control-label" for="inputEmail">Họ và tên</label>
				<div class="controls">
				 <form:input class="span3"  type="text" path="display_name" placeholder="Nhập họ và tên " required="True"/>
				</div>
								<label class="control-label" for="inputEmail">Địa chỉ</label>
				<div class="controls">
				  <form:input class="span3"  type="text" path="address" placeholder="Nhập địa chỉ"/>
				</div>
				
			  </div>
			  <div class="controls">
			  <button type="submit" class="btn block">Đăng ký</button>
			  </div>
			</form:form>
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>Đăng nhập hệ thống</h5>
			<h3>${statusLogin }</h3>
			<form:form action="dang-nhap" method ="POST" modelAttribute="user">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
				  <form:input class="span3"  type="email" placeholder="Mời nhập email" path="user"/>
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Mật khẩu</label>
				<div class="controls">
				  <form:input type="password" class="span3" placeholder="Nhập mật khẩu" path="password"/>
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Đăng nhập</button> <a href="#">Quên mật khẩu?</a>
				</div>
			  </div>
			</form:form>
		</div>
		</div>
	</div>	
	
</div>
</div>
</body>
