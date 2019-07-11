<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <div id="container">
        <div class="header">
            <tiles:insertAttribute name="header" />
        </div>

        <tiles:insertAttribute name="menu" />

        <tiles:insertAttribute name="body" />

        <footer class="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
    </div>
</html>