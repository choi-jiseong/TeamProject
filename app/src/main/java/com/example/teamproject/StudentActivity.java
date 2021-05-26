package com.example.teamproject;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private StudentHome studentHome;
    private StudentCalendar studentCalendar;
    private StudentMy studentMy;
    private StudentQRcode studentQRcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        setFrag(0);
                        break;
                    case R.id.navigation_calendar:
                        setFrag(1);
                        break;
                    case R.id.navigation_identity:
                        setFrag(2);
                        break;
                    case R.id.navigation_qr_code:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        studentHome = new StudentHome();
        studentCalendar = new StudentCalendar();
        studentMy = new StudentMy();
        studentQRcode = new StudentQRcode();
        setFrag(0); //첫 프래그먼트 화면을 무엇으로 지정해줄 것인지 선택
    }

    //프래그먼트 교체가 일어나는 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0 :
                ft.replace(R.id.frameLayout, studentHome);
                ft.commit();
                break;
            case 1 :
                ft.replace(R.id.frameLayout, studentCalendar);
                ft.commit();
                break;
            case 2 :
                ft.replace(R.id.frameLayout, studentMy);
                ft.commit();
                break;
            case 3 :
                ft.replace(R.id.frameLayout, studentQRcode);
                ft.commit();
                break;
        }
    }
}
