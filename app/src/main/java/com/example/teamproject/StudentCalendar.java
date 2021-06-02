package com.example.teamproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class StudentCalendar extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_calendar, container, false);

        Bundle bundle = getArguments();

        if(bundle != null){
//            System.out.println(bundle.getString("name"));
//            homeName.setText(bundle.getString("name"));
//            homeClass.setText(bundle.getString("class_name"));
        }

        return view;
    }
}
