<%@page pageEncoding="utf-8"%>
<h2>Đăng nhập</h2>
<h3>${message}</h3>
<form action="/account/change" method="post">
<div class="form-group" >
	<label>Username</label>
	<input name="id" class="form-control" value="${param.id}">
</div>
<div class="form-group">
	<label>Password</label>
	<input name="pw" class="form-control">
</div>
<div class="form-group">
	<label>New password</label>
	<input name="pw1" class="form-control">
</div>
<div class="form-group">
	<label>Confirm password</label>
	<input name="pw2" class="form-control">
</div>
<div class="form-group">
	<button class="btn btn-default">Update</button>	
</div>
</form>
