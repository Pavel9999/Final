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

    <fmt:message bundle="${loc}" key="local.all_cars"
                 var="all_cars_text" />
    <fmt:message bundle="${loc}" key="local.free_cars"
                 var="free_cars_text" />
    <fmt:message bundle="${loc}" key="local.all_contracts"
                 var="all_contracts_text" />
    <fmt:message bundle="${loc}" key="local.all_users"
                 var="all_users_text" />
    <fmt:message bundle="${loc}" key="local.all_clients"
                 var="all_clients_text" />
    <fmt:message bundle="${loc}" key="local.all_managers"
                 var="all_managers_text" />

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
    <fmt:message bundle="${loc}" key="local.rent_car"
                 var="rent_car_text" />
    <fmt:message bundle="${loc}" key="local.logout"
                 var="logout_text" />
    <fmt:message bundle="${loc}" key="local.home"
                 var="home_text" />
    <fmt:message bundle="${loc}" key="local.cancel"
                 var="cancel_text" />
    <fmt:message bundle="${loc}" key="local.confirm"
                 var="confirm_text" />
    <fmt:message bundle="${loc}" key="local.close"
                 var="close_text" />

    <fmt:message bundle="${loc}" key="local.car"
                 var="car_text" />
    <fmt:message bundle="${loc}" key="local.contract_state"
                 var="state_text" />
    <fmt:message bundle="${loc}" key="local.all_price"
                 var="price_text" />
    <fmt:message bundle="${loc}" key="local.client"
                 var="client_text" />
    <fmt:message bundle="${loc}" key="local.manager"
                 var="manager_text" />
    <fmt:message bundle="${loc}" key="local.date_start"
                 var="date_start_text" />
    <fmt:message bundle="${loc}" key="local.date_finish"
                 var="date_finish_text" />

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
        <button class="subnavbtn">
            <form action="/controller" method="POST">
                <input type="hidden" name="command" value="all_contracts">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${all_contracts_text}" />
            </form>
        </button>
    </div>

    <div class="subnav">
        <button class="subnavbtn">
            <form action="/controller" method="POST">
                <input type="hidden" name="command" value="all_clients">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${all_clients_text}" />
            </form>
        </button>
    </div>

    <div class="subnav">
        <button class="subnavbtn">
            <form action="/controller" method="POST">
                <input type="hidden" name="command" value="all_managers">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${all_managers_text}" />
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
                <input type="hidden" name="command" value="logout">
                <input style="border:0; color:white; background-color: transparent;" type="submit" value="${logout_text}" />
            </form>
        </button>
    </div>
</div>

<table id="cars">
    <tr id="header">
        <td><p>${car_text}</p></td>
        <td><p>${state_text}</p></td>
        <td><p>${price_text}</p></td>
        <td><p>${date_start_text}</p></td>
        <td><p>${date_finish_text}</p></td>
        <td><p>${client_text}</p></td>
        <td><p>${manager_text}</p></td>
        <td><p>${action_text}</p></td>

    </tr>
    <c:forEach varStatus="i" var="contract" items="${contracts}" >
        <tr class="car">
            <td><img src="resources/img/${cars[i.count-1].img}" alt="volkswagen" style="width:126px; height:96px">  <p>${contract.car}</p></td>
            <td><p>${contract.state}</p></td>
            <td><p>${contract.all_price}</p></td>
            <td><p>${contract.date_start}</p></td>
            <td><p>${contract.date_finish}</p></td>
            <td><p>${contract.client}</p></td>
            <td><p>${contract.manager}</p></td>

            <td>
                <c:if test = "${contract.state == 'unconfirmed'}">
                    <p>${contract_unconfirmed_text}</p>

                    <form action="/controller" method="POST">
                        <input type="hidden"  name="command" value="cancel_rent" />
                        <input type="hidden"  name="contract_id" value="${contract.id}" />
                        <input type="submit" value="${cancel_text}" />
                    </form>
                </c:if>


                <c:if test = "${contract.state == 'confirmed'}">
                    <p>${contract_confirmed_text}</p>

                    <form action="/controller" method="POST">
                        <input type="hidden"  name="command" value="finish_rent" />
                        <input type="hidden"  name="contract_id" value="${contract.id}" />
                        <input type="submit" value="${close_text}" />
                    </form>

                </c:if>
                <c:if test = "${contract.state == 'canceled'}">
                    <p>${contract_canceled_text}</p>
                </c:if>
                <c:if test = "${contract.state == 'finished'}">
                    <p>${contract_finished_text}</p>
                </c:if>

            </td>
        </tr>
    </c:forEach>
</table>






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
