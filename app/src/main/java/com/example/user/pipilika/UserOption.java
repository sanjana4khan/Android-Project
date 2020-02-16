package com.example.user.pipilika;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class UserOption extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_option);
    }
    public void showList(View view)
    {
        Intent intent =new Intent(UserOption.this,ListActivity2.class);
        startActivity(intent);
    }


}
