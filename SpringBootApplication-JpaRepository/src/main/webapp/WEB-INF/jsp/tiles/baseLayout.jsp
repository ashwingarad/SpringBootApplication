<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <div class="container">
        <tiles:insertAttribute name="header" />

        <tiles:insertAttribute name="menu" />

        <tiles:insertAttribute name="body" />

        <tiles:insertAttribute name="footer" />
    </div>
</html>