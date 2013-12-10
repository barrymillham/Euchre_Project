/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameEuchre;
import java.util.HashMap;
/**
 *
 * @author STOLTZFUSCJ1
 */
public class Player {
    public int playerID;
    public HashMap<String, Card> playerHand;
    
    public Player(int id)
    {
        playerID = id;
        playerHand = new HashMap<String, Card>();
    }
    
    public void addCard(Card card)
    {
        playerHand.put(card.getSignature(), card);
    }
    
    public Card playCard(int id, char suit)
    {
        return playerHand.remove(buildCardSignature(id, suit));
    }
    
    public String buildCardSignature(int id, char suit) {
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        builder.append(suit);
        return builder.toString();
    }
}
