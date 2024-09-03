package com.example.a25_08_2024;

public class Item {
    int image;
    float rate;
    String name, title;

    public Item(int image, float rate, String name, String title) {
        this.image = image;
        this.rate = rate;
        this.name = name;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
