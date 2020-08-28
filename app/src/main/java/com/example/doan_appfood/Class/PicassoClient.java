package com.example.doan_appfood.Class;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoClient {
    public static void DownLoading(Context context, String url, ImageView imageView){
        if(url != null && url.length()>0)
            Picasso.get().load(url).into(imageView);
    }
}
