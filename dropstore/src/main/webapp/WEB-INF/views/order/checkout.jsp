<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>Order list</h2>
<h3>${message}</h3>
<h2>Shopping Cart</h2>
<table class="table">
<thead>
	<tr>
		<th>Id </th>
		<th>Name</th>
		<th>Unit Price</th>
		<th>Discount</th>
		<th>Quantity</th>
		<th>Amount</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="p" items="${sessionScope['scopedTarget.cartsService'].items}">
	<tr data-id="${p.id}">
	
		<td>${p.id}</td>
		<td>${p.name}</td>
		<td><fmt:formatNumber value="${p.unitprice}" type="number" maxIntegerDigits ="9"></fmt:formatNumber>đ</td>
		<td>${p.discount}%</td>
		<td>${p.quantity}%</td>
		<td class="amt" ><fmt:formatNumber  value="${p.quantity*p.unitprice*(1-0.01*p.discount)}" type = "number" maxIntegerDigits = "9"></fmt:formatNumber>đ</td> <%--<fmt:formatNumber  value="${p.quantity*p.unitprice*(1-0.01*p.discount)}" type = "number" maxIntegerDigits = "9"></fmt:formatNumber> --%>
		<td>
		
		
		</td>
	</tr>
	</c:forEach> 
</tbody>
</table>
<h2>Check out</h2>



<form:form action="/order/checkout" modelAttribute="order">
<div class="form-group"> 
	<label>Customer</label>
	<form:input path="customer.id" class="form-control"/>
</div>

<div class="form-group"> 
	<label>Order day</label>
	<form:input path="orderDate" class="form-control"/>
</div>
<div class="form-group"> 
	<label>Shipping address</label>
	<form:input path="address" class="form-control"/>
</div>
<div class="form-group"> 
	<label>Total Amount</label>
<%-- 	<form:input type="text" path="amount" class="form-control"/>--%>
	<form:input path="amount" class="form-control"/>
	
	
</div>
<div class="form-group"> 
	<label>Notes</label>
	<form:textarea path="description" rows="3" class="form-control"/>
</div>


<div class="form-group">
	<button class="btn btn-default">Purchase </button>	
</div>
</form:form>
