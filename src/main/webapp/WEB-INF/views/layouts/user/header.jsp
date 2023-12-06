<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>


		<header id="header">
			<div class="row">
				<div class="span4">
					<h1>
						<a class="logo" href="<c:url value="/"/>"><span>Twitter
								Bootstrap ecommerce template</span> <img
							src="<c:url value="/assets/user/img/Neon-logo.png"/>"
							alt="bootstrap sexy shop"> </a>
					</h1>
				</div>
				<div class="span4">
					<div class="offerNoteWrapper">
					</div>
				</div>
				<div class="span4 alignR">
					<p>
						<br> <strong> Support (24/7) : 0947333446 </strong><br>
						<br>
					</p>
					<span class="btn btn-mini"><fmt:formatNumber
													type="number" groupingUsed="true" value="${ TotalPriceCart }" />
												₫ <span
						class="icon-shopping-cart"></span></span> <span
						class="btn btn-warning btn-mini">VNĐ</span> 
						
				</div>
			</div>
		</header>

		<!--
Navigation Bar Section 
-->
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a data-target=".nav-collapse" data-toggle="collapse"
						class="btn btn-navbar"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a>
					<div class="nav-collapse">
						<form action="#" class="navbar-search pull-left">
							<input type="text" placeholder="Search"
								class="search-query span2" style ="width=50%">
						</form>
						<ul class="nav pull-right">
						<c:if test="${empty LoginInfo }">
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#"><span class="icon-lock"></span>
									Chưa đăng nhập <b class="caret"></b></a>
						</c:if>
								<c:if test="${not empty LoginInfo }">
								<li><a href="#">${LoginInfo.display_name } <b class="caret"></b></a></li>
								</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>

		