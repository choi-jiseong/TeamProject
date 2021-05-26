package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentHome extends Fragment {

    private View view;
    private TextView homeName, homeClass;
    protected ImageView homePoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_home, container, false);

        homeName = view.findViewById(R.id.hStudentName);
        homeClass = view.findViewById(R.id.hStudentClass);
        homePoto = view.findViewById(R.id.hProfileImage);

     //   Intent intent = Intent.getIntent();
     //   String email = intent.getStringExtra("email");
     //   String class_room = intent.

     //s   homeName.setText(email);
    //    homeClass.setText();

        return view;
    }
}
