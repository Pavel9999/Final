<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link href="resources/css/cars_menu.css" rel="stylesheet">
 <link href="resources/css/cars_img.css" rel="stylesheet">
 <link href="resources/css/cars_footer.css" rel="stylesheet">
 <link href="resources/css/cars_buttonUp.css" rel="stylesheet">


 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="resources/js/buttonUp.js"></script>


    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="local" var="loc" />

    <fmt:message bundle="${loc}" key="local.greeting"
                 var="greeting_text" />
    <fmt:message bundle="${loc}" key="local.guest"
                 var="guest_text" />

    <fmt:message bundle="${loc}" key="local.home"
                 var="home_text" />

    <fmt:message bundle="${loc}" key="local.all_cars"
                 var="all_cars_text" />
    <fmt:message bundle="${loc}" key="local.free_cars"
                 var="free_cars_text" />
    <fmt:message bundle="${loc}" key="local.rented_cars"
                 var="rented_cars_text" />

    <fmt:message bundle="${loc}" key="local.brand"
                 var="brand_text" />
    <fmt:message bundle="${loc}" key="local.model"
                 var="model_text" />
    <fmt:message bundle="${loc}" key="local.year"
                 var="year_text" />
    <fmt:message bundle="${loc}" key="local.mkp"
                 var="mkp_text" />
    <fmt:message bundle="${loc}" key="local.color"
                 var="color_text" />
    <fmt:message bundle="${loc}" key="local.horsepower"
                 var="horsepower_text" />
    <fmt:message bundle="${loc}" key="local.engine_size"
                 var="engine_size_text" />
    <fmt:message bundle="${loc}" key="local.miliage"
                 var="miliage_text" />
    <fmt:message bundle="${loc}" key="local.price"
                 var="price_text" />
    <fmt:message bundle="${loc}" key="local.rental"
                 var="rental_text" />
    <fmt:message bundle="${loc}" key="local.rent_avaible"
                 var="rent_avaible_text" />
    <fmt:message bundle="${loc}" key="local.already_in_rent"
                 var="already_in_rent_text" />
    <fmt:message bundle="${loc}" key="local.logout"
                 var="logout_text" />
    <fmt:message bundle="${loc}" key="local.login"
                 var="login_text" />
    <fmt:message bundle="${loc}" key="local.singup"
                 var="singup_text" />

    <fmt:message bundle="${loc}" key="local.language"
                 var="language_text" />
 
<style>

</style>
</head>
<body>

<div class="navbar">

    <div class="subnav">
        <button class="subnavbtn">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="go_to_index">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${home_text}" />
            </form>
        </button>
    </div>

    <div class="subnav">
        <button class="subnavbtn">
            <form action="/controller" method="POST">
                <input type="hidden" name="command" value="all_cars">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${all_cars_text}" />
            </form>
        </button>
    </div>

    <div class="subnav">
        <button class="subnavbtn">
            <form action="/controller" method="POST">
                <input type="hidden" name="command" value="free_cars">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${free_cars_text}" />
            </form>
        </button>
    </div>

    <div class="subnav">
        <button class="subnavbtn">${language_text} <i class="fa fa-caret-down"></i></button>

        <div class="subnav-content">
            <a>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="${prev_command}">
                    <input type="hidden" name="local" value="ru" />
                    <fmt:setLocale value="ru" scope="session"/>
                    <input style="border:0; color:white; background-color: transparent;" type="submit" value="Русский"/>
                </form>
            </a>

            <a>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="${prev_command}">
                    <input type="hidden" name="local" value="en"  />
                    <fmt:setLocale value="en" scope="session"/>
                    <input style="border:0; color:white; background-color: transparent;" type="submit" value="English"/>
                </form>
            </a>

            <a>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="${prev_command}">
                    <input type="hidden" name="local" value="de"  />
                    <fmt:setLocale value="de" scope="session"/>
                    <input style="border:0; color:white; background-color: transparent;" type="submit" value="Deutsch"/>
                </form>
            </a>


        </div>
    </div>

  <div class="subnav">
    <button class="subnavbtn">About <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="#company">Company</a>
      <a href="#team">Team</a>
      <a href="#careers">Careers</a>
    </div>
  </div>

    <div class="subnav">
        <button class="subnavbtn">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="goToAuthorizationPage">

                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${login_text}" />
            </form>
        </button>
    </div>

    <div class="subnav">
        <button class="subnavbtn">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="goToRegistrationPage">

                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${singup_text}" />
            </form>
        </button>
    </div>
</div>

<c:forEach varStatus="i" var="car_row" items="${car_rows}" >
<div class="row">
    <c:forEach varStatus="j" var="car_collumn" items="${car_row}" >

        <div class="column">
            <div class="container"><img src="resources/img/${car_collumn.img}" alt="volkswagen" style="width:100%; height:300px">

                <c:if test = "${car_collumn.contract_id == 0}">
                    <button class="btn"> <b>${rent_avaible_text}</b></button>
                </c:if>
                <c:if test = "${car_collumn.contract_id != 0}">
                    <button class="btn"> <b>${already_in_rent_text}</b></button>
                </c:if>

                <p class="name">${car_collumn.brand} ${car_collumn.model}</p>
            </div>
        </div>
    </c:forEach>
</div>
</c:forEach>






<div class="content">
</div>
    <footer id="myFooter">
        <div class="container">
            <ul>
                <li><a href="#">Company Information</a></li>
                <li><a href="#">Contact us</a></li>
                <li><a href="#">Reviews</a></li>
                <li><a href="#">Terms of service</a></li>
            </ul>
        <p class="footer-copyright">© 2019 Copyright Text</p>
        </div>
        <div class="footer-social">
            <a href="#" class="social-icons"><i class="fa fa-facebook"></i></a>
            <a href="#" class="social-icons"><i class="fa fa-google-plus"></i></a>
            <a href="#" class="social-icons"><i class="fa fa-twitter"></i></a>
        </div>
    </footer>
	
	
	<div class="button-top">
		<a href="#"><b>&#9650;</b></a>
	</div>
	

</body>
</html>
