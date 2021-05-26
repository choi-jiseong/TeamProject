package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentQRcode extends Fragment {

    private View view;
    private Button qAm;
    private Button qPm;
    private Button qLe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_qrcode, container, false);

        qAm = view.findViewById(R.id.q_am_attendance);
        qPm = view.findViewById(R.id.q_pm_attendance);
        qLe = view.findViewById(R.id.q_leave);

        qAm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QRcodeActivity.class);
                startActivity(intent);
            }

        });

        qPm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QRcodeActivity.class);
                startActivity(intent);
            }

        });

        qLe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QRcodeActivity.class);
                startActivity(intent);
            }

        });

        return view;
    }

}
