package com.example.doan_appfood.Class;

public class User_Cl {
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public  User_Cl(){}

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public User_Cl(String sdt, String user, String pass, String email) {
        this.sdt = sdt;
        this.user = user;
        this.pass = pass;
        this.email = email;
    }

    public User_Cl(String sdt, String pass) {
        this.sdt = sdt;
        this.pass = pass;
    }

    public String sdt;
    public String user;
    public String pass;
    public String email;

    public String getSdt() {
        return sdt;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

}
