package com.example.secondcupcafe;

public class BreakfastModel {


    private String title;
    private String price;
    private String imageURL;

    public BreakfastModel(String title, String price, String imageURL) {
        this.title = title;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BreakfastModel(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
