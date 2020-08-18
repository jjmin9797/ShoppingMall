<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

	<title>kubg</title>
</head>
<body>
<div id = "root">
	<header id = "header">
		<div id="header_box">
			<%@ include file = "include/header.jsp" %>
		</div>
	</header>
</div>

<div id = "nav">
	<header id = "nav_box">
		<div id="header_box">
			<%@ include file = "include/nav.jsp" %>
		</div>
	</header>
</div>

	<section id = "container">
		<div id="container_box">
			본문내용
		</div>
	</section>

	<footer id = "footer">
		<div id = "footer_box">
			<%@ include file="include/footer.jsp" %>
		</div>
	</footer>

</body>
</html>
