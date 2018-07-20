package com.gauravpunn.twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    TextView signup,forgotpass;
    Button loginBtn;
    TextInputEditText emailET2,passET2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = (TextView)findViewById(R.id.SignUpButton);
        forgotpass = (TextView)findViewById(R.id.ForgotPasswordButton);
        loginBtn = (Button)findViewById(R.id.LoginButton);
        emailET2 = (TextInputEditText)findViewById(R.id.EmailEditT2);
        passET2 = (TextInputEditText)findViewById(R.id.PasswordEditT2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(reg);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(home);

            }
        });
    }
}
