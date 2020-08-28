package com.example.doan_appfood.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan_appfood.Class.FastFood_Cl;
import com.example.doan_appfood.Class.PicassoClient;
import com.example.doan_appfood.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class FastFoodAdapter extends BaseAdapter {

    private int quantity = 0;

    private Context context;
    private FastFood_Cl fastFood;
    private ArrayList<FastFood_Cl> fastFood_cls;

    public FastFoodAdapter(ArrayList<FastFood_Cl> fastFood_cls) {
        this.fastFood_cls = fastFood_cls;
    }

    public FastFoodAdapter(Context context, ArrayList<FastFood_Cl> fastFood_cls) {
        this.context = context;
        this.fastFood_cls = fastFood_cls;
    }
    @Override
    public int getCount() {
        return fastFood_cls.size();
    }

    @Override
    public Object getItem(int position) {
        return fastFood_cls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
         fastFood = (FastFood_Cl) getItem(position);
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.menu_design, null);
        } else viewProduct = convertView;

        ImageView imageView = viewProduct.findViewById(R.id.item_image);
        TextView priceView = viewProduct.findViewById(R.id.item_price);
        TextView nameView = viewProduct.findViewById(R.id.item_name);
        final TextView quantityView = viewProduct.findViewById(R.id.quantity);
        Button btnplus = viewProduct.findViewById(R.id.plus_btn);
        Button btnMinus = viewProduct.findViewById(R.id.minus_btn);
        Button btnCart = viewProduct.findViewById(R.id.cart_btn);


        priceView.setText("Price " +fastFood.getItemPrice());
        nameView.setText(fastFood.getItemName());

        //Picasso.get().load(fastFood.getItemImage()).into(imageView);
        PicassoClient.DownLoading(context, fastFood_cls.get(position).getItemImage(), imageView);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = Integer.parseInt(fastFood.getItemQuatity()) + 1;
                fastFood.setItemQuatity(String.valueOf(quantity));

                //Toast.makeText(context,String.valueOf(quantity) , Toast.LENGTH_SHORT).show();
            }
        });
        quantityView.setText(String.valueOf(quantity));
        Toast.makeText(context,String.valueOf(quantity) , Toast.LENGTH_SHORT).show();


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quantity > 0)
                    quantity = quantity - 1;
                else quantity = quantity;

            }
        });



        return viewProduct;
    }


}
