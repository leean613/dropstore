<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"   %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online shopping mall</title>
<tiles:insertAttribute name="head"></tiles:insertAttribute>		
</head>
<body>

	<div class="container">
		<header class="row">
		<h1 class="alert alert-success">Online Shopping Mall</h1>
		</header>
		<nav class="row">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>		
		</nav> 
		<div class="row">
			<article class="col-sm-9">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>		
			
			</article>
			<aside class="col-sm-3">
				<tiles:insertAttribute name="aside"></tiles:insertAttribute>		
			</aside>
			</div>
		<footer class="row">
		<p class="text-center"> &copy; 2019.All rights reserved.</p>
		</footer>
	</div>

</body>
</html>
