package com.example.foodie_pie_main;

import android.provider.ContactsContract;

public class SalesInfo {
    private String Title;
    private String Type;
    private String Address;
    private String FoodImageID;
    private int TypeImageID;
    private String Name;
    private String Detail_Info;
    private String Buy_Date;
    private String Due_Date;
    public SalesInfo(String title, String type, String address,String foodImageResourceID,int typeImageResourceID
    , String Name, String Detail_Info, String But_Date, String Due_Date){
        this.Title = title;
        this.Type = type;
        this.Address = address;
        this.FoodImageID = foodImageResourceID;
        this.TypeImageID = typeImageResourceID;
        this.Name = Name;
        this.Detail_Info = Detail_Info;
        this.Buy_Date = Buy_Date;
        this.Due_Date = Due_Date;
    }
    public SalesInfo(){
        ;
    }

    public String getTitle(){
        return Title;
    }
    public String getType(){
        return Type;
    }
    public String getAddress(){
        return Address;
    }
    public String getFoodImageID(){
        return FoodImageID;
    }
    public int getTypeImageID(){
        return TypeImageID;
    }
    public String getName() {return Name;}
    public String getDetail_Info() {return  Detail_Info;}
    public String getBuy_Date() {return Buy_Date;}
    public String getDue_Date() {return Due_Date;}

    public void setTitle(String title) {this.Title = title;}
    public void setType(String type){
        this.Type = type;
    }
    public void setAddress(String address){
        this.Address = address;
    }
    public void setFoodImage(String  foodImageResourceID) {
        this.FoodImageID =foodImageResourceID;
    }
    public void setTypeImage(int  typeImageResourceID) {
        this.TypeImageID = typeImageResourceID;
    }
    public void setName(String name) {this.Name = name;}
    public void setDetail_Info(String detailInfo) {this.Detail_Info = detailInfo;}
    public void setBuy_Date(String buyDate) {this.Buy_Date = buyDate;}
    public void setDue_Date(String dueDate) {this.Due_Date = dueDate;}


}
