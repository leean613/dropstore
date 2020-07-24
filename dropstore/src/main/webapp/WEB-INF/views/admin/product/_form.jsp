<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="${base}/index" modelAttribute="entity" enctype="multipart/form-data">


 	<div class="panel panel-default">
  	<div class="panel-body">
  	
  	
  	<div class="row">
  	<div class="form-group col-sm-6" >
	<label>Id</label>
	<form:input path="id" class="form-control" readonly="true"/> <%--  --%>
	</div>
	
	<div class="form-group col-sm-6" >
	<label>Name</label>
	<form:input path="name" class="form-control"/>
	</div>
	</div>
	<div class="row">
	<div class="form-group col-sm-6" >
	<label>Loại</label>
	<form:select path="category.id" class="form-control">
	<form:options items="${cates}" itemLabel="NameVN" itemValue="id" />
	</form:select>
	</div>
	

 	<div class="form-group col-sm-6" >
	<label>Giá</label>
	<form:input path="unitprice" class="form-control"/>
	</div>
	</div>
	<div class="row">
	<div class="form-group col-sm-6" >
	<label>Ngày nhập </label>
	<form:input path="productDate" class="form-control"/>
	</div>
	<div class="form-group col-sm-6" >
	<label>Available</label>
	<div class="form-control">
	<form:radiobutton path="available" value="true" label="Yes"/>
	
	<form:radiobutton path="available" value="false" label="No"/>
	</div> 
	</div>
	</div>
	<div class="row">
	<div class="form-group col-sm-6" >
	<label>Quantity</label>
	<form:input path="quantity" class="form-control"/>
	</div>
	<div class="form-group col-sm-6" >
	<label>Special</label>
	<div class="form-control">
	<form:radiobutton path="special" value="true" label="Yes"/>
	
	<form:radiobutton path="special" value="false" label="No"/>
	<%-- <form:input path="special" class="form-control"/>--%>
	</div>
	</div>

	</div>
	<div class="row">
	<div class="form-group col-sm-6" >
	<label>Discount</label>
	<form:input path="discount" class="form-control"/>
	</div>
	
	<div class="form-group col-sm-6" >
	<label>View Count</label>
	<form:input path="viewCount" class="form-control"/>
	</div>
	</div>
	
	<div class="row">
	<div class="form-group col-sm-12" >
	<label>Photo</label>
	<input type="file" name="photo_file" class="form-control">
	<form:hidden path="image"/>
	
	</div>
	</div>
	<div class="row">
	
	<div class="form-group col-sm-12" >
	<label>Description</label>
	<form:textarea path="description" rows="4" class="form-control"/>
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