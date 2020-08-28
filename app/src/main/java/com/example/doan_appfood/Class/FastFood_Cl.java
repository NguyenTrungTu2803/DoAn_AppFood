package com.example.doan_appfood.Class;

public class FastFood_Cl {
    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemImage() {
        return itemImageUrl;
    }

    public String getItemQuatity() {
        return itemQuatity;
    }

    public FastFood_Cl(){}

    public FastFood_Cl(String itemName, String itemPrice, String itemImage, String itemQuatity) {
        this.itemGia = itemGia;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImageUrl = itemImage;
        this.itemQuatity = itemQuatity;
    }

    private  String itemName;

    public String getItemGia() {
        return itemGia;
    }

    private String itemGia;
    private  String itemPrice;
    private  String itemImageUrl;

    public void setItemQuatity(String itemQuatity) {
        this.itemQuatity = itemQuatity;
    }

    public String itemQuatity;



}
