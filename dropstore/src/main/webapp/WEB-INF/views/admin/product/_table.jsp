<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-hover">
<thead>
	<tr>
		<th>Id</th>
		
		<th>Tên</th>
		
		<th>Loại</th>
		
		<th>Giá</th>
		
		<th>Ngày nhập</th>
		
		<th>Available</th>
		
		<th>Quantity</th>
		
		
		
		<th>Discount</th>
		
		<th>View</th>
		
		<th>Special</th>
		
		<th></th>
	</tr>
</thead>
<tbody>
	<c:forEach var="e" items="${list}">
	<tr>
		<td>${e.id}</td>
		
		<td>${e.name}</td>
		
		
		<td>${e.category.name}</td>
		
		
		<td>${e.unitprice}</td>
		
		<td>${e.productDate}</td>
		
		<td>${e.available?'Yes':'No'}</td>
		
		<td>${e.quantity}</td>
		

		
		<td>${e.discount}</td>
		
		<td>${e.viewCount}</td>
		
		<td>${e.special?'Yes':'No'}</td>
		
		<td>
			<a class="btn btn-sm btn-info" href="${base}/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-info" href="${base}/delete/${e.id}">Delete</a>
	
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>