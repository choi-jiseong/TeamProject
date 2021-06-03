package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class QRcodeActivity extends AppCompatActivity {
    private ImageView iv;
    private StudentHome studentHome = new StudentHome();
//    private long now = System.currentTimeMillis();
//    private Date date = new Date(now);
    private HashMap<String, Object> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        iv = (ImageView)findViewById(R.id.qrcode);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String getTime = simpleDateFormat.format(date);


        Intent intent = getIntent();
        String attendance = intent.getExtras().getString("attendance");
        String name = intent.getExtras().getString("name");
        String id = intent.getExtras().getString("id");
        String jwt = intent.getExtras().getString("jwt");
        token(jwt);

        map.put("attendance", attendance);
        map.put("id", id);
        map.put("name", name);
        JSONObject data = null;
        try {
            data = getJsonStringFromMap(map);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String data2 = data.toString();
//        String data = "{" +
//               "\"attendance\"" +":"+ "\"" + attendance + "\"," +
//                "\"id\"" + "\"" + getTime + "\"," +
//                "\"name\"" + "\"" + password.getText().toString() + "\"," +
//                "}";

    // qr 코드
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(data2, BarcodeFormat.QR_CODE, 150, 150);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            iv.setImageBitmap(bitmap);


        }catch (Exception e){}
    }
    public static JSONObject getJsonStringFromMap (Map<String, Object> kmap) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, Object> entry : kmap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            jsonObject.put(key, value);
        }
        return jsonObject;
    }
    private void token(String data){

        String URL = "http://dlswns619.dothome.co.kr/api/auth";

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
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