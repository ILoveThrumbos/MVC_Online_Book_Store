package dispatchers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utility.AdmitBookStoreDAO;

/**
 * Dispatcher responsible for handling the continue action.
 * Navigates to the titles.jsp page when the continue button is clicked.
 * Implements the IDispatcher interface.
 * 
 * author MinhOng
 */
public class ContinueDispatcher implements IDispatcher {

    /**
     * Executes the logic for the continue action and navigates to the titles.jsp page.
     * 
     * @param request the HTTP servlet request
     * @return the next page to navigate to (titles.jsp)
     */
    public String execute(HttpServletRequest request) {
        String nextPage = "/jsp/titles.jsp";
        HttpSession session = request.getSession();
        try {
            nextPage = "/jsp/titles.jsp";
        } catch (Exception ex) {
            // Handle any exceptions that occur during the process
            request.setAttribute("error", "An error occurred during the continue action: " + ex.getMessage());
            nextPage = "/jsp/error.jsp";
        } finally {
            return nextPage;
        }
    }
}
