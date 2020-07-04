<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row"> 
	<div class="col-sm-5">
<img class="detail-img" src="${prod.image}" ></div> <%--viducapnhap } --%>
	
	<div class="col-sm-7">
	
<ul class="detail-info">
  <li> Name: ${prod.name}</li>
  
  <li> Price: <fmt:formatNumber value="${prod.unitprice}" type = "number" maxIntegerDigits = "12" pattern="###,###,###"></fmt:formatNumber>đ  </li> <%-- <fmt:formatNumber value="${prod.unitprice}" type = "number" maxIntegerDigits = "12">đ</fmt:formatNumber> --%>
 
  <li> Available: ${prod.available?'Yes':'No'}</li>
  
  <li> Product Date: <fmt:formatDate value="${prod.productDate}" pattern="dd-MM-yyyy"/></li>
  
  <li> Tên tiếng việt: ${prod.category.nameVN}</li>
  
  <li> Quantity: ${prod.quantity}</li>
  
  <li> Discount: ${prod.discount} %</li>     <%--<fmt:formatNumber value="${prod.discount}" type="percent"></fmt:formatNumber> --%>
  
  <li> ViewCount: ${prod.viewCount}</li>
  
  <li> Special:${prod.special?'Yes':'No'}</li>
  
  
</ul>
	
	</div>
</div>

<div class="text-justify" style="margin-top: 15px">Description: ${prod.description}</div>



<ul class="nav nav-tabs" style="padding-top: 20px">
  <li class="active">
      <a data-toggle="tab"href="#tab1">Cùng loại</a></li>
  <li><a data-toggle="tab" href="#tab2">Yêu thích</a></li>
  <li><a data-toggle="tab" href="#tab3">Đã xem</a></li>
</ul>

			<div class="tab-content">
  <div id="tab1" class="tab-pane fade in active">
   <div>
			<c:forEach var="cungloai" items="${list}">
				<a href="/product/detail/${cungloai.id}"><img class="cungloai-img" src="${cungloai.image}"></a>
			</c:forEach>
	</div>
 </div>
 <div id="tab2" class="tab-pane fade">
   <div>
    		<c:forEach var="yeuthich" items="${favo}" >
 				<a href="/product/detail/${yeuthich.id}" ><img class="cungloai-img" src="${yeuthich.image}" ></a> 
			</c:forEach>
   </div>
 </div>
 <div id="tab3" class="tab-pane fade">
   <div>
   			<c:forEach var="daxem" items="${viewed}" >
  				<a href="/product/detail/${daxem.id}" ><img class="cungloai-img" src="${daxem.image}" ></a> 
</c:forEach>
      </div>
    
    
 </div>
			</div>











