<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
	integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA"	crossorigin="anonymous">

<script type="text/javascript"	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/js/bootstrap.min.js"
	integrity="sha384-7aThvCh9TypR7fIc2HV4O/nFMVCBwyIUKL8XCtKE+8xgCgl/PQGuFsvShjr74PBp"	crossorigin="anonymous"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"	crossorigin="anonymous"></script>

<script type="text/javascript"	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/base/jquery-ui.css" />

<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>

<script type="text/javascript"	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

<script type="text/javascript"	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>

<script type="text/javascript"	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/additional-methods.js"></script>

<script type="text/javascript"	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/additional-methods.min.js"></script>


<script src="https://www.google.com/jsapi" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/application.js"></script>

<div class="form-group">
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-8"><h3>Spring Boot Application</h3></div>
        </div>
    </div>
</div>

<style type="text/css">
    .error {
        color: red;
    }
    .red-square {
      width: 400px;
      left: 35%;
    }
    .content-wrap {
        padding-bottom: 2.5rem;    /* Footer height */
    }

    .footer {
        bottom: 0px;
        width: 100%;
        position: inherit;
        height: 2.5rem;            /* Footer height */
    }

    /* Style the header */
    .header {
      padding: 10px 16px;
      background: #555;
      color: #f1f1f1;
    }

    /* Page content */
    .content {
      padding: 16px;
    }

    /* The sticky class is added to the header with JS when it reaches its scroll position */
    .sticky {
      position: fixed;
      top: 0;
      width: 100%
    }

    /* Add some top padding to the page content to prevent sudden quick movement (as the header gets a new position at the top of the page (position:fixed and top:0) */
    .sticky + .content {
      padding-top: 102px;
    }
</style>