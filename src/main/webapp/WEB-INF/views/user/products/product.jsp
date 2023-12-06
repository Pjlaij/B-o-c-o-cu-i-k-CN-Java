<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style type="text/css">
	.product-content{
		overflow-x:hidden;
		
	}
</style>
</head>
<body>
	<div class="span9">
    <ul class="breadcrumb">
    <li><a href="<c:url value="/"/>">Trang chủ</a> <span class="divider">/</span></li>
    <li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
    <li class="active">Chi tiết sản phẩm</li>
    </ul>	
	<div class="well well-small">
	<div class="row-fluid">
			<div class="span5">
			<div id="myCarousel" class="carousel slide cntr">
                <div class="carousel-inner">
                  <div class="item active">
                   <a href="#"> <img src="<c:url value="/assets/user/img/${product.img }"/>" alt="" style="width:100%"></a>
                  </div>
                  <div class="item">
                     <a href="#"> <img src="<c:url value="/assets/user/img/${product.img }"/>" alt="" style="width:100%"></a>
                  </div>
                  <div class="item">
                    <a href="#"> <img src="<c:url value="/assets/user/img/${product.img }"/>" alt="" style="width:100%"></a>
                  </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
            </div>
			</div>
			<div class="span7">
				<h3>${product.name } [${product.price }đ]</h3>
				<hr class="soft"/>
				
				<form class="form-horizontal qtyFrm" method = "get" action="<c:url value="/AddCart/${product.id_product }"/>">
				  <div class="control-group">
					<label class="control-label"><span>${product.price }</span></label>
					<div class="controls">
					<input type="number" min="0" class="span6">
					</div>
				  </div>

				  <h4>${product.title }</h4>
				  <p>
				  <p>
				  <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span>Thêm giỏ hàng</button>
				</form>
			</div>
			</div>
				<hr class="softn clr"/>
<div><div>

            <ul id="productDetail" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
            <div class="tab-pane fade active in" id="home">
			 	${product.details }
			</div>
	
				</div>
            </div>

</div>

</div> <!-- Body wrapper -->
</body>
