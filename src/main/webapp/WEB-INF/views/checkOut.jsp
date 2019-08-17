<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<head>
<style>
@import
	url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css")
	;


.checkout {
	float: right;
	border: 0;
	margin-top: 20px;
	padding: 6px 25px;
	background-color: #2244;
	color: #fff;
	font-size: 25px;
	border-radius: 3px;
}

.checkout:hover {
	background-color: #2564;
}

.track_tbl td.track_dot {
	width: 50px;
	position: relative;
	padding: 0;
	text-align: center;
}

.track_tbl td.track_dot:after {
	content: "\f111";
	font-family: FontAwesome;
	position: absolute;
	margin-left: -5px;
	top: 11px;
}

.track_tbl td.track_dot span.track_line {
	background: #000;
	width: 3px;
	min-height: 50px;
	position: absolute;
	height: 101%;
}

.track_tbl tbody tr:first-child td.track_dot span.track_line {
	top: 30px;
	min-height: 25px;
}

.track_tbl tbody tr:last-child td.track_dot span.track_line {
	top: 0;
	min-height: 25px;
	height: 10%;
}
</style>

<meta charset="ISO-8859-1">
<title>Chech Out</title>
</head>
<body>
	<!-- <div class="p-4"> -->
	<center>
		<h1>Thank You!</h1>
		<h2>For your Orders: ${uName }</h2>
		<h3>Your Order Id: <%=(int)(Math.random()*1000) %> </h3>
	</center>
	<table class="table table-bordered track_tbl">

		<thead>
			<tr>
				<th></th>
				<th>Product Id</th>
				<th>Your Order Items</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty cartitemlist }">
				<p>No Items</p>
			</c:if>
			<c:forEach items="${cartitemlist}" var="cart">


				<tr class="active">
					<td class="track_dot"></td>
					<td>${cart.id }</td>
					<td>${cart.name }</td>
					<td>${cart.description }</td>
					<td>${cart.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Price:${sum }</h4>
	</div>
<a href="http://localhost:8080/CartApplication/myCartPageDetails">
		<button class="checkout">Go Back</button>
		</a>
</body>
</html>