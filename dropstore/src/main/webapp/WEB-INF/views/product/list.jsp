<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<h2> </h2>
<c:forEach var="p" items="${list}" >
	<div class="col-sm-4" style="height: 370.5px;">
	<div class="thumbnail" style="height: 350.5px;" >
      <a href="/product/detail/${p.id}">${p.image} <%-- --%>
        <img class="dropstore-prod" style="height: 242.5px;" src="${p.image}"/> <%-- --%>
      </a>
        <div class="caption" style="min-height: 68px">
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