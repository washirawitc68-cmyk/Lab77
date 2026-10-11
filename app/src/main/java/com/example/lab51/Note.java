package com.example.lab51;

public abstract class Note {
    private String title;
    private String createDate;
    private User owner;

    public Note() {}

    public Note(String title, String createDate) {
        this.title = title;
        this.createDate = createDate;
    }

    public Note(String title, String createDate, User owner) {
        this.title = title;
        this.createDate = createDate;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public abstract void getSummary();

    public abstract String display();
}
