<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="${base}/index" modelAttribute="entity" enctype="multipart/form-data">


 	<div class="panel panel-default">
  	<div class="panel-body">
  	
  	
  	<div class="row">
  	<div class="form-group col-sm-6" >
	<label>Id</label>
	<form:input path="id" class="form-control" /> <%--  --%>
	</div>
	
	<div class="form-group col-sm-6" >
	<label>Full name</label>
	<form:input path="fullname" class="form-control"/>
	</div>
	</div>
	
	<div class="row">
	<div class="form-group col-sm-6" >
	<label>Email </label>
	<form:input path="email" class="form-control"/>
	</div>
	<div class="form-group col-sm-6" >
	<label>Admin</label>
	<div class="form-control">
	<form:radiobutton path="admin" value="true" label="Admin"/>
	
	<form:radiobutton path="admin" value="false" label="User"/>
	</div> 
	</div>
	
	</div>
	
	
	<div class="row">
	
	<div class="form-group col-sm-6" >
	<label>Activated</label>
	<div class="form-control">
	<form:radiobutton path="activated" value="true" label="Yes"/>
	
	<form:radiobutton path="activated" value="false" label="No"/>
	<%-- <form:input path="special" class="form-control"/>--%>
	</div>
	</div>
	<div class="form-group col-sm-6" >
	<label>Password</label>
	<form:input path="password" class="form-control"/>
	
	</div>
	

	</div>
	
	
	<div class="row">
	<div class="form-group col-sm-12" >
	<label>Photo</label>
	<input type="file" name="photo_file" class="form-control">
	<form:hidden path="photo"/>
	<a href="#"> <%-- --%>
        <img  style="height: 242.5px;" src="${entity.photo}"/> <%--  --%>
      </a>
	</div>
	</div>
	
	<div class="row">
  	<div class="form-group col-sm-6" >
	<button class="btn btn-primary" style="display:${empty entity.id?'inline':'none'};"  formaction="${base}/create" >Create</button>	<%--style="display:${empty entity.id?:'none':'inline'"} --%>
	<button class="btn btn-warning" style="display:${empty entity.id?'none':'inline'};"  formaction="${base}/update">Update</button>	
	<button class="btn btn-danger" formaction="${base}/delete">Delete</button>	
	<a class="btn btn-default" href="${base}/index">Reset</a>	
	</div>
	</div>

  </div>
  </div>	

</form:form>
