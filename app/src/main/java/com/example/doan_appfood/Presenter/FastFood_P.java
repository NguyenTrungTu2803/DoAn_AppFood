package com.example.doan_appfood.Presenter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan_appfood.Class.FastFood_Cl;
import com.example.doan_appfood.Interface.ModelReponseToPrensenterFood;
import com.example.doan_appfood.Model.FastFood_M;
import com.example.doan_appfood.View.ViewFastFoodListener;

import java.util.ArrayList;

public class FastFood_P implements ModelReponseToPrensenterFood {

    private FastFood_M Food_m;
    private ViewFastFoodListener callbackFastfood;

    public FastFood_P(ViewFastFoodListener callbackFastfood){
        this.callbackFastfood = callbackFastfood;
    }
    public void LoadingListView(){
        Food_m = new FastFood_M(this);
        Food_m.LoadFastFood_M();
    }
    @Override
    public void onLoadFastFoodFail() {
        callbackFastfood.onFastFoodFailed();
    }

    @Override
    public void onLoadFastFoodSuccess() {
        callbackFastfood.onFastFoodSuccess();
    }
}
