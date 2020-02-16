package com.example.user.pipilika;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends Activity {
    Database database;
    Book_info bi=new Book_info();
    EditText edit_delete_id;
    Button delete_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        database=new Database(this);
        edit_delete_id=(EditText)findViewById(R.id.delete_tf);
        delete_Button= (Button)findViewById(R.id.delete_button);
        delete_book();


    }
    //int id=(edit_delete_id.getText().toString())
    public void delete_book()
    {
        delete_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("deleting","deleting");
                        if(isEmpty(edit_delete_id)) {
                            Toast.makeText(DeleteActivity.this, "Insert Id ", Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            boolean isDeleted = database.delete(Integer.parseInt(edit_delete_id.getText().toString()));


                            if (isDeleted = true)
                            {
                                Toast.makeText(DeleteActivity.this, "Data deleted", Toast.LENGTH_LONG).show();

                            }
                            else
                                Toast.makeText(DeleteActivity.this, "Data not deleted", Toast.LENGTH_LONG).show();
                        }


                        //database.insert_data(bi);


                    }
                }
        );





    }
    public boolean isEmpty(EditText et)
    {
        if(et.getText().toString().trim().length()>0)
        {
            return  false;
        }
        return true;
    }


}
