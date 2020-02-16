package com.example.user.pipilika;

import android.widget.EditText;

/**
 * Created by USER on 1/21/2017.
 */

public class Book_info {
    private String book_name,author,edition;
    private int id;


    public Book_info() {

    }

    public Book_info(int id,String add_book, String author, String edition) {
        this.id=id;
        this. book_name = add_book;
        this.author = author;
        this.edition = edition;
    }
    public Book_info(String add_book, String author, String edition) {

        this. book_name = add_book;
        this.author = author;
        this.edition = edition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {

        return  book_name;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public void setBook_name(String add_book) {
        this. book_name = add_book;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }


}
