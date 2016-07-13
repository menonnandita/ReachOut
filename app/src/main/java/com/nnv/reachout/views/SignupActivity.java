package com.nnv.reachout.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.User;
import com.kinvey.java.core.KinveyClientCallback;
import com.nnv.reachout.R;
import com.nnv.reachout.utils.Config;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText email;
    EditText phone;
    EditText constituency;
    EditText password;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        constituency = (EditText) findViewById(R.id.constituency);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.register){
            Config.getKinveyClient().user().create(email.getText().toString(), password.getText().toString(), new KinveyUserCallback() {
                @Override
                public void onSuccess(User user) {
                   /* user.put("name", name.getText().toString());
                    user.put("phone", phone.getText().toString());
                    user.put("constituency", constituency.getText().toString());*/
                    Config.getKinveyClient().user().update(user, new KinveyClientCallback<User>() {
                        @Override
                        public void onSuccess(User user) {
                            Intent intent= new Intent(SignupActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Throwable throwable) {

                        }
                    });
                }

                @Override
                public void onFailure(Throwable throwable) {

                }
            });
        }
    }
}
