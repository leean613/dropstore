<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home/index">Trang chủ</a>
    </div>
    <ul class="nav navbar-nav">
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Quản lý <span class="caret"></span></a>
       
         <ul class="dropdown-menu">
          
          <li><a href="/admin/category/index">Loại sản phẩm</a></li>
          <li><a href="/admin/product/index">Sản phẩm</a></li>
          <li><a href="#">Người dùng</a></li>
          <li><a href="#">Hoá đơn</a></li>
          
        </ul>
        
      
    
        
         
      </li>
      <li><a href="/home/contactus">Thống kê</a></li>
      <li><a href="/home/feedback">Tài khoản </a></li>
   	       
        </ul>
        
  
  
  </div>
</nav>