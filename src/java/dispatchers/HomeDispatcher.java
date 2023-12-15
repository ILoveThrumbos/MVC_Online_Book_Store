/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utility.AdmitBookStoreDAO;

/**
 *
 * @author MinhOng
 */
public class HomeDispatcher implements IDispatcher {

    /**
     * Executes the logic for the home page initialization.
     * Retrieves the list of books from the DAO and stores it in the session.
     * 
     * @param request the HTTP servlet request
     * @return the next page to navigate to (titles.jsp if successful, 
     * error.jsp if an exception occurs)
     */
    public String execute(HttpServletRequest request) {
        String nextPage = "/jsp/titles.jsp";
        try {
            nextPage = "/jsp/titles.jsp";
        } catch (Exception ex) {
            request.setAttribute("result", ex.getMessage());
            nextPage = "/jsp/error.jsp";
        }
        finally{
             return nextPage; 
        }

    }
}
