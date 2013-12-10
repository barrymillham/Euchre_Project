/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameEuchre;

/**
 *
 * @author STOLTZFUSCJ1
 */
public class Team {
    public int score;
    public Player teammateOne;
    public Player teammateTwo;
    public Team(Player one, Player two)
    {
        score = 0;
        teammateOne = one;
        teammateTwo = two;
    }
}
