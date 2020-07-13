package com.example.doan_appfood.Presenter;
import com.example.doan_appfood.Interface.ModelResponseToPresenter;
import com.example.doan_appfood.Model.DangNhap_M;
import com.example.doan_appfood.View.ViewLoginListener;
import com.example.doan_appfood.View.ViewRegisterListener;

public class DangNhap_P implements ModelResponseToPresenter {


    private DangNhap_M dangNhap_m;
    private ViewRegisterListener callbackRegister;
    private ViewLoginListener callbackLogin;

    public DangNhap_P(ViewRegisterListener callbackRegister){
        this.callbackRegister = callbackRegister;
    }

    public DangNhap_P(ViewLoginListener callbackLogin){
        this.callbackLogin = callbackLogin;
    }
    public void recevivedHanDN_R(String sdt,String user, String pass, String email){
        dangNhap_m = new DangNhap_M(this);
        dangNhap_m.hand_DN_R(sdt,user, pass, email);
    }

    public void recevivedHanDN_L(String sdt, String pass){
        dangNhap_m = new DangNhap_M(this);
        dangNhap_m.hand_DN_L(sdt, pass);
    }


    @Override
    public void onRegisterSuccess() {
        callbackRegister.onRegisterSuccess();
    }

    @Override
    public void onRegisterFailed() {
        callbackRegister.onRegisterFailed();
    }

    @Override
    public void onLoginSuccess() {
        callbackLogin.onLoginSuccess();
    }

    @Override
    public void onLoginFailed() {
        callbackLogin.onLoginFailed();
    }
}
