<%-- 
    Document   : index
    Created on : Dec 9, 2013, 10:10:41 PM
    Author     : MARTJA1 and STOLTZFUSCJ1

In here is the page users see when first going to the page. 
Make action of submit button "Euchre" to send to Euchre.java in GameEuchre proj

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%session.setAttribute("page", 1);%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Euchre Login</title>
        <link rel="stylesheet" type="text/css" href="Styles/Login.css">
    </head>
    <body>
        
        <form name="loginForm" action="Euchre" method="GET">
        Username: <input type="text" name="username">
        <input name="loginButton" type="submit" value="Login">
        </form>
        
    </body>
</html>


