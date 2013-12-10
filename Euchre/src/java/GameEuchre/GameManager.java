/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameEuchre;
import java.util.Collections;
import java.util.Stack;
import java.util.HashMap;

/**
 *
 * @author MARTJA1
 * 
 * In here put all the game information, rather than writing them as separate variables like in BlackJack... that way we 
 * only have to write one session variable (GameManager).
 * 
 * 
 */
public class GameManager {
    public Stack<Card> deck;
    public HashMap<Integer, Player> players;
    public Team teamOne;
    public Team teamTwo;
    public char trump;
    public char trickSuit;
    
    public GameManager()
    {
        deck = new Stack<Card>();
        players = new HashMap<Integer, Player>();
        setupDeck();
        
        for(int i = 1; i <= 4; ++i)
        {
            players.put(i, new Player(i, this));
        }
    }
    
    public void setupTeams(int firstIDOne, int firstIDTwo, int secondIDOne, int secondIDTwo)
    {
        teamOne = new Team(players.get(firstIDOne), players.get(firstIDTwo));
        teamTwo = new Team(players.get(secondIDOne), players.get(secondIDTwo));
    }
    
    public void setupDeck()
    {
        deck.clear();
        char suit = 's';
        for(int i = 2; i < 11; ++i)
        {
            deck.add(new Card((char)i, suit, i));
        }
        deck.add(new Card('j', suit, 11));
        deck.add(new Card('q', suit, 12));
        deck.add(new Card('k', suit, 13));
        deck.add(new Card('a', suit, 14));
        suit = 'c';
        for(int i = 2; i < 11; ++i)
        {
            deck.add(new Card((char)i, suit, i));
        }
        deck.add(new Card('j', suit, 11));
        deck.add(new Card('q', suit, 12));
        deck.add(new Card('k', suit, 13));
        deck.add(new Card('a', suit, 14));
        suit = 'h';
        for(int i = 2; i < 11; ++i)
        {
            deck.add(new Card((char)i, suit, i));
        }
        deck.add(new Card('j', suit, 11));
        deck.add(new Card('q', suit, 12));
        deck.add(new Card('k', suit, 13));
        deck.add(new Card('a', suit, 14));
        suit = 'd';
        for(int i = 2; i < 11; ++i)
        {
            deck.add(new Card((char)i, suit, i));
        }
        deck.add(new Card('j', suit, 11));
        deck.add(new Card('q', suit, 12));
        deck.add(new Card('k', suit, 13));
        deck.add(new Card('a', suit, 14));
        
        Collections.shuffle(deck);
    }
    
    public void deal()
    {
        for(int i = 0; i < 5; ++i)
        {
            players.get(1).addCard(deck.pop());
            players.get(2).addCard(deck.pop());
            players.get(3).addCard(deck.pop());
            players.get(4).addCard(deck.pop());
        }
    }
    
    public void pickupCard(int callingPlayerID)
    {
        if(teamOne.teammateOne.playerID == callingPlayerID)
        {
            teamOne.didCall = true;
            Card card = deck.pop();
            trump = card.getSuit();
            teamOne.teammateOne.addCard(card);
        }
        else if(teamOne.teammateTwo.playerID == callingPlayerID)
        {
            teamOne.didCall = true;
            Card card = deck.pop();
            trump = card.getSuit();
            teamOne.teammateTwo.addCard(card);
        }
        else if(teamTwo.teammateOne.playerID == callingPlayerID)
        {
            teamTwo.didCall = true;
            Card card = deck.pop();
            trump = card.getSuit();
            teamTwo.teammateOne.addCard(card);
        }
        else if(teamTwo.teammateTwo.playerID == callingPlayerID)
        {
            teamTwo.didCall = true;
            Card card = deck.pop();
            trump = card.getSuit();
            teamTwo.teammateTwo.addCard(card);
        }
    }
    
    public void callTrump(int callingPlayerID, char suit)
    {
        if(teamOne.teammateOne.playerID == callingPlayerID)
        {
            teamOne.didCall = true;
            trump = suit;
        }
        else if(teamOne.teammateTwo.playerID == callingPlayerID)
        {
            teamOne.didCall = true;
            trump = suit;
        }
        else if(teamTwo.teammateOne.playerID == callingPlayerID)
        {
            teamTwo.didCall = true;
            trump = suit;
        }
        else if(teamTwo.teammateTwo.playerID == callingPlayerID)
        {
            teamTwo.didCall = true;
            trump = suit;
        }
    }
}
