<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>
<div class="panel panel-default">
  	<div class="panel-heading">Shopping Cart </div>
  	<div class="panel-body">
  		<img src="/static/anh/index.png"  class="col-sm-5">
  		<ul>
  			<li><b id="cart-cnt">${cart.count}</b> mặt hàng</li><%--li> Price: <fmt:formatNumber value="${prod.unitprice}" type = "number" maxIntegerDigits = "12"></fmt:formatNumber>đ  </li>  --%>
  			<li><b id="cart-amt">${cart.amount}</b> đ</li>
  			<li> 
  				<a href="">Xem giỏ hàng </a> 
  			</li>
				
  		</ul>
	</div>
</div>


<div class="panel panel-default">
  	<div class="panel-heading">Tìm kiếm</div>
  	<div class="panel-body">
  	<form action="/product/list-by-keywords" method="post">
  	<input name="keywords" value="${param.keywords}" class="form control" placeholder="Keywords">
  	</form>
	</div>
</div> 
<div class="panel panel-default">
  	<div class="panel-heading">Danh Mục </div>
  	<div class="list-group">
	
  <c:forEach var="c" items="${cates}">
  <a href="/product/list-by-category/${c.id}" class="list-group-item">${c.nameVN}</a>  <%-- /product/list-by-category/${c.id} --%>
  </c:forEach>	
  
	</div>
</div>

<div class="panel panel-default">
  	<div class="panel-heading">Đặc Biệt </div>
  	<div class="list-group">
  <a href="/product/list-by-special/0" class="list-group-item">Hàng mới</a>
  <a href="/product/list-by-special/1" class="list-group-item">Bán chạy</a>
  <a href="/product/list-by-special/2" class="list-group-item">Xem nhiều</a>
  <a href="/product/list-by-special/3" class="list-group-item">Giảm giá</a>
	</div>
</div>


