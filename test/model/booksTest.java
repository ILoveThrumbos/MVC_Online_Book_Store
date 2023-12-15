/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author happy
 */
public class booksTest extends TestCase {

    
    public List<Book> books;

    public booksTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        books = new ArrayList();
        books.add(new Book("1234567890", "Book 1", "Author 1", 10.99));
        books.add(new Book("2345678901", "Book 2", "Author 2", 12.99));
        books.add(new Book("3456789012", "Book 3", "Author 3", 14.99));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

    }

    public void testGetIsbn() {
        Book book = books.get(0);
        assertEquals("1234567890", book.getIsbn());
    }

    public void testGetTitle() {
        Book book = books.get(0);
        assertNotNull(book.getTitle());
    }

    public void testGetAuthor() {
        Book book = books.get(0);
        assertNotNull(book.getAuthor());
    }

    public void testGetPrice() {
         Book book = books.get(0);
         assertEquals(10.99, book.getPrice());
    }

    public void testToString() {
        Book book = books.get(3);
        assertEquals("Book 4",book.toString());
        assertNotNull(book.toString());
        
    }

    public void testGetDollarPrice() {
        Book book = books.get(2);
        assertEquals("$10.99", book.getDollarPrice());
    }
}