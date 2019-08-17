<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>cart</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<style >
/* removeAll */

.sunil {
color: red;
position: relative;
	border-radius: 3px;
    margin-top: -80px;
	margin-left: 370px;

}

.buton {
	border: 0;
	padding: 4px 8px;
	background-color: #c66;
	color: #fff;
	font-family: "HelveticaNeue-Medium", "Helvetica Neue Medium";
	font-size: 12px;
	border-radius: 3px;
    margin-top: -100px;
	margin-left: 1222px;
}

/* continue shopping */
.button {
	display: inline-block;
	border-radius: 4px;
	background-color: green;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 21px;
	padding: 20px;
	width: 280px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 25px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: relative;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

.product-image {
	float: left;
	width: 20%;
}

.product-details {
	float: left;
	width: 37%;
}

.product-price {
	float: left;
	width: 12%;
}

.product-image {
	float: left;
	width: 12%;
	zoom: 1;
}

.product-quantity {
	float: left;
	width: 10%;
}

.product-removal {
	float: left;
	width: 9%;
}

.product-line-price {
	float: left;
	width: 12%;
	text-align: right;
}

/* This is used as the traditional .clearfix class */
.group:before, .shopping-cart:before, .column-labels:before, .product:before,
	.totals-item:before, .group:after, .shopping-cart:after, .column-labels:after,
	.product:after, .totals-item:after {
	content: '';
	display: table;
}

.group:after, .shopping-cart:after, .column-labels:after, .product:after,
	.totals-item:after {
	clear: both;
}

.group, .shopping-cart, .column-labels, .product, .totals-item {
	zoom: 1;
}

/* Apply clearfix in a few places */
/* Apply dollar signs */
.product .product-price:before, .product .product-line-price:before,
	.totals-value:before {
	content: '';
}

/* Body/Header stuff */
body {
	padding: 0px 30px 30px 20px;
	font-family: "HelveticaNeue-Light", "Helvetica Neue Light",
		"Helvetica Neue", Helvetica, Arial, sans-serif;
	font-weight: 100;
}

h1 {
	font-weight: 100;
}

label {
	color: #aaa;
}

.shopping-cart {
	margin-top: -45px;
}

/* Column headers */
.column-labels label {
	padding-bottom: 15px;
	margin-bottom: 15px;
	border-bottom: 1px solid #eee;
}

.column-labels .product-image, .column-labels .product-details,
	.column-labels .product-removal {
	text-indent: -9999px;
}

/* Product entries */
.product {
	margin-bottom: 20px;
	padding-bottom: 10px;
	border-bottom: 1px solid #eee;
}

.product .product-image {
	text-align: center;
}

.product .product-image img {
	width: 100px;
}

.product .product-details .product-title {
	margin-right: 20px;
	font-family: "HelveticaNeue-Medium", "Helvetica Neue Medium";
}

.product .product-details .product-description {
	margin: 5px 20px 5px 0;
	line-height: 1.4em;
}

.product .product-quantity input {
	width: 40px;
}

.product .remove-product {
	border: 0;
	padding: 4px 8px;
	background-color: #c66;
	color: #fff;
	font-family: "HelveticaNeue-Medium", "Helvetica Neue Medium";
	font-size: 12px;
	border-radius: 3px;
}

.product .remove-product:hover {
	background-color: #a44;
}

/* Totals section */
.totals .totals-item {
	float: right;
	clear: both;
	width: 100%;
	margin-bottom: 10px;
}

.totals .totals-item label {
	float: left;
	clear: both;
	width: 79%;
	text-align: right;
}

.totals .totals-item .totals-value {
	float: right;
	width: 21%;
	text-align: right;
}

.totals .totals-item-total {
	font-family: "HelveticaNeue-Medium", "Helvetica Neue Medium";
}

.checkout {
	float: right;
	border: 0;
	margin-top: 20px;
	padding: 6px 25px;
	background-color: #6b6;
	color: #fff;
	font-size: 25px;
	border-radius: 3px;
}

.checkout:hover {
	background-color: #494;
}

/* Make adjustments for tablet */
@media screen and (max-width: 650px) {
	.shopping-cart {
		margin: 0;
		padding-top: 20px;
		border-top: 1px solid #eee;
	}
	.column-labels {
		display: none;
	}
	.product-image {
		float: right;
		width: auto;
	}
	.product-image img {
		margin: 0 0 10px 10px;
	}
	.product-details {
		float: none;
		margin-bottom: 10px;
		width: auto;
	}
	.product-price {
		clear: both;
		width: 70px;
	}
	.product-quantity {
		width: 100px;
	}
	.product-quantity input {
		margin-left: 20px;
	}
	.product-quantity:before {
		content: 'x';
	}
	.product-removal {
		width: auto;
	}
	.product-line-price {
		float: right;
		width: 70px;
	}
}
/* Make more adjustments for phone */
@media screen and (max-width: 350px) {
	.product-removal {
		float: right;
	}
	.product-line-price {
		float: right;
		clear: left;
		width: auto;
		margin-top: 10px;
	}
	.product .product-line-price:before {
		content: 'Item Total: Rs:';
	}
	.totals .totals-item label {
		width: 60%;
	}
	.totals .totals-item .totals-value {
		width: 40%;
	}
}
</style>

<!-- <script type="text/javascript">
 
	function total()
	{
	alert("hi");
	var priceall=document.getElementsByClassName("price");
	alert(priceall);
	var p=[];
	for(i=0;i<priceall.length;i++)
	{
	alert(priceall.length);
	p.push(priceall[i].value)
	alert(p.push(priceall[i].value));
	}
	var arr=p;
	alert(arr);
	var s=0;
	for(j=0;j<arr.length;j++){
	s=s+parseInt(arr[j]);}
	alert(s);
	document.getElementById("tot").innerHTML=s;

	document.getElementById("dis").innerHTML=s*0.10;
     document.getElementById("shi").innerHTML=100;
	document.getElementById("total").innerHTML=s-(s*0.10)+100;
	}
   -->

 </script>

</head>
<body>

   
	<h1>Cart Details</h1>

	<div class="shopping-cart">
		<div class="column-labels">
			<label class="product-image">Image</label> <label
				class="product-details">Product</label> <label class="product-price">Price</label>
			<label class="product-quantity">Quantity</label> <label
				class="product-removal">Remove</label> <label
				class="product-line-price">Total</label>
		</div>
		<c:if test="${empty cartitemlist }">
			<p>No Items</p>
		</c:if>
		<c:forEach items="${cartitemlist}" var="cart">
			<div class="product">

				<div class="product-details">
					  <p>${cart.id }
					<div class="product-title">
						<h4><b>${cart.name }</b></h4>
					</div>
					<p style = "font-family:georgia,garamond,serif;font-size:14px;font-style:bold;">${cart.description }</p>
				</div>

				<div class="product-image">
					<img
						src="<c:url value="/resource/images/products/${cart.product_CartId}.jpg"/>"
						style="width: 100px; height: 90px;">

				</div>
				<div class="product-price">&#x20B9; ${cart.unitPrice }</div>
				
<!-- 				inc and dec quantity  -->
				<div class="product-quantity">
					<input value="${cart.quantity }" onchange="total()" class="qty">
					
				<a href="incQuantity?cartId=${cart.id}&qty=${cart.quantity}&price=${cart.price}&productId=${cart.product_CartId}">
				<input type="range" onclick="total()">
				 </a>
				<br>
				<a href="decQuantity?id=${cart.id}&qty=${cart.quantity}&price=${cart.price}&productId=${cart.product_CartId}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="range" onclick="total()">
				 </a>
					
				</div>

				<div class="product-removal">
					<a href="cart/remove/${cart.id}">
						<button class="remove-product">Remove</button>
					</a>
				</div>

				<div class="product-line-price">&#x20B9; ${cart.price }</div>
			</div>
		</c:forEach>

	<a href="index1">
		<button class="button" style="vertical-align: middle">
			<span>Continue Shopping </span>
		</button>
	</a>

        <a href="removeAllCartItems">
			<button class="buton">removeAll</button>
		</a>

<!-- 		 <div class="totals">
			<div class="totals-item">
				<label>Subtotal</label>
				<div class="totals-value" id="cart-subtotal">&#x20B9;<p id="tot"></p> </div>
			</div>
			<div class="totals-item">
				<label>Tax (5%)</label>
				<div class="totals-value" id="cart-tax">&#x20B9;<span style="color:red;" id="dis"></span> </div>
			</div>
			<div class="totals-item">
				<label>Shipping</label>
				<div class="totals-value" id="cart-shipping">&#x20B9;<span style="color:red;" id="shi"></span></div>
			</div>
			<div class="totals-item totals-item-total">
				<label>Grand Total</label>
				<div class="totals-value" id="cart-total">&#x20B9; <span style="color:red;" id="total"></span></div>
			</div> 		
		</div>
 -->		
 <h4 class="sunil">${message }</h4>
		<a href="checkout">
		<button class="checkout">Checkout</button>
		</a>
	</div>
</body>
</html>