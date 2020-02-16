package com.example.user.pipilika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class BookDetails extends AppCompatActivity {
    Database db;
    TextView idTv,nameTv,authorTv,editionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        idTv=(TextView)findViewById(R.id.bId);
        nameTv=(TextView)findViewById(R.id.bName);
        authorTv=(TextView)findViewById(R.id.bAuthor);
        editionTv=(TextView)findViewById(R.id.bEdition);

        Intent intent=getIntent();
        db=new Database(this);
        Bundle bundle = intent.getExtras();

        String booknames = bundle.getString("bookname");
        Book_info myBookList=db.getBook(booknames);
        int id=myBookList.getId();
        String name=myBookList.getBook_name();
        String author=myBookList.getAuthor();
        String edition=myBookList.getEdition();
        idTv.setText(String.valueOf(id));
        nameTv.setText(name);
        authorTv.setText(author);
        editionTv.setText(edition);



           /* String result="Id: "+  myBookList.getId()+" Name: "+  myBookList.getBook_name()+" Author.: "+
                    myBookList.getAuthor()+" Edition.: "+  myBookList.getEdition();
            Log.d("Name: ",result);*/






    }
}
