<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Edit profile</h2>
<h3>${message}</h3>
<form:form action="/account/edit" modelAttribute="form" enctype="multipart/form-data">
<div class="form-group" >
	<label>Username</label>
	<form:input path="id" class="form-control" readonly="true"/>
</div>
<div class="form-group"> 
	<label>Password</label>
	<form:input path="password" class="form-control" readonly="true"/>
</div>
<div class="form-group"> 
	<label>fullname</label>
	<form:input path="fullname" class="form-control"/>
</div>
<div class="form-group"> 
	<label>Email</label>
	<form:input path="email" class="form-control"/>
</div>
<div class="form-group"> 
	<label>Photo</label>
	<img alt="" src="/static/images_customer/DSC_0526 copy.JPG" style="width: 80px;height: 80px;">
	<input type="file" name="photo_file">
	<form:hidden path="photo" class="form-control"/>
</div>
<div class="form-group">
	<form:hidden path="activated"/>
	
	<form:hidden path="admin"/>
	
</div>

<div class="form-group">
	<button class="btn btn-default">Saving</button>	
</div>
</form:form>
