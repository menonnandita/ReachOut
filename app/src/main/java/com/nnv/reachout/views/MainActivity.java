package com.nnv.reachout.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.User;
import com.nnv.reachout.R;
import com.nnv.reachout.utils.Config;


public class MainActivity extends Activity implements View.OnClickListener {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = (Button) findViewById(R.id.login);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == (R.id.login)){
            Config.getKinveyClient().user().login(username.getText().toString(), password.getText().toString(), new KinveyUserCallback() {

            @Override
            public void onFailure(Throwable error) {
                Log.e("Hi", "Login Failure", error);
            }

            @Override
            public void onSuccess(User result) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

        }

    }
}
