<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home/index">Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/home/aboutus">About Us</a></li>
      <li><a href="/home/contactus">Contact Us</a></li>
      <li><a href="/home/feedback">Feedback</a></li>
   	  <li><a href="/home/faqs">FAQs</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Tài khoản: ${sessionScope.user.getId()}<span class="caret"></span></a>
        <c:choose>
        <c:when test="${empty sessionScope.user}">
        	<ul class="dropdown-menu">
          <li><a href="/account/login" class="signin">Đăng nhập</a></li>
          <li><a href="/account/register">Đăng kí</a></li>
          <li><a href="#">Quên mật khẩu</a></li>
         
        	</ul>
        </c:when>
        <c:otherwise> 
         <ul class="dropdown-menu">
          
          <li><a href="/account/logoff">Đăng xuất</a></li>
          <li><a href="/account/change">Đổi mật khẩu</a></li>
          <li><a href="/account/edit">Cập nhập tài khoản</a></li>
          <li><a href="/cart/view">Đơn hàng</a></li>
          
        </ul>
        
        </c:otherwise>
        </c:choose>
        
         
      </li>
    	
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"> Tiếng Việt </a></li>
      <li><a href="#"> Tiếng Anh  </a></li>
    </ul>
  </div>
</nav>