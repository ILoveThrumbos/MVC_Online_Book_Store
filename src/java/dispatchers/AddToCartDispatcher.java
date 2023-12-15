package dispatchers;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;

/**
 * Dispatcher responsible for handling the addition of selected books to the cart.
 * Navigates to the titles.jsp page after adding the books.
 * If an error occurs during the process, navigates to the error.jsp page.
 * Implements the IDispatcher interface.
 * 
 * @author Minh
 */
public class AddToCartDispatcher implements IDispatcher {

    /**
     * Executes the logic for adding selected books to the cart.
     * 
     * @param request the HTTP servlet request
     * @return the next page to navigate to (titles.jsp)
     */
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        HashMap<String, CartItem> cart = (HashMap<String, CartItem>) session.getAttribute("cart");
        String nextPage = "/jsp/titles.jsp";
        try {
            String[] selectedBooks = request.getParameterValues("add");
            if (selectedBooks != null) {
                if (cart == null) {
                    cart = new HashMap();
                    session.setAttribute("cart", cart);
                }

                for (String isbn : selectedBooks) {
                    int quantity = Integer.parseInt(request.getParameter(isbn));
                    Book book = getBookFromList(isbn, session);
                    if (book != null) {
                        if (cart.containsKey(isbn)) {
                            CartItem item = cart.get(isbn);
                            item.setQuantity(quantity);
                        } else {
                            CartItem item = new CartItem(book);
                            item.setQuantity(quantity);
                            cart.put(isbn, item);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("error", "An error occurred while adding books to the cart: " + ex.getMessage());
            nextPage= "/jsp/error.jsp";
        }// end catch
        finally {
            return nextPage;
        }
    }
    
    /**
     * Retrieves a book from the list of books based on the ISBN.
     * 
     * @param isbn the ISBN of the book to retrieve
     * @param session the HTTP session
     * @return the Book object if found, or null if not found
     */
    private Book getBookFromList(String isbn, HttpSession session) {
        List<Book> books = (List<Book>) session.getAttribute("books");
        if (books != null) {
            for (Book book : books) {
                if (isbn.equals(book.getIsbn())) {
                    return book;
                }
            }
        }
        return null;
    }
}
