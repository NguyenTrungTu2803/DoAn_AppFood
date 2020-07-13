package com.example.doan_appfood.Model;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan_appfood.Class.User_Cl;
import com.example.doan_appfood.Interface.ModelResponseToPresenter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangNhap_M {

    private String sodt, password;

    private DatabaseReference dataFB;
    private User_Cl userCl;
    private String UserId;


    private void ConnectFirebase(){
        dataFB = FirebaseDatabase.getInstance().getReference();
        UserId = dataFB.push().getKey();
    }
    private ModelResponseToPresenter callback;

    public DangNhap_M(ModelResponseToPresenter callback){
        this.callback = callback;
    }

    public void hand_DN_R(String sdt,String user, String pass, String email){
        userCl = new User_Cl(sdt, user, pass, email);
        ConnectFirebase();
        if(!sdt.equals("") && !user.equals("") && !pass.equals("") && !email.equals("")){
            dataFB.child("user").push().setValue(userCl, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                    if(databaseError == null)
                        callback.onRegisterSuccess();
                    else
                        callback.onRegisterFailed();
                }
            });
        }
        else
            callback.onRegisterFailed();
    }
    public void hand_DN_L(final String sdt, final String pass){

        ConnectFirebase();
        if(!sdt.equals("") && !pass.equals("")) {
            dataFB.child("user").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    userCl = dataSnapshot.getValue(User_Cl.class);
                    if (sdt.equals(userCl.getSdt()) && pass.equals(userCl.getPass())) {
                        callback.onLoginSuccess();
                    }
                    else {
                        callback.onLoginFailed();
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        //else
            //callback.onLoginFailed();
    }

}
