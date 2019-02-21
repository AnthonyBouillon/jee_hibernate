<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="model.Users"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.Users_crud"%>
<%@ page import="controller.Servlet"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">
        <title>GestUsers</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="">Gest Users</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <!-- The links are displayed if the user is logged in -->
                    
                    <%
                        if (session.getAttribute("session_username") != null) {
                    %>
                            <a href="Servlet" class="nav-item nav-link">View All Records</a>
                            <a href="logout.jsp" class="nav-item nav-link">Logout</a> 
                    <%
                        } else {
                    %>
                            <a href="ajouter.jsp" class="nav-item nav-link">Add Users</a>
                            <a href="login.jsp" class="nav-item nav-link">Sign in</a>
                    <%
                        }
                    %>
                </div>
            </div>
        </nav>


