<%-- 
    Document   : Wait
    Created on : Dec 10, 2013, 1:03:52 AM
    Author     : MARTJA1
--%>

<%@page import="GameEuchre.GameManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%GameManager gm = (GameManager)session.getAttribute("gm");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Waiting for the rest of the players.</title>
    </head>
    <body>
        <h3>Waiting for the rest of the players to connect!</h3>
        <%while (gm.players.size() < 4){
           if (gm.players.size() < 4){%><h4>nope</h4>
           <%}else{%>
           <h4>yep</h4>
        <%}}%>
        <h4>yay</h4>
    </body>
</html>
