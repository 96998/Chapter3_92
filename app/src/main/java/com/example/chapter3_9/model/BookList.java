package com.example.chapter3_9.model;

import java.util.ArrayList;


/**
 * @author Alexander Jiajiason
 * @date 2019-06-01 13:57
 */
public class BookList extends ArrayList<Book> {

    private static final long serialVersionUID = 1L;

    private static BookList booklist = null;

    private BookList() {
        Book b1 = new Book("001", "c++", "24");
        Book b2 = new Book("002", "java", "45");
        Book b3 = new Book("003", "计算机", "21");
        add(b1);
        add(b2);
        add(b3);
    }

    public static BookList getBookList() {
        if (booklist == null)
            booklist = new BookList();
        return booklist;
    }
}

