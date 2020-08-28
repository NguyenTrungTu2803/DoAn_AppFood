package com.example.doan_appfood.Class;

public class LoadingFirebase {

    public LoadingFirebase(){}
    public String getDatabaseReference() {
        return databaseReference;
    }

    private String databaseReference;
    public LoadingFirebase(String DdtabaseReference){
        this.databaseReference = DdtabaseReference;

    }
}
