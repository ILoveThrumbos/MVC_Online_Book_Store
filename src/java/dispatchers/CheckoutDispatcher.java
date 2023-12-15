package dispatchers;


import javax.servlet.http.HttpServletRequest;


/**
 * Dispatcher responsible for handling the checkout process.
 * Navigates to the checkout.jsp page when the checkout is clicked.
 * 
 * author Minh Ong
 */
public class CheckoutDispatcher implements IDispatcher {
    

    /**
     * Executes the logic for the checkout process.
     * Navigates to the checkout.jsp page.
     * 
     * @param request the HTTP servlet request
     * @return the next page to navigate to (checkout.jsp)
     */
    @Override
    public String execute(HttpServletRequest request) {
        String nextPage = "/jsp/checkout.jsp";
        try {
            nextPage = "/jsp/checkout.jsp";
            
        } catch (Exception ex) {
            request.setAttribute("error", "An error occurred during the checkout process: " + ex.getMessage());
            nextPage = "/jsp/error.jsp";
        }
        finally{
            return nextPage;
            
        }
    }   
}
