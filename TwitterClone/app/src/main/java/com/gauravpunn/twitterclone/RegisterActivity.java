package com.gauravpunn.twitterclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText nameET,emailET,passET;
    Button registerBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameET = (TextInputEditText)findViewById(R.id.NameEditText);
        emailET = (TextInputEditText)findViewById(R.id.EmailEditText);
        passET = (TextInputEditText)findViewById(R.id.PasswordEditText);
        registerBtn = (Button)findViewById(R.id.RegisterButton);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
