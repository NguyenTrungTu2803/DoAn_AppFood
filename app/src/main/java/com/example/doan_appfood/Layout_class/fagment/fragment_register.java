package com.example.doan_appfood.Layout_class.fagment;


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
import com.example.doan_appfood.Model.DangNhap_M;
import com.example.doan_appfood.Presenter.DangNhap_P;
import com.example.doan_appfood.R;
import com.example.doan_appfood.View.ViewRegisterListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_register extends Fragment implements ViewRegisterListener {

    private View view;
    public fragment_register() {
        // Required empty public constructor
    }

    private DangNhap_P dangNhap_p;
    private Button btn;
    private EditText email, pass, user, sdt;

    //private DatabaseReference dataFB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_register, container, false);

        dangNhap_p = new DangNhap_P(this);

        findid();
        onclick();
        return view;
    }
    public void findid(){
        btn = view.findViewById(R.id.dangky);
        pass = view.findViewById(R.id.pass);
        user = view.findViewById(R.id.uer);
        email = view.findViewById(R.id.email);
        sdt = view.findViewById(R.id.sdt);
    }
    public void onclick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhap_p.recevivedHanDN_R(sdt.getText().toString(),user.getText().toString(), pass.getText().toString(), email.getText().toString());

            }
        });

    }



    @Override
    public void onRegisterSuccess() {
        Toast.makeText(getActivity(),"Đăng ký thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterFailed() {
        Toast.makeText(getActivity(),"Đăng ký không thành công", Toast.LENGTH_LONG).show();
    }
}
