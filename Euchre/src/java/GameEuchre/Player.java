/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameEuchre;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author STOLTZFUSCJ1
 */
public class Player {
    public int playerID;
    public HashMap<String, Card> playerHand;
    private GameManager manager;
    
    public Player(int id, GameManager m)
    {
        manager = m;
        playerID = id;
        playerHand = new HashMap<String, Card>();
    }
    
    public void addCard(Card card)
    {
        playerHand.put(card.getSignature(), card);
    }
    
    public Card leadCard(int id, char suit)
    {
        Card playCard = playerHand.remove(buildCardSignature(id, suit));
        manager.trickSuit = playCard.getSuit();
        return playCard;
    }
    
    public Card playCard(int id, char suit)
    {
        if(suit == manager.trickSuit)
        {
            return playerHand.remove(buildCardSignature(id, suit));
        }
        else
        {
            if(isHoldingSuit(manager.trickSuit))
            {
                return null;
            }
            return playerHand.remove(buildCardSignature(id, suit));
        }
    }
    
    public Boolean isHoldingSuit(char suit)
    {
        for(Card card : playerHand.values())
        {
            if(card.getSuit() == suit)
            {
                return true;
            }
        }
        
        return false;
    }
    
    public String buildCardSignature(int id, char suit) {
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        builder.append(suit);
        return builder.toString();
    }
}
