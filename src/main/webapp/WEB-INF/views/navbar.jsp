<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%@ page isELIgnored="false"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<style>
.sunil {
	color: white;
	font-family: Comic Sans MS;
	transition: 0.9s;
}

#Denim-navbar {
	height: 165px;
	background-color: blue;
	/* For browsers that do not support gradients */
	background-image: linear-gradient(to bottom right, blue, #01FF70);
	/* Standard syntax (must be last) */
	color: #FFFFFF;
}

.row1 {
	padding-top: 50px;
}

.row2 {
	padding-bottom: 50px;
}

.Denim-navbar-input {
	padding: 11px 16px;
	border-radius: 2px 0 0 2px;
	border: 0 none;
	outline: 0 none;
	font-size: 15px;
	color: black;
}

.Denim-navbar-button {
	background-color: #808080;
	border: 1px solid #808080;
	border-radius: 0 2px 2px 0;
	color: #FFDC00;
	padding: 10px 0;
	height: 43px;
	cursor: pointer;
}

.cart-button {
	background-color: #808080;
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .23), inset 1px 1px 0 0
		hsla(0, 0%, 100%, .2);
	padding: 10px 0;
	text-align: center;
	height: 41px;
	border-radius: 2px;
	font-weight: 500;
	width: 120px;
	display: inline-block;
	color: #FFFFFF;
	text-decoration: none;
	color: inherit;
	border: none;
	outline: none;
}

.cart-button:hover {
	text-decoration: none;
	color: #fff;
	cursor: pointer;
}

.cart-svg {
	display: inline-block;
	width: 16px;
	height: 16px;
	vertical-align: middle;
	margin-right: 8px;
}

.item-number {
	border-radius: 3px;
	background-color: rgba(0, 0, 0, .1);
	height: 20px;
	padding: 3px 6px;
	font-weight: 500;
	display: inline-block;
	color: #fff;
	line-height: 12px;
	margin-left: 10px;
}

.upper-links {
	display: inline-block;
	padding: 0 10px;
	line-height: 23px;
	font-family: 'Roboto', sans-serif;
	letter-spacing: 0;
	color: inherit;
	border: none;
	outline: none;
	font-size: 12px;
}

.upper {
	display: inline-block;
	padding: 0 10px;
	line-height: 20px;
	font-family: sans-serif;
	letter-spacing: 0;
}

.dropdown {
	position: fixed;
	display: inline;
	margin-top: 30px;
	/* 	margin-bottom: 50px; */
}

.dropdown:hover {
	background-color: #fff;
}

.dropdown:hover .links {
	color: #fff;
}

.dropdown:hover .dropdown-menu {
	display: block;
}

.dropdown .dropdown-menu {
	position: absolute;
	top: 100%;
	display: none;
	background-color: #fff;
	color: #333;
	left: 0px;
	border: 0;
	border-radius: 0;
	box-shadow: 0 4px 8px -3px #555454;
	margin: 0;
	padding: 0px;
}

.links {
	color: #fff;
	text-decoration: none;
		font-size: 15px;
	
}

.links:hover {
	color: #fff;
	text-decoration: none;
}

.profile-links {
	font-size: 12px;
	font-family: 'Roboto', sans-serif;
	border-bottom: 1px solid #e9e9e9;
	box-sizing: border-box;
	display: block;
	padding: 0 11px;
	line-height: 23px;
}

.profile-li {
	padding-top: 2px;
}

.largenav {
	display: none;
}

.smallnav {
	display: block;
}

.smallsearch {
	margin-left: 15px;
	margin-top: 15px;
}

xd
.menu {
	cursor: pointer;
}

@media screen and (min-width: 768px) {
	.largenav {
		display: block;
	}
	.smallnav {
		display: none;
	}
	.smallsearch {
		margin: 0px;
	}
}

.dropdown-content a {
	color: #326EC4;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	font-family: Courier New;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropbtn {
	font-size: 12px;
	color: #326EC4;
	font-weight: 1400; /
	text-indent: 0em; /
	font-family: Courier New;
	text-align: middle;
	background-color: white;
	color: blue; /
	padding: 16px;
	font-size: 20px;
	border: none;
	cursor: pointer;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: white;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	color: #326EC4;
}

#login-dp {
	min-width: 250px;
	padding: 14px 14px 0;
	overflow: hidden;
	background-color: rgba(255, 255, 255, .8);
}

#login-dp .help-block {
	font-size: 12px
}

#login-dp .bottom {
	background-color: rgba(255, 255, 255, .8);
	border-top: 1px solid #ddd;
	clear: both;
	padding: 14px;
}

#login-dp .social-buttons {
	margin: 12px 0
}

#login-dp .social-buttons a {
	width: 49%;
}

#login-dp .form-group {
	margin-bottom: 10px;
}

.btn-fb {
	color: #fff;
	background-color: #3b5998;
}

.btn-fb:hover {
	color: #fff;
	background-color: #496ebc
}

.btn-tw {
	color: #fff;
	background-color: #55acee;
}

.btn-tw:hover {
	color: #fff;
	background-color: #59b5fa;
}

@media ( max-width :768px) {
	#login-dp {
		background-color: inherit;
		color: #fff;
	}
	#login-dp .bottom {
		background-color: inherit;
		border-top: 0 none;
	}
}
</style>

<head>

<script type="text/javascript">
    ! function($, n, e) {
      var o = $();
      $.fn.dropdownHover = function(e) {
        return "ontouchstart" in document ? this : (o = o.add(this.parent()), this.each(function() {
          function t(e) {
            o.find(":focus").blur(), h.instantlyCloseOthers === !0 && o.removeClass("open"), n.clearTimeout(c), i.addClass("open"), r.trigger(a)
          }
          var r = $(this),
            i = r.parent(),
            d = {
              delay: 100,
              instantlyCloseOthers: !0
            },
            s = {
              delay: $(this).data("delay"),
              instantlyCloseOthers: $(this).data("close-others")
            },
            a = "show.bs.dropdown",
            u = "hide.bs.dropdown",
            h = $.extend(!0, {}, d, e, s),
            c;
          i.hover(function(n) {
            return i.hasClass("open") || r.is(n.target) ? void t(n) : !0
          }, function() {
            c = n.setTimeout(function() {
              i.removeClass("open"), r.trigger(u)
            }, h.delay)
          }), r.hover(function(n) {
            return i.hasClass("open") || i.is(n.target) ? void t(n) : !0
          }), i.find(".dropdown-submenu").each(function() {
            var e = $(this),
              o;
            e.hover(function() {
              n.clearTimeout(o), e.children(".dropdown-menu").show(), e.siblings().children(".dropdown-menu").hide()
            }, function() {
              var t = e.children(".dropdown-menu");
              o = n.setTimeout(function() {
                t.hide()
              }, h.delay)
            })
          })
        }))
      }, $(document).ready(function() {
        $('[data-hover="dropdown"]').dropdownHover()
      })
    }(jQuery, this);
  </script>

</head> 
<style>
functionopenNav () {document .getElementById("mySidenav")
	.style.width="70%";document .getElementById("Denim-navbar")
	.style.width="50%";document
	.body.style.backgroundColor="rgba(0,0,0,0.4)";
	
}

function
closeNav () {document .getElementById ("mySidenav") .style.width="0";document
	.body.style.backgroundColor="rgba(0,0,0,0)";
	
}
</style>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/overall.css"/>">

<div id="Denim-navbar">
	<div class="container">
		<div class="row row1">
			<ul class="largenav pull-right">


				<li class="upper">
					<li class="upper-links"><a class="links" href="myaccount">${welcome}${UName}</a></li>
				</li>

				<li class="upper-links"><a class="links" href="login">${login }</a></li>
				<li class="upper-links"><a class="links" href="registration">${signup }</a></li>
				<li class="upper-links"><a class="links" href="logout">${logout }</a></li>

			</ul>
			<!-- 			Only admin can view this link -->

			</ul>

			<br>
		</div>
		<div class="row row2">
			<div class="col-sm-2">
				<h2 style="margin: 0px;">
					<a class="sunil" href="index1" class="smallnav menu"
						onclick="openNav()" title="Ecommerce!">Ecommerce</a>
				</h2>
				<!-- 				<h1 style="margin: 0px;"> -->
				<!-- 					<a color="white" href="index1" class="largenav">Denim99</a> -->
				<!-- 				</h1> -->
			</div>


			<div class="Denim-navbar-search smallsearch col-sm-8 col-xs-11">
				<div class="row">
					<form action="search">
						<input class="Denim-navbar-input col-xs-11" type=""
							placeholder="Search for Products"
							name="searchtext" id="searchtext">
						<button class="Denim-navbar-button col-xs-1">
							<svg width="15px" height="15px">
                            <path
									d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                        </svg>
						</button>
					</form>
				</div>
			</div>


			<div class="cart largenav col-sm-2">
				<a class="cart-button" href="myCartPageDetails"> <svg
						class="cart-svg " width="16 " height="16 " viewBox="0 0 16 16 ">
                        <path
							d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 "
							fill="#fff "></path>
                    </svg> My Cart <span class="item-number">${itemcount}</span>
<%--                     ${fn:length(itemcount)} - Items<span class="caret"></span> --%>
					&nbsp;&nbsp;

				</a>

			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	function search() {
		window.open("search/" + document.getElementById("searchtext").value);
	}
</script>
