package com.example.user.pipilika;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_bookActivity extends Activity {
    Database database;
    Book_info bi=new Book_info();
    EditText editBookName,editAuthor,editEdition;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        database=new Database(this);
        editBookName=(EditText)findViewById(R.id.book_name);
        editAuthor=(EditText)findViewById(R.id.author);
        editEdition=(EditText)findViewById(R.id.edition);
        addButton= (Button)findViewById(R.id.add_book);
        /*bi.setAuthor(editAuthor.getText().toString());
        bi.setBook_name(editBookName.getText().toString());
        bi.setEdition(editEdition.getText().toString());*/
        addBook();


    }
    public void addBook()
    {
        addButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(editBookName.getText().toString().isEmpty()||editAuthor.getText().toString().isEmpty()||
                                editEdition.getText().toString().isEmpty())
                        {
                            Toast.makeText(Add_bookActivity.this, "Some Fields Are Empty", Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            boolean isInserted = database.insert_data(editBookName.getText().toString(),
                                    editAuthor.getText().toString(), editEdition.getText().toString());


                            if (isInserted = true) {
                                Toast.makeText(Add_bookActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                editBookName.setText(null);
                                editAuthor.setText(null);
                                editEdition.setText(null);


                            }
                        }
                        //database.insert_data(bi);


                    }
                }
        );





    }


}
