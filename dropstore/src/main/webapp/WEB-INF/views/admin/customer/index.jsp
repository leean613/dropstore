<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Category Manager </h2>
<c:set var="base" value="/admin/customer" scope="request"></c:set>
<h4 class="label label-success">${message}${param.message}</h4>





<ul class="nav nav-tabs">
  <li ><a class="active" data-toggle="tab" href="#home">Product form</a></li><%----%>
  <li><a data-toggle="tab" href="#menu1">Product Table</a></li>
 <li><a data-toggle="tab" href="#menu2">Search Product</a></li>
</ul>

<div class="tab-content">
  
  <div  id="home" class="tab-pane fade in active ">
 
     <jsp:include page="_form.jsp"></jsp:include>

  </div>
 
  
  <div id="menu1" class="tab-pane fade">
 
  <jsp:include page="_table.jsp"></jsp:include>

  </div>
  <div id="menu2" class="tab-pane fade">
 
  <jsp:include page="_table2.jsp"></jsp:include>

  </div>
  
</div>