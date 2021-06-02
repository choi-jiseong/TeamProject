package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentQRcode extends Fragment {

    private View view;
    private TextView tvName, tvClass_name;
    private Button qAm;
    private Button qPm;
    private Button qLe;
    private String status, id, name, email, position, class_name, jwt;
    private StudentActivity studentActivity = new StudentActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_qrcode, container, false);

        qAm = view.findViewById(R.id.q_am_attendance);
        qPm = view.findViewById(R.id.q_pm_attendance);
        qLe = view.findViewById(R.id.q_leave);
        tvName = view.findViewById(R.id.q_student_name);
        tvClass_name = view.findViewById(R.id.q_student_class);



        Bundle bundle = getArguments();
        id = bundle.getString("id");
        name = bundle.getString("name");
        email = bundle.getString("email");
        position = bundle.getString("position");
        class_name = bundle.getString("class_name");
        jwt = bundle.getString("jwt");
        if(bundle != null){
            tvName.setText(name);
            tvClass_name.setText(bundle.getString("class_name"));
        }

        qAm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                data("am");
            }

        });

        qPm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                data("pm");
            }

        });

        qLe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                data("leave");
            }

        });

        return view;
    }
    //data 보내기 + 화면전환
    private void data(String status){
        Intent intent = new Intent(getActivity(), QRcodeActivity.class);
        intent.putExtra("attendance", status);
        intent.putExtra("id", id);
        intent.putExtra("name", name);
        intent.putExtra("jwt", jwt);
        startActivity(intent);
    }

}
