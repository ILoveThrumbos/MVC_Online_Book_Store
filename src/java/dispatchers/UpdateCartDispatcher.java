package dispatchers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import model.CartItem;


/**
 * Dispatcher responsible for handling the update cart action.
 * Updates the cart items based on the user's input and navigates 
 * to the cart.jsp page.
 * 
 * author MinhOng
 */
public class UpdateCartDispatcher implements IDispatcher {
    /**
     * Executes the logic for the update cart action.
     * Updates the cart items based on the user's input and navigates to the cart.jsp page.
     * 
     * @param request the HTTP servlet request
     * @return the next page to navigate to (cart.jsp)
     */
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        String nextPage = "/jsp/cart.jsp";
        try {
            if (cart != null) {
                String[] booksToRemove = request.getParameterValues("remove");

                if (booksToRemove != null) {
                    for (String isbn : booksToRemove) {
                        cart.remove(isbn);
                    }
                }
                for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
                    String isbn = entry.getKey();
                    CartItem item = entry.getValue();

                    int quantity = Integer.parseInt(request.getParameter(isbn));
                    item.setQuantity(quantity);
                }
                session.setAttribute("cart", cart);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "An error occurred during the update cart action: " + ex.getMessage());
            nextPage= "/jsp/error.jsp";
        } finally {
            return nextPage;

        }
    }
}
