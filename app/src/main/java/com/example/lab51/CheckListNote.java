package com.example.lab51;

import java.util.ArrayList;
import java.util.List;

// สืบทอดคุณสมบัติจากคลาส Note (Inheritance)
public class CheckListNote extends Note {
    private List<String> checklistItems;

    public CheckListNote() {
        super();
        this.checklistItems = new ArrayList<>();
    }

    public CheckListNote(String title, String createDate, List<String> checklistItems) {
        super(title, createDate);
        this.checklistItems = checklistItems;
    }

    public List<String> getChecklistItems() {
        return checklistItems;
    }

    public void setChecklistItems(List<String> checklistItems) {
        this.checklistItems = checklistItems;
    }

    // แสดงผลข้อมูลตามรูปแบบของ CheckList (Polymorphism)
    @Override
    public void getSummary() {
        String ownerName = (getOwner() != null) ? getOwner().getName() : "Unknown";
        System.out.println("CheckList by " + ownerName + ": " + getTitle() + " | รายการ: " + checklistItems + " (สร้างเมื่อ: " + getCreateDate() + ")");
    }

    @Override
    public String display() {
        return "Title: " + getTitle() + "\nChecklist: " + checklistItems + "\nDate: " + getCreateDate();
    }
}