/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameEuchre;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MARTJA1 and STOLTZFUSCJ1
 * 
 */
public class Euchre extends HttpServlet {
    HttpSession session;
    int nextPlayerIndex = 1;
    public enum ServletState { Idle, WaitingForPlayers, Playing };
    ServletState state = ServletState.Idle;
    GameManager gm;
    RequestDispatcher dispatcher;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        switch(state)
        {
            case Idle:
                gm = new GameManager();
                session.setAttribute("gm", gm);
                gm.players.put(nextPlayerIndex, new Player(nextPlayerIndex, gm));
                session.setAttribute("playerIndex", nextPlayerIndex++);
                dispatcher = request.getRequestDispatcher("/Wait.jsp");
                dispatcher.forward(request, response);
                break;
            case WaitingForPlayers:
                session.setAttribute("gm", gm);
                gm.players.put(nextPlayerIndex, new Player(nextPlayerIndex, gm));
                session.setAttribute("playerIndex", nextPlayerIndex++);
                dispatcher = request.getRequestDispatcher("/Wait.jsp");
                dispatcher.forward(request, response);
                break;
            case Playing:
                
                break;
        }
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
