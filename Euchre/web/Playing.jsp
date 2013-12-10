<%-- 
    Document   : Main
    Created on : Dec 5, 2013, 4:40:06 PM
    Author     : MARTJA1
--%><%@page import="GameEuchre.GameManager"
%><%@page import="GameEuchre.Player"
%><%@page import="GameEuchre.Euchre"
%><%@page import="java.util.Stack"
%><%@page import="GameEuchre.Card"
%><%@page contentType="application/xml" pageEncoding="UTF-8"
%><?xml version='1.0' encoding='UTF-8'?>
<%GameManager gm = (GameManager)session.getAttribute("gm");%>
<table
    ><trump><%=gm.trump%></trump
    ><trickSuit><%=gm.trickSuit%></trickSuit
    ><score><%=gm.teamOne.score%></score
    ><score><%=gm.teamTwo.score%></score
    ><%for(Player player : gm.players.values()) {
    %><hand><%for(Card card : player.playerHand.values()) {	
    %><card><%=card.getSignature()%></card
    ><%}%></hand><%}
%></table>
