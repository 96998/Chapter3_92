package com.example.chapter3_9.control;

import com.example.chapter3_9.model.Book;
import com.example.chapter3_9.model.BookList;

/**
 * @author Alexander Jiajiason
 * @date 2019-06-01 13:55
 */
public class Controller {
    public boolean addBook(String id, String name, String price) {
        BookList bookList = BookList.getBookList();
        int i = 0;
        for (; i < bookList.size(); ++i) {
            Book book2 = bookList.get(i);
            String bid = book2.getId();
            if (bid.equals(id)) {
                break;
            }
        }
        if (i == bookList.size()) {
            Book book = new Book(id, name, price);
            bookList.add(book);
            return true;

        }
        return false;
    }

    public BookList searchBook() {
        BookList bookList = BookList.getBookList();
        return bookList;
    }

    public boolean deleteBook(String name) {
        BookList bookList = BookList.getBookList();
        for (int i = 0; i < bookList.size(); ++i) {
            Book book2 = bookList.get(i);
            if (book2.getName().equals(name)) {
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean setBook(String id, String name, String price) {
        BookList bookList = BookList.getBookList();
        for (int i = 0; i < bookList.size(); ++i) {
            Book book2 = bookList.get(i);
            if (book2.getId().equals(id)) {
                Book book = new Book(id, name, price);
                bookList.set(i, book);
                return true;
            }
        }
        return false;

    }
}
