package com.example.teamproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private EditText email, password, password2, id, name, phone;
    private Spinner class_name;
    private RadioGroup radioGroup;
    private RadioButton rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText)findViewById(R.id.etRemail);
        password = (EditText)findViewById(R.id.etRpassword);
        password2 = (EditText)findViewById(R.id.etRpassword2);
        name = (EditText)findViewById(R.id.etRname);
        phone = (EditText)findViewById(R.id.etRphone);
        id = (EditText)findViewById(R.id.etRnumberId);
        class_name = findViewById(R.id.spinnerClass);
        radioGroup = findViewById(R.id.radioGroup);
        rd = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());




        Button successBtn = findViewById(R.id.successBtn);
        successBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String email = etRemail.getText().toString();
//                String password = etRpassword.getText().toString();
//                String password2 = etRpassword2.getText().toString();
//                String name = etRname.getText().toString();
//                String phone = etRphone.getText().toString();
//                int id = Integer.parseInt(etRnumberId.getText().toString());
//                String class_name = spinnerClass.getSelectedItem().toString();
//                String position = rd.getText().toString();

                String data = "{" +
                        "\"id\"" + "\"" + Integer.parseInt(id.getText().toString()) + "\"," +
                        "\"name\"" + "\"" + name.getText().toString() + "\"," +
                        "\"password\"" + "\"" + password.getText().toString() + "\"," +
                        "\"email\"" + "\"" + email.getText().toString() + "\"," +
                        "\"class_name\"" + "\"" + class_name.getSelectedItem().toString() + "\"," +
                        "\"position\"" + "\"" + rd.getText().toString() + "\"," +
                        "\"phone\"" + "\"" + phone.getText().toString() + "\"," +
                        "}";
                Log.i("register", data);
                Submit(data);


                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                RegisterActivity.this.startActivity(intent);
            }


        });

        // Spinner
        Spinner yearSpinner = (Spinner)findViewById(R.id.spinnerClass);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.classChoose, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);



    }

    private void Submit(String data){
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("id", Integer.parseInt(id.getText().toString()));
            jsonBody.put("name", name.getText().toString());
            jsonBody.put("password", password.getText().toString());
            jsonBody.put("email", email.getText().toString());
            jsonBody.put("class_name", class_name.getSelectedItem().toString());
            jsonBody.put("position", rd.getText().toString());
            jsonBody.put("phone", phone.getText().toString());
            final String requestBody = jsonBody.toString();

            String URL = "";

            requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}