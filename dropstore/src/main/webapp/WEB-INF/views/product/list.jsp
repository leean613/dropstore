<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<h2> </h2>
<c:forEach var="p" items="${list}" >
	<div class="col-sm-4">
	<div class="thumbnail">
      <a href="/product/detail/${p.id}"> <%-- --%>
        <img class="dropstore-prod" src="/static/anh/lights.jpg"/>
      </a>
        <div class="caption">
          <p class="caption1">${p.name}</p>
           </div>
        <div class="pull-right" data-id="${p.id}">
      	<button class="btn btn-dm btn-danger btn-cart">	
      	<i class="glyphicon glyphicon-shopping-cart"></i>
      	</button>
      	<button class="btn btn-dm btn-success btn-star">	
      	<i class="glyphicon glyphicon-star"></i>
      	</button>
      	<button class="btn btn-dm btn-warning">	
      	<i class="glyphicon glyphicon-share"></i>
      	</button>
      	</div>
		  <p><fmt:formatNumber value =" ${p.unitprice}"  type = "number" maxIntegerDigits = "12"/>đ </p> 
       
    </div>
	
	
	</div>	
</c:forEach>