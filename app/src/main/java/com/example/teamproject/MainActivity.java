package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final EditText etEmail = (EditText)findViewById(R.id.etEmail);
         final EditText etPassword = (EditText)findViewById(R.id.etPassword);
         Button loginBtn = findViewById(R.id.btnLogin);

       // String stPassword = etPassword.getText().toString();


         //회원가입 버튼
        Button btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {
//                Toast.makeText(MainActivity.this, "회원가입", Toast.LENGTH_LONG).show();
              Intent in = new Intent(MainActivity.this, RegisterActivity.class);
              startActivity(in);
        });

        //로그인 버튼
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            final String email = etEmail.getText().toString();
            final String password = etPassword.getText().toString();
            Intent in2 = new Intent(MainActivity.this, StudentActivity.class);


            startActivity(in2);
        });
    }
}