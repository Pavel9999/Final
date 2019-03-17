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
    <fmt:message bundle="${loc}" key="local.all_managers"
                 var="all_managers_text" />
    <fmt:message bundle="${loc}" key="local.all_clients"
                 var="all_clients_text" />

    <fmt:message bundle="${loc}" key="local.singup"
                 var="singup_text" />
    <fmt:message bundle="${loc}" key="local.cancel"
                 var="cancel_text" />
    <fmt:message bundle="${loc}" key="local.first_name"
                 var="first_name_text" />
    <fmt:message bundle="${loc}" key="local.second_name"
                 var="second_name_text" />
    <fmt:message bundle="${loc}" key="local.last_name"
                 var="last_name_text" />
    <fmt:message bundle="${loc}" key="local.full_name"
                 var="full_name_text" />
    <fmt:message bundle="${loc}" key="local.login"
                 var="login_text" />
    <fmt:message bundle="${loc}" key="local.password"
                 var="password_text" />
    <fmt:message bundle="${loc}" key="local.email"
                 var="email_text" />
    <fmt:message bundle="${loc}" key="local.role"
                 var="role_text" />


    <fmt:message bundle="${loc}" key="local.logout"
                 var="logout_text" />
    <fmt:message bundle="${loc}" key="local.home"
                 var="home_text" />

    <fmt:message bundle="${loc}" key="local.language"
                 var="language_text" />

    <fmt:message bundle="${loc}" key="local.add_user"
                 var="add_user_text" />


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


<form action="/controller" method="POST">
    <input type="hidden" name="command" value="add_user">

    <table style="with: 50%">
        <tr>
            <td>${first_name_text}</td>
            <td><input type="text" name="first_name" value="${first_name_fill}"  /></td>
        </tr>
        <tr>
            <td>${second_name_text}</td>
            <td><input type="text" name="second_name" value="${second_name_fill}"/></td>
        </tr>
        <tr>
            <td>${last_name_text}</td>
            <td><input type="text" name="last_name" value="${last_name_fill}"/></td>
        </tr>
        <tr>
            <td>${email_text}</td>
            <td><input type="text" name="email" value="${email_name_fill}"/></td>
        </tr>
        <tr>
            <td>${password_text}</td>
            <td><input type="password" name="password" value="${password_fill}"/></td>
        </tr>
        <tr>
            <td>${role_text}</td>
            <td>
                <select name="role">
                    <option>Client</option>
                    <option>Manager</option>
                    <option>Admin</option>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="${add_user_text}" />
</form>


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
