package com.example.lemomall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email, password;
    private ImageView login;
    private TextView forgetPassword, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        register = findViewById(R.id.join);
        register.setOnClickListener(this);
        forgetPassword = findViewById(R.id.forget_password);
        forgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                if(allInfoExist()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                break;
            case R.id.join:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.forget_password:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.forget_password_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.show();
    }

    private boolean allInfoExist() {
        if(email.getText().toString().isEmpty()){
            email.setError("Enter Your Email Here!");
            return false;
        }else{
            email.setError(null);
        }
        if(password.getText().toString().isEmpty()){
            password.setError("Enter Your Password Here!");
            return false;
        }else{
            password.setError(null);
        }
        return true;
    }
}