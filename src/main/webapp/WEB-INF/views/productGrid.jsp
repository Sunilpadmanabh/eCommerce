<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>


#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: white;
  color: #4d6de6;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

#myBtn:hover {
  background-color: #555;
}




* {
    box-sizing: border-box;
}

body {
    margin: 0;
    font-family: Arial;
}

/* The grid: Four equal columns that floats next to each other */
.column {
    float: left;
    width: 25%;
    padding: 15px;
}

/* Style the images inside the grid */
.column img {
    opacity: 0.95; 
    cursor: pointer; 
}

.column img:hover {
    opacity: 1;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* The expanding image container */
.container {
/*     position: relative; */
/*     display: none; */
}

/* Expanding image text */
#imgtext {
    position: absolute;
    bottom: 15px;
    left: 15px;
    color: white;
    font-size: 20px;
}

/* Closable button inside the expanded image */
.closebtn {
    position: absolute;
    top: 10px;
    right: 15px;
    color: white;
    font-size: 35px;
    cursor: pointer;
}











img:hover {
    opacity: 0.5;
    filter: alpha(opacity=50); /* For IE8 and earlier */
}






body {
    font-family: "Lato", sans-serif;
    transition: background-color .5s;
}


#main {
    transition: margin-left .5s;
    padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}


</style>
</head>
<body>
	
	<h2 id="getAllProductsOfOffer"></h2>
	
	
	<h2 id="getAllProductsForMen"></h2>
	<h2 id="getAllProductsForWomen"></h2>
	
					<h4>${User.userName }</h4>
					<h4>${userName }</h4>


	<div class="row" style="padding: 50px 50px; margin-bottom: 20px">
		<c:forEach items="${products}" var="prod">
			<div class="column">
				<a href="getProductById?id=${prod.productId}" target="_blank">
				 <img src="<c:url value="/resource/images/products/${prod.productId}.jpg"/>"
					alt="Norway" class="img-thumbnail"
					opacity: "0.5" style="width: 80%" height="360" hspace="50";
					class="w3-hover-opacity">
				</a>
				<div class="w3-container w3-white" align="center">
					<p>
					<h5 align="center" style='font-family: Verdana;'>
						<b>${prod.productName}</b>
					</h5>

					<h4>
						<span style='font-family: Arial;'>&#8377;
							${prod.productPrice} &nbsp; 
					</h4>

					<h3 align="center">

						<a href="cart/add/${prod.productId}" class="btn btn-primary"
							style="margin-left: 5px"> <span
							class="glyphicon glyphicon-shopping-cart"></span>Add To Cart
						</a>
				</div>
			</div>

		</c:forEach>
	</div>

</body>

</html>