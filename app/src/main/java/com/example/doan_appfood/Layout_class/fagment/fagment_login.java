package com.example.doan_appfood.Layout_class.fagment;


import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doan_appfood.Class.User_Cl;
import com.example.doan_appfood.Layout_class.Activity.MainActivity;
import com.example.doan_appfood.Presenter.DangNhap_P;
import com.example.doan_appfood.R;
import com.example.doan_appfood.View.ViewLoginListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.snapshot.Index;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class fagment_login extends Fragment implements ViewLoginListener {

    private View view;
    private EditText sdt, pass;
    private Button btn;

    private User_Cl userCl;

    public fagment_login() {
        // Required empty public constructor
    }

    private DangNhap_P dangNhap_p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fagment_login, container, false);

        dangNhap_p = new DangNhap_P(this);


        findId();
        //SetErrol();
        onClick();
        return view;
    }
    private void findId(){
        sdt = view.findViewById(R.id.sdt);
        pass = view.findViewById(R.id.pass);
        btn = view.findViewById(R.id.btn);
    }
    public void SetErrol(){
        if(sdt.getText().toString().length() <10 && sdt.getText().toString().length()>11){
            sdt.setError("Số điện thoại không đúng");
        }
        else if(sdt.getText().toString().equals("")){
            sdt.setError("Số điện thoại không để trống");
        }
        else if(pass.getText().toString().equals("")){
            pass.setError("Mật khẩu không để trống");
        }
    }
    private  void onClick(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetErrol();
                dangNhap_p.recevivedHanDN_L(sdt.getText().toString(), pass.getText().toString());
            }

        });

    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(getActivity(),"Thông tin đăng nhập không đứng" , Toast.LENGTH_SHORT).show();
    }
}
