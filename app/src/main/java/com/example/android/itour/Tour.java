package com.example.android.itour;

public class Tour {

    private String title;
    private int imageview;
    private String country;

    public Tour() {
    }

    public Tour(String title, int imageview) {
        this.title = title;
        this.imageview = imageview;
    }

    public Tour(String title, String country, int imageview) {
        this.title = title;
        this.country = country;
        this.imageview = imageview;
    }

    public String getTitle() {
        return title;
    }

    public int getImageview() {
        return imageview;
    }

    public String getCountry() {
        return country;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
