<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>Order list</h2>
<h3>${message}</h3>

<table class="table">
<thead>
	<tr>
		<th>Id </th>
		<th>date</th>
		<th>address</th>
		<th>amount</th>
			
	</tr>
</thead>
<tbody>
	<c:forEach var="o" items="${orders}">
	<tr>
	
		<td>${o.id}</td>
		<td>${o.orderDate}</td>
		
		<td>${o.address}</td>
		<td><fmt:formatNumber value="${o.amount}" type="number" maxIntegerDigits ="9"></fmt:formatNumber>đ</td>
		<td>
		<a href="/order/detail/${o.id}">Detail</a>
		</td>
			
	</tr>
	</c:forEach> 
</tbody>
</table>


