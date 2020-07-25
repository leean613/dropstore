<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-hover">
<thead>
	<tr>
		<th>Id</th>
		
		<th>Email</th>
		
		<th>Full Name</th>
		
		<th>Activated</th>
		
		<th>Admin</th>
		
		
		<th></th>
	</tr>
</thead>
<tbody>
	<c:forEach var="e" items="${list}">
	<tr>
		<td>${e.id}</td>
		
		<td>${e.email}</td>
		
		<td>${e.fullname}</td>
		
		<td>${e.activated?'Yes':'No'}</td>
		
		<td>${e.admin?'Admin':'User'}</td>
		
		<td>
			<a class="btn btn-sm btn-info" href="${base}/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-info" href="${base}/delete/${e.id}">Delete</a>
	
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>