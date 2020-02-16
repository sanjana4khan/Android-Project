package com.example.user.pipilika;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity2 extends AppCompatActivity {
    Database db;
    List<Book_info> myBookList;
    ArrayAdapter<String> adapter;
    EditText filterText;
    ArrayList<String>list;
    ListView listView;





    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        listView = (ListView) findViewById(R.id.book_list2);


        db=new Database(this);

       myBookList=db.getAllBooks();
       final String string[]= new String[myBookList.size()];



           //  myBookList=db.getAllBooks();
            int i = 0;

         for (Book_info b : myBookList) {
             string[i] = new String(b.getBook_name());
             Log.d("List Book ", string[i]);
             i++;
         }
             adapter = new ArrayAdapter<String>(this, R.layout.row_design, string);



             listView.setAdapter(adapter);
             listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     Intent intent = new Intent(ListActivity2.this,BookDetails.class);
                     String bookname=adapter.getItem(position);
                     intent.putExtra("bookname",bookname);
                     startActivity(intent);


                 }
             });
             filterText=(EditText)findViewById(R.id.a);
             filterText.addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {

                     ListActivity2.this.adapter.getFilter().filter(s);
                 }

                 @Override
                 public void afterTextChanged(Editable s) {
                 }
             });


}


        }
    // list=new ArrayList<>(Arrays.asList(string));

      /*adapter = new ArrayAdapter<String>(this, R.layout.row_design, string);



        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity2.this,BookDetails.class);
                String bookname=adapter.getItem(position);
                intent.putExtra("bookname",bookname);
                startActivity(intent);


            }
        });
        filterText=(EditText)findViewById(R.id.a);
        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    ListActivity2.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });*/





    /*@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item=menu.findItem(R.id.menuSearch);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String newText) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ListActivity2.this.adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }*/



