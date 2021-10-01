package com.ethosa.ktc_app.objects;

public class NewItem {
    public String title;
    public String body;
    public String image;
    public String date;
    public int id;

    public NewItem() {
    }

    public NewItem(int id, String title, String body, String date, String image) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
        this.date = date;
    }
}
