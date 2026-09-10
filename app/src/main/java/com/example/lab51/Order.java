package com.example.lab51;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// คลาสจัดการคำสั่งซื้อ
public class Order {
    private String id;
    private Date date;
    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(String id, Date date, List<OrderItem> items) {
        this.id = id;
        this.date = date;
        this.items = items;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    // คำนวณราคารวมของสินค้าทั้งหมดใน Order
    public float calculateTotal() {
        float total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
