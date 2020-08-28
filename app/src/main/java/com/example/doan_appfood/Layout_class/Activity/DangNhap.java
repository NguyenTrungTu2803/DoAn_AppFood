package com.example.doan_appfood.Layout_class.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.doan_appfood.Interface.ModelResponseToPresenter;
import com.example.doan_appfood.Model.DangNhap_M;
import com.example.doan_appfood.R;
import com.example.doan_appfood.Adapter.ViewPage_DN_Adapter;
import com.example.doan_appfood.Layout_class.fagment.fagment_login;
import com.example.doan_appfood.Layout_class.fagment.fragment_register;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class DangNhap extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        findId();
        TabAdd(viewPager);
        //Upload();
    }

    private void TabAdd(ViewPager viewPager) {
        ViewPage_DN_Adapter viewPage_dn_adapter = new ViewPage_DN_Adapter(getSupportFragmentManager());
        viewPage_dn_adapter.add(new fagment_login(), "Đăng nhập");
        viewPage_dn_adapter.add(new fragment_register(), "Đăng ký");
        viewPager.setAdapter(viewPage_dn_adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void findId(){
        viewPager = findViewById(R.id.vpdangnhap);
        tabLayout = findViewById(R.id.tabdangnhap);
    }
    /*void Upload(){
        if(filePath!= null){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(DangNhap.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(DangNhap.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }*/
}
