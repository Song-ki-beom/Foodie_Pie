package com.example.foodie_pie_main;

public class SalesInfo {
    private String Title;
    private String Type;
    private String Address;
    private String FoodImageID;
    private int TypeImageID;
    public SalesInfo(String title, String type, String address,String foodImageResourceID,int typeImageResourceID){
        this.Title = title;
        this.Type = type;
        this.Address = address;
        this.FoodImageID = foodImageResourceID;
        this.TypeImageID = typeImageResourceID;
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

    public void setTitle(String title) {
        this.Title = title;
    }
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

}
