<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.net.*"%>
<div class="col-md-12">
   <form:form class="form-horizontal" method="POST" name="employeeForm"
      id="employeeForm" modelAttribute="employeeForm">
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
         <legend>Employee Form</legend>
         <form:input type="hidden" path="id" />
         <!-- Text input-->
         <div class="form-group">
            <label class="col-md-4 control-label" for="">Name</label>
            <div class="col-md-4">
               <form:input path="ename" id="ename" class="form-control input-md"
                  required="" type="text" placeholder="" />
               <form:errors class="danger text-muted" path="ename" />
            </div>
         </div>
         <!-- Text input-->
         <div class="form-group">
            <label class="col-md-4 control-label" for="">Salary</label>
            <div class="col-md-4">
               <form:input path="salary" id="salary" class="form-control input-md"
                  required="" type="text" placeholder="" />
               <form:errors class="danger text-muted" path="salary" />
            </div>
         </div>
         <!-- Button -->
         <div class="form-group">
            <label class="col-md-4 control-label" for="btnSave"></label>
            <div class="col-md-4">
               <c:choose>
                  <c:when test="${employeeForm.id == null}">
                     <button type="submit" class="btn btn-success" id="btnSave">Save</button>
                  </c:when>
                  <c:otherwise>
                     <button type="submit" class="btn btn-success" id="btnSave">Update</button>
                  </c:otherwise>
               </c:choose>
            </div>
         </div>
      </fieldset>
   </form:form>
</div>
<div class="col-md-12">
   <div class="col-md-2"></div>
   <div class="col-md-8">
      <table class="table table-hover table-dark">
         <thead>
            <tr>
               <th scope="col">#</th>
               <th scope="col">Name</th>
               <th scope="col">Salary</th>
               <th scope="col">Action</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${employeeFormList}" var="employeeForm"
               varStatus="row">
               <tr>
                  <th scope="row">${row.count}</th>
                  <td>${employeeForm.ename}</td>
                  <td>${employeeForm.salary}</td>
                  <td>
                     <a type="button" onClick="javascript:editEmp(${employeeForm.id})" class="btn btn-dark">Edit</a>
                     <a type="button" onClick="javascript:deleteEmp(${employeeForm.id})" class="btn btn-danger">Delete</a>
                  </td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </div>
   <div class="col-md-2"></div>
</div>