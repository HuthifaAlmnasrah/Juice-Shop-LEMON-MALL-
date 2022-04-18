package com.example.lemomall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText fullName, phoneNumber, email, password;
    private RadioButton cash, visa;
    private ImageView register, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
    }

    private void initViews() {
        fullName = findViewById(R.id.full_name);
        phoneNumber = findViewById(R.id.phone_number);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cash = findViewById(R.id.cash);
        cash.setOnClickListener(this);
        visa = findViewById(R.id.visa);
        visa.setOnClickListener(this);
        register = findViewById(R.id.register);
        register.setOnClickListener(this);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cash:
                cash.setChecked(true);
                break;
            case R.id.visa:
                visa.setChecked(true);
                break;
            case R.id.register:
                if(allInfoExist()){
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }
                break;
            case R.id.back:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }

    private boolean allInfoExist() {
        if(fullName.getText().toString().isEmpty()){
            fullName.setError("Enter Your Full Name Here");
            return false;
        }else{
            fullName.setError(null);
        }
        if(phoneNumber.getText().toString().isEmpty()){
            phoneNumber.setError("Enter Your Phone Number Here");
            return false;
        }else{
            phoneNumber.setError(null);
        }
        if(email.getText().toString().isEmpty()){
            email.setError("Enter Your Email Here");
            return false;
        }else{
            email.setError(null);
        }
        if(password.getText().toString().isEmpty()){
            password.setError("Enter Your Password Here");
            return false;
        }else{
            password.setError(null);
        }
        return true;
    }
}