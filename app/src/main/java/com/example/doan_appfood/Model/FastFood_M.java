package com.example.doan_appfood.Model;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.doan_appfood.Adapter.FastFoodAdapter;
import com.example.doan_appfood.Class.FastFood_Cl;
import com.example.doan_appfood.Class.LoadingFirebase;
import com.example.doan_appfood.Class.PicassoClient;
import com.example.doan_appfood.Interface.ModelReponseToPrensenterFood;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FastFood_M {


    private DatabaseReference dataFB;

    private FastFood_Cl fastFood_cl;
    private ModelReponseToPrensenterFood reponse;
    private LoadingFirebase loadingFirebase;

    private TextView price, name, gia;
    private ImageView img;
    private Context context;

    private void ConnectFirebase(){
        dataFB = FirebaseDatabase.getInstance().getReference();
        loadingFirebase = new LoadingFirebase();
    }
    public FastFood_M(ModelReponseToPrensenterFood reponse){
        this.reponse = reponse;
    }
    public void LoadFastFood_M(){
        ConnectFirebase();
        String key = loadingFirebase.getDatabaseReference();
        final ArrayList<FastFood_Cl> food_cls = new ArrayList<>() ;
        FastFoodAdapter adapter = new FastFoodAdapter(context, food_cls);

    }

}
