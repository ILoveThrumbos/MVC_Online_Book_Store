package controller;

import dispatchers.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import model.Book;
import model.CartItem;
import utility.AdmitBookStoreDAO;

public class FrontController extends HttpServlet {

    private final HashMap actions = new HashMap();

    //Initialize global variables
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        actions.put("titles", new TitlesDispatcher());
        actions.put("add_to_cart", new AddToCartDispatcher());
        actions.put("checkout", new CheckoutDispatcher());
        actions.put("continue", new ContinueDispatcher());
        actions.put("home", new HomeDispatcher());
        actions.put("update_cart", new UpdateCartDispatcher());
        actions.put("view_cart", new ViewCartDispatcher());

    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("doGet()");
        doPost(request, response);

    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String requestedAction = request.getParameter("action");
        if (requestedAction == null) {
            requestedAction = "titles";
        }
//        HttpSession session = request.getSession();
//        AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
        IDispatcher dispatcher = (IDispatcher) actions.get(requestedAction);
        String nextPage = dispatcher.execute(request);
        this.dispatch(request, response, nextPage);
//
//        if (requestedAction.equalsIgnoreCase("titles")) {
//            IDispatcher dispatcher = (IDispatcher) actions.get(requestedAction);
//            nextPage = dispatcher.execute(request);
////        dao = new AdmitBookStoreDAO();
////        List books = null;
////        nextPage = "/jsp/error.jsp";
////        session = request.getSession ();
////        try{
////            //System.out.println("inside try block of ShowHomeAO.exe()");
////            books = dao.getAllBooks();
////            session.setAttribute ("books", books);
////            nextPage = "/jsp/titles.jsp";
////            
////        }catch(Exception ex) {
////            request.setAttribute ("result",ex.getMessage ());
////            nextPage= "/jsp/error.jsp";
////        } // end catch
////        finally{
////            this.dispatch(request, response, nextPage);
////        }
//            this.dispatch(request, response, nextPage);
//        }// end if
//        else if (requestedAction.equals("add_to_cart")) {
//            nextPage = "/jsp/titles.jsp";
//
//            Map cart = (Map) session.getAttribute("cart");
//            String[] selectedBooks = request.getParameterValues("add");
//
//            if (cart == null) {
//                cart = new HashMap();
//                for (int i = 0; i < selectedBooks.length; i++) {
//                    String isbn = selectedBooks[i];
//                    int quantity = Integer.parseInt(request.getParameter(isbn));
//                    Book book = this.getBookFromList(isbn, session);
//                    CartItem item = new CartItem(book);
//                    item.setQuantity(quantity);
//                    cart.put(isbn, item);
//                }  // end for
//                session.setAttribute("cart", cart);
//            } // end if
//            else {
//                for (int i = 0; i < selectedBooks.length; i++) {
//                    String isbn = selectedBooks[i];
//                    int quantity = Integer.parseInt(request.getParameter(isbn));
//                    if (cart.containsKey(isbn)) {
//                        CartItem item = (CartItem) cart.get(isbn);
//                        item.setQuantity(quantity);
//                    } // end if
//                    else {
//                        Book book = this.getBookFromList(isbn, session);
//                        CartItem item = new CartItem(book);
//                        item.setQuantity(quantity);
//                        cart.put(isbn, item);
//                    } // end else
//                } // end for
//            } //end else
//
//            this.dispatch(request, response, nextPage);
//        } else if (requestedAction.equals("checkout")) {
//            nextPage = "/jsp/checkout.jsp";
//            this.dispatch(request, response, nextPage);
//        } else if (requestedAction.equals("continue")) {
//            nextPage = "/jsp/titles.jsp";
//            this.dispatch(request, response, nextPage);
//        } else if (requestedAction.equals("home")) {
//            try {
//                System.out.println("inside try block of ShowHomeAO.exe()");
//                List<Book> books = dao.getAllBooks();
//                session.setAttribute("books", books);
//                nextPage = "/jsp/titles.jsp";
//            } catch (Exception ex) {
//                request.setAttribute("result", ex.getMessage());
//                nextPage = "/jsp/error.jsp";
//            } finally {
//                this.dispatch(request, response, nextPage);
//            }
//        } else if (requestedAction.equals("update_cart")) {
//            Map cart = null;
//            Book book = null;
//            CartItem item = null;
//            String isbn = null;
//            nextPage = "/jsp/cart.jsp";
//            cart = (Map) session.getAttribute("cart");
//            String[] booksToRemove = request.getParameterValues("remove");
//            if (booksToRemove != null) {
//                for (int i = 0; i < booksToRemove.length; i++) {
//                    cart.remove(booksToRemove[i]);
//                }
//            }
//            Set entries = cart.entrySet();
//            Iterator iter = entries.iterator();
//            while (iter.hasNext()) {
//                Map.Entry entry = (Map.Entry) iter.next();
//                isbn = (String) entry.getKey();
//                item = (CartItem) entry.getValue();
//                int quantity = Integer.parseInt((request.getParameter(isbn)));
//                item.updateQuantity(quantity);
//            }
//            this.dispatch(request, response, nextPage);
//        } else if (requestedAction.equals("view_cart")) {
//            nextPage = "/jsp/cart.jsp";
//            Map cart = (Map) session.getAttribute("cart");
//            if (cart == null) {
//                nextPage = "/jsp/titles.jsp";
//            }
//            this.dispatch(request, response, nextPage);
//        } else {
//            nextPage = "/jsp/error.jsp";
//            this.dispatch(request, response, nextPage);
//        }
//    }
//
//    private Book getBookFromList(String isbn, HttpSession session) {
//        List list = (List) session.getAttribute("books");
//        Book aBook = null;
//        for (int i = 0; i < list.size(); i++) {
//            aBook = (Book) list.get(i);
//            if (isbn.equals(aBook.getIsbn())) {
//                break;
//            } // end if
//        } // end for
//        return aBook;
//    } // end getBookFromList
    }
    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    //Get Servlet information
    public String getServletInfo() {
        return "controller.FrontController Information";
    }

}
