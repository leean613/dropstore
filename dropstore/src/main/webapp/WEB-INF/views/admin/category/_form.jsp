<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="${base}/index" modelAttribute="entity">


 	<div class="panel panel-default">
  	<div class="panel-body">
  	<div class="form-group" >
	<label>Id</label>
	<form:input path="id" class="form-control" readonly="true"/> <%--  --%>
	</div>
	
	<div class="form-group" >
	<label>NameVN</label>
	<form:input path="nameVN" class="form-control"/>
	</div>
	<div class="form-group" >
	<label>Name</label>
	<form:input path="name" class="form-control"/>
	</div>
  	<div class="form-group" >
	<button class="btn btn-primary" style="display:${empty entity.id?'inline':'none'};" formaction="${base}/create">Create</button>	
	<button class="btn btn-warning" style="display:${empty entity.id?'none':'inline'};" formaction="${base}/update">Update</button>	
	<button class="btn btn-danger" formaction="${base}/delete">Delete</button>	
	<a class="btn btn-default" href="${base}/index">Reset</a>	
	
</div>
  </div>
  </div>	

</form:form>