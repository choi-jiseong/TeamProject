package com.example.teamproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class StudentMy extends Fragment {

    private View view;
    private ImageView imageView;
    private EditText etName, etClass_name, etEmail;
    private Button changeBtn;
    private int REQUEST_IMAGE_CODE = 1001;
    private int REQUEST_EXTERNAL_STORAGE_PERMISSION = 1002;
    private StudentHome profile = new StudentHome();
    private StudentActivity studentActivity = new StudentActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.student_my, container, false);

        imageView = view.findViewById(R.id.mProfileImage);
        changeBtn = view.findViewById(R.id.mBtnChangeImage);
        etName = view.findViewById(R.id.etMname);
        etClass_name = view.findViewById(R.id.etMclass);
        etEmail = view.findViewById(R.id.etMeamil);

        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        String position = bundle.getString("position");
        String class_name = bundle.getString("class_name");
        String jwt = bundle.getString("jwt");
        if(bundle != null){
            etName.setText(name);
            etClass_name.setText(class_name);
            etEmail.setText(email);
        }
//    <----------------------------------사진관련코드------------------------------->
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_CONTACTS)){

            }else{
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE_PERMISSION);
            }
        }

        //사진변경 버튼
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
                startActivityForResult(in, REQUEST_IMAGE_CODE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CODE){
            Uri image = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), image);
                imageView.setImageBitmap(bitmap);
                //profile.homePoto.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //    <----------------------------------사진관련코드------------------------------->
}
