/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function init() {
    return;
}

function play() {
    var connection = new XMLHttpRequest();
    if(connection) {
        connection.open("POST", "Euchre", true);
        connection.onreadystatechange = function() { updateGame(connection); };
        connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        connection.send("action=start");
    }    
}
//
//function stay() {
//    var connection = new XMLHttpRequest();
//    if(connection) {
//        connection.open("POST", "Euchre", true);
//        connection.onreadystatechange = function() { updateCardsDisplayed(connection); };
//        connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//        connection.send("action=stay");
//    }    
//}

//function nextRound() {
//    var connection = new XMLHttpRequest();
//    if(connection) {
//        connection.open("POST", "Blackjack", true);
//        connection.onreadystatechange = function() { updateCardsDisplayed(connection); };
//        connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//        connection.send("action=next");
//    }
//}

function updateGame(connection) {
    if (connection.readyState == 4 && connection.status == 200) {
    
        var root = connection.responseXML.documentElement;
        
        var trump = (String)(root.getElementsByTagName("trump")[0].childNodes[0].textContent);
        var trickSuit = (String)(root.getElementsByTagName("trickSuit")[0].childNodes[0].textContent);
        var team1Score = (String)(root.getElementsByTagName("score")[0].childNodes[0].textContent);
        var team2Score = (String)(root.getElementsByTagName("score")[1].childNodes[0].textContent);
        
        
        
        //getting buttons
//        var hitButton = document.getElementsByTagName("input")[0];
//        var stayButton = document.getElementsByTagName("input")[1];
//        
        
        document.getElementsByName("teamSelect")[0].parentNode.removeChild(document.getElementsByName("teamSelect")[0]);
        
        //var hands = document.getElementById("").childElementCount;
            
        
        var body=document.getElementByTagName("body")[0];
        var trump=document.createElement("div");
        trump.setAttribute('id','trump');
        var score1=document.createElement("div");
        score1.setAttribute('id','score1');
        var score2=document.createElement("div");
        score2.setAttribute('id','score2');
        var hands=document.createElement("div");
        hands.setAttribute('id','hands');
        body.appendChild(trump);
        body.appendChild(score1);
        body.appendChild(score2);
        body.appendChild(hands);
        
        var handdiv = document.getElementById("hands");
        var hand1 = document.createElement("div");
        var hand2 = document.createElement("div");
        var hand3 = document.createElement("div");
        var hand4 = document.createElement("div");
        hand1.setAttribute('id','hand1');
        hand2.setAttribute('id','hand2');
        hand3.setAttribute('id','hand3');
        hand4.setAttribute('id','hand4');
        
        handdiv.appendChild(hand1);
        handdiv.appendChild(hand2);
        handdiv.appendChild(hand3);
        handdiv.appendChild(hand4);
        
        
        
        
        
        
        
        
    }    
}
