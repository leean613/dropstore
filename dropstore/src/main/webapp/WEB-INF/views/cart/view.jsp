<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>Shopping cart</h2>
<table class="table">
<thead>
	<tr>
		<th>Id </th>
		<th>Name</th>
		<th>Unit price</th>
		<th>Discount</th>
		<th>Quantity</th>
		<th>Amount</th>
			
	</tr>
</thead>
<tbody>
	<c:forEach var="p" items="${sessionScope['scopedTarget.cartsService'].items}">
	<tr data-id="${p.id}" data-price="${p.unitprice}" data-discount="${p.discount}">
	
		<td>${p.id}</td>
		<td>${p.name}</td>
		<td><fmt:formatNumber value="${p.unitprice}" type="number" maxIntegerDigits ="9"></fmt:formatNumber>đ</td>
		<td>${p.discount}%</td>
		<td><input value="${p.quantity}" type="number" min="1" style="width:55px"> </td>
		<td class="amt" ><fmt:formatNumber  value="${p.quantity*p.unitprice*(1-0.01*p.discount)}" type = "number" maxIntegerDigits = "9"></fmt:formatNumber>đ</td> <%--<fmt:formatNumber  value="${p.quantity*p.unitprice*(1-0.01*p.discount)}" type = "number" maxIntegerDigits = "9"></fmt:formatNumber> --%>
		<td>
		<button class="btn btn-sm btn-warning pull-right btn-cart-remove" >
			<i class="	glyphicon glyphicon-trash"></i>
		</button>
		
		</td>
	</tr>
	</c:forEach> 
</tbody>
<tfoot>
</tfoot>
</table>
<button class="btn btn-sm btn-danger pull-left btn-cart-clear" >Clear
			
</button>
<button class="btn btn-sm btn-info  pull-left" >Continue
			
</button>
<button class="btn btn-sm btn-success pull-left" >Checkout
			 
</button>