package com.example.user.pipilika;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_optionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_option);
    }
    public void add_book(View view)
    {
        Intent intent =new Intent(Admin_optionActivity.this,Add_bookActivity.class );
        startActivity(intent);
    }
    public void delete(View view)
    {
        Intent intent =new Intent(Admin_optionActivity.this,DeleteActivity.class );
        startActivity(intent);
    }
    public void list(View view)
    {
        Intent intent =new Intent(Admin_optionActivity.this,ListActivity2.class );
        startActivity(intent);
    }

}
