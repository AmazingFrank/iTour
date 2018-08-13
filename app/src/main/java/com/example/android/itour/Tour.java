package com.example.android.itour;

public class Tour {

    private String title;
    private int imageview;

    public Tour() {
    }

    public Tour(String title, int imageview) {
        this.title = title;
        this.imageview = imageview;
    }

    public String getTitle() {
        return title;
    }

    public int getImageview() {
        return imageview;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }
}
