<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-12 red-square">
    <form:form class="form-horizontal" method="POST" name="userProfileForm"
        id="userProfileForm" modelAttribute="userProfileForm">

        <c:if test="${not empty success}">
            <div class="alert alert-success alert-dismissible fade show"
                role="alert">
                <strong>Message</strong> ${success}
                <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissible fade show"
                role="alert">
                <strong>Message</strong> ${error}
                <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <fieldset>
            <!-- Form Name -->
            <legend>Registration Form</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="">Name</label>
                <div>
                    <form:input path="firstName" id="firstName" class="form-control input-md"
                        required="" type="text" placeholder="First Name" />
                    <form:errors class="danger text-muted" path="firstName" />
                </div>
                <div>
                    <form:input path="lastName" id="lastName" class="form-control input-md"
                        required="" type="text" placeholder="Last Name" />
                    <form:errors class="danger text-muted" path="lastName" />
                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="">Email id</label>
                <div>
                    <form:input path="emailId" id="emailId" class="form-control input-md"
                        required="" type="email" placeholder="" />
                    <form:errors class="danger text-muted" path="emailId" />
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="">Contact</label>
                <div>
                    <form:input path="mobile" id="mobile" pattern="[0-9]{10,14}" type="number" class="form-control input-md"
                        required="" placeholder="" />
                    <form:errors class="danger text-muted" path="mobile" />
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="">User Name</label>
                <div>
                    <form:input path="username" id="username" type="text" class="form-control input-md"
                        required="" placeholder="" />
                    <form:errors class="danger text-muted" path="username" />
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="">Password</label>
                <div>
                    <input id="password1" name="password1" type="password" class="form-control input-md"
                    required="" placeholder="" >
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="">Confirm Password</label>
                <div>
                    <form:input path="password" id="password" type="password" class="form-control input-md"
                      required="" placeholder=""/>
                    <form:errors class="danger text-muted" path="password" />
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="control-label" for="roles">Role</label>
                <div>
                    <form:select path="roleId" class="form-control" id="roles">
                        <c:forEach items="${roleFormList}" var="roleForm">
                          <form:option value="${roleForm.id}">${roleForm.role_name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="control-label" for="btnSave"></label>
                <div>
                    <button type="submit" class="btn btn-success" id="btnSave">Sign up</button>
                </div>
            </div>
        </fieldset>
    </form:form>
</div>