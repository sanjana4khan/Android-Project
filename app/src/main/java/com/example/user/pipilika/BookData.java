package com.example.user.pipilika;

import android.content.Context;

/**
 * Created by USER on 2/6/2017.
 */

public class BookData {
    public void addBookData(Context context)
    {
        Database db=new Database(context);
        db.deleteAll();
        Book_info book=new Book_info("Tales from Shakespeare","William Shakespeare","1st Edition");
        db.insert_data(book.getBook_name(),book.getAuthor(),book.getEdition());
        Book_info book1=new Book_info("Macbeth","William Shakespeare","1st Edition");
        db.insert_data(book1.getBook_name(),book1.getAuthor(),book1.getEdition());
        Book_info book2=new Book_info("Othello","William Shakespeare","1st Edition");
        db.insert_data(book2.getBook_name(),book2.getAuthor(),book2.getEdition());

    }

}
