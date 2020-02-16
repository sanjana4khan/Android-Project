package com.example.user.pipilika;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_upActivity extends Activity {
    Database database;
    EditText edit_name,  edit_semester, edit_year, edit_user__name, edit_password,edit_password2;
    Button register_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = new Database(this);
        edit_name = (EditText) findViewById(R.id.name);

        edit_semester = (EditText) findViewById(R.id.semester);
        edit_year = (EditText) findViewById(R.id.year);
        edit_user__name = (EditText) findViewById(R.id.username);
        edit_password = (EditText) findViewById(R.id.password);
        edit_password2 = (EditText) findViewById(R.id.password2);
        register_button = (Button) findViewById(R.id.register);
       sign_up();
    }
    //int semester=Integer.parseInt(edit_semester.getText().toString());
    //int year=Integer.parseInt(edit_year.getText().toString());

    public void sign_up() {
        register_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isEmpty(edit_name) || isEmpty( edit_semester) || isEmpty(edit_year)
                                || isEmpty(edit_user__name) || isEmpty(edit_password) )
                        {
                            Toast.makeText(Sign_upActivity.this, "Some Fields Lying Empty", Toast.LENGTH_LONG).show();
                        }
                        else
                        {




                                if(edit_password.getText().toString().equals(edit_password2.getText().toString()))
                                {
                                    boolean isInserted = database.insert_signup_data(  edit_name.getText().toString(),
                                            edit_semester.getText().toString(), edit_year.getText().toString(),
                                            edit_user__name.getText().toString(),edit_password.getText().toString());
                                    if(isInserted==true) {

                                        Toast.makeText(Sign_upActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(Sign_upActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                    }

                                }
                                else
                                {
                                    Toast.makeText(Sign_upActivity.this, "Passwords Don't Match ", Toast.LENGTH_LONG).show();
                                }

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