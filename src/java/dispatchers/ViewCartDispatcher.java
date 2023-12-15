package dispatchers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import model.CartItem;

/**
 * Dispatcher responsible for handling the view cart action.
 * Displays the contents of the cart or navigates back to the 
 * titles page if the cart is empty.
 * 
 * author MinhOng
 */
public class ViewCartDispatcher implements IDispatcher {
    /**
     * Executes the logic for the view cart action.
     * Displays the contents of the cart or navigates back to the titles page 
     * if the cart is empty.
     * 
     * @param request the HTTP servlet request
     * @return the next page to navigate to (cart.jsp if the cart is not empty, 
     * titles.jsp if the cart is empty)
     */
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        String nextPage = "/jsp/cart.jsp";
        try {
            if (cart == null || cart.isEmpty()) {
                // If the cart is empty, navigate back to the titles page
                return "/jsp/titles.jsp";
            } else {
                // If the cart is not empty, display the cart contents
                request.setAttribute("cartItems", cart.values());
                return nextPage;
            }   
        } catch (Exception ex) {
            // Handle any exceptions that occur during the view cart action
            request.setAttribute("error", "An error occurred during the view cart action: " + ex.getMessage());
            nextPage= "/jsp/error.jsp";
        } finally {
            return nextPage;
      
        }
    }
}
