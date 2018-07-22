package com.gauravpunn.twitterclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText unameET,emailET,passET;
    Button registerBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        unameET = (TextInputEditText)findViewById(R.id.UsernameEditText);
        emailET = (TextInputEditText)findViewById(R.id.EmailEditText);
        passET = (TextInputEditText)findViewById(R.id.PasswordEditText);
        registerBtn = (Button)findViewById(R.id.RegisterButton);

        passET.setTransformationMethod(new PasswordTransformationMethod());

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser user = new ParseUser();
                user.setUsername(unameET.getText().toString());
                user.setEmail(emailET.getText().toString());
                user.setPassword(passET.getText().toString());

                /*ParseObject parseObject = new ParseObject("User");
                parseObject.put("username",unameET.getText().toString());
                parseObject.put("email",emailET.getText().toString());
                parseObject.put("password",passET.getText().toString());
                parseObject.saveInBackground();*/

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            Toast.makeText(RegisterActivity.this,
                                    "Congratulations" + unameET.getText().toString() + "! \n You are registered"
                                    , Toast.LENGTH_SHORT).show();
                        }

                        else{
                            Toast.makeText(RegisterActivity.this, "Registration Unsuccessfull"
                                    , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
