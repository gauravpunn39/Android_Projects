package com.gauravpunn.twitterclone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
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

    String title,message,email;
    TextInputEditText unameET,emailET,passET;
    Button registerBtn;

    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
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

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            alertDisplayer("Successful Sign Up!","Welcome" + unameET.getText().toString() + "!");
                            /*Toast.makeText(RegisterActivity.this,
                                    "Congratulations" + unameET.getText().toString() + "! \n You are registered"
                                    , Toast.LENGTH_SHORT).show();*/
                        }

                        else{
                            Toast.makeText(RegisterActivity.this, e.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
