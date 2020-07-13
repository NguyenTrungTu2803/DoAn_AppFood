package com.example.doan_appfood.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseSQLite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "appfood";

    public  static final String TABLE_NAME_2 = "SanPham";
    public  static final String KEY_1 = "id";
    public  static final String KEY_2 = "ItemName";
    public  static final String KEY_3 = "ItemQuantity";
    public  static final String KEY_4 = "ItemPrice";

    public DatabaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseSQLite(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_2 +" " +
                "(id integer primary key autoincrement,itemname text,itemquantity text,itemprice text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_2);
        onCreate(db);
    }

    //ORDER DETAILS DATABASE WORK

    public boolean Add_to_Cart(String Name,String Quantity,String Price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(KEY_2, Name);
        contentValues1.put(KEY_3, Quantity);
        contentValues1.put(KEY_4, Price);
        double check = db.insert(TABLE_NAME_2, null, contentValues1);
        if (check == -1) return false;
        else return true;
    }
    public Cursor Get_OrderDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME_2, null);
        return data;
    }

    public Integer delete_one(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_2,"Id = ?",new String [] {id});

    }
    public void delete_all( ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME_2);
    }
}
