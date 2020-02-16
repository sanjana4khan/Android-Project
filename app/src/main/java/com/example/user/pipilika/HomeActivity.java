package com.example.user.pipilika;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class HomeActivity extends Activity {
    Database database;
    RadioButton rUser,rAdmin;
    EditText userName,password;
    Button login;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        database=new Database(this);
        rUser=(RadioButton)findViewById(R.id.r_user);
        rAdmin=(RadioButton)findViewById(R.id.r_admin);
        userName=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        login();


    }


    public void login()
    {
        login.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(rUser.isChecked()||rAdmin.isChecked())
                        {
                            if (rUser.isChecked()) {
                                String pass = database.login(userName.getText().toString());
                                String p = password.getText().toString();
                                if (p.equals(pass)) {
                                    Toast.makeText(HomeActivity.this, "Signed In", Toast.LENGTH_LONG).show();
                                    userName.setText(null);
                                    password.setText(null);
                                    Intent intent = new Intent(HomeActivity.this, UserOption.class);

                                    startActivity(intent);
                                } else {
                                    Toast.makeText(HomeActivity.this, "Either User Name Or Password is Wrong", Toast.LENGTH_LONG).show();
                                    userName.setText(null);
                                    password.setText(null);

                                }
                            }
                            if (rAdmin.isChecked()) {
                                /// String pass=database.login(userName.getText().toString());
                                String u = userName.getText().toString();
                                String p = password.getText().toString();
                                if (p.equals("admin") && u.equals("admin")) {
                                    Toast.makeText(HomeActivity.this, "Signed In", Toast.LENGTH_LONG).show();
                                    userName.setText(null);
                                    password.setText(null);

                                    Intent intent = new Intent(HomeActivity.this, Admin_optionActivity.class);
                                    startActivity(intent);
                                } else
                                {
                                    Toast.makeText(HomeActivity.this, "Either User Name Or Password is Wrong", Toast.LENGTH_LONG).show();
                                    userName.setText(null);
                                    password.setText(null);
                                }
                            }
                        }
                        else
                        {
                            Toast.makeText(HomeActivity.this, "Select An Option", Toast.LENGTH_LONG).show();
                        }





                    }
                }

        );
    }



}
