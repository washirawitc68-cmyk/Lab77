package com.example.lab51;

public class TextNote extends Note {
    private String content;

    public TextNote() {
        super();
    }

    public TextNote(String title, String createDate) {
        super(title, createDate);
    }

    public TextNote(String title, String createDate, String content) {
        super(title, createDate);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTextContent(String content) {
        this.content = content;
    }

    @Override
    public void getSummary() {
        String ownerName = (getOwner() != null) ? getOwner().getName() : "Unknown";
        System.out.println("Note by " + ownerName + ": " + getTitle() + " | " + content + " (" + getCreateDate() + ")");
    }

    @Override
    public String display() {
        return "Title: " + getTitle() + "\nContent: " + content + "\nDate: " + getCreateDate();
    }
}
