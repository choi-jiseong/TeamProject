package com.example.teamproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentCalendar extends Fragment {

    private View view;
    private StudentHome studentHome = new StudentHome();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_calendar, container, false);

        //받아온 데이터
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        String position = bundle.getString("position");
        String class_name = bundle.getString("class_name");
        String jwt = bundle.getString("jwt");
        token(jwt);

        if(bundle != null){
//            System.out.println(bundle.getString("name"));
//            homeName.setText(bundle.getString("name"));
//            homeClass.setText(bundle.getString("class_name"));
        }

        return view;
    }
    private void token(String data){

        String URL = "http://dlswns619.dothome.co.kr/api/auth";

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.i("VOLLEY", String.valueOf(response));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer " + data);

                Log.i("VOLLEY", String.valueOf(params));
                return params;
            }
        };

        stringRequest.setShouldCache(false);
        requestQueue.add(stringRequest);

    }
}
