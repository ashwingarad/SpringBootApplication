<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring Security</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <sec:authorize access="!isAuthenticated()">
                    <div>
                        <a href="/login" class="btn btn-info navbar-btn" id="btnLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                    </div>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <div>
                        <a href="/doLogout" class="btn btn-danger navbar-btn"><span class="glyphicon glyphicon-log-in"></span>Logout</a>
                    </div>
                </sec:authorize>
            </li>
        </ul>
    </div>
</nav>


