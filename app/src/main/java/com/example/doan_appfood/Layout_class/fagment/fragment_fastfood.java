package com.example.doan_appfood.Layout_class.fagment;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_appfood.Adapter.FastFoodAdapter;
import com.example.doan_appfood.Class.FastFood_Cl;
import com.example.doan_appfood.Class.LoadingFirebase;
import com.example.doan_appfood.Class.PicassoClient;
import com.example.doan_appfood.Model.FastFood_M;
import com.example.doan_appfood.Presenter.FastFood_P;
import com.example.doan_appfood.R;
import com.example.doan_appfood.View.ViewFastFoodListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_fastfood extends Fragment{

    private View view;
    private ListView listView;
    private TextView price, name, quality;
    private ImageView imageView;

    private FastFood_P fastFood_p;

    private ArrayList<FastFood_Cl> fastfood;
    private FastFood_Cl fastFood_Cl;
    private DatabaseReference dataFB;
    public fragment_fastfood() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_fragment_fastfood, container, false);


        listView = view.findViewById(R.id.listview_fastfood);

        return view;
    }
    void load(){
        dataFB.child("fastfood").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fastFood_Cl = dataSnapshot.getValue(FastFood_Cl.class);

                PicassoClient.DownLoading(getContext(), fastFood_Cl.getItemImage(), imageView);
                name.setText(fastFood_Cl.getItemName());
                price.setText(fastFood_Cl.getItemPrice());
                //fastfood= new ArrayList<FastFood_Cl>();
                //fastfood.add(new FastFood_Cl(fastFood_Cl.getItemName(), fastFood_Cl.getItemPrice(),
                //        "https://firebasestorage.googleapis.com/v0/b/appfood-d3ccc.appspot.com/o/beef.png?alt=media&token=a5e78f4b-b37f-4fed-89e3-358ac739248e","0"));

                FastFoodAdapter fastfoodadapter = new FastFoodAdapter(getActivity(),fastfood);


                listView.setAdapter(fastfoodadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
