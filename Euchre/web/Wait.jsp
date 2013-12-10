<%-- 
    Document   : Wait
    Created on : Dec 10, 2013, 1:03:52 AM
    Author     : MARTJA1
--%>

<%@page import="GameEuchre.GameManager"%>
<%session.setAttribute("page", 2);%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%GameManager gm = (GameManager)session.getAttribute("gm");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styles/Login.css">
        <title>Waiting for the rest of the players.</title>
    </head>
    <body>

        <h3>Please refresh until you see all users:</h3>
        <form name="refresh" action="Euchre" method="GET">
        <input name="refreshButton" type="submit" value="Refresh">
        </form>
    
        <form action="Euchre" method="GET">
            <fieldset>
            <legend>Select Your Team!</legend>
            <table>
                <tr><td>Team number:</td><td>
                    <select name="TeamNum" value="-1">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    </select>
                    </td></tr>
            </table>
            </fieldset>
            <br />
            
            <input type="hidden" name="teamed" value="true">
            <input name="newGame" type="submit" value="Play!">
        </form>
    </body>
</html>
