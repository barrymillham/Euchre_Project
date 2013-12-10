/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameEuchre;

/**
 *
 * @author MARTJA1
 */
public class Card {
    public Card(char id, char s, int v){
        identifier = id; value = v; suit = s;
        frontImagePath = "./Images/"+id+suit+".png";
        backImagePath = "./Images/back.png";
    }
    
    private char identifier;
    private char suit;
    private int value;
    private String frontImagePath;
    private String backImagePath;
    
    public String getImagePath(){return frontImagePath;}
    public String getBackImagePath(){return backImagePath;}
    public char getSuit(){return suit;}
    public char getId(){return identifier;}
    public int getValue() {return value;}
    public String getSignature() {
        StringBuilder builder = new StringBuilder();
        builder.append(identifier);
        builder.append(suit);
        return builder.toString();
    }
    public int add(Card right) {return this.value + right.value;}
    
    
    
}
