<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <meta http-equiv="refresh" content="0;url=/homePage" />
</sec:authorize>

<style>

</style>

<div class="col-md-12 red-square">
    <div>
        <form method="POST" class="form-horizontal" name="userLoginForm" id="userLoginForm">

            <fieldset>
                <!-- Form Name -->
                <legend>Login Form</legend>

                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
                        <br/>
                    </div>
                </c:if>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="username">User Name</label>
                    <div>
                        <input name="username" type="text" class="form-control input-md" id="username" type="text" required="">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="pwd">Password</label>
                    <div>
                        <input name="password" type="password" class="form-control input-md" id="password" type="text" required="">
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="control-label" for="btnLogin"></label>
                    <div>
                        <button type="submit" class="btn btn-success" id="btnLogin">Login</button>
                        <button type="button" class="btn btn-info" id="btnSignUp">Sign up</button>
                    </div>
                </div>

            </fieldset>

        </form>
    </div>
</div>