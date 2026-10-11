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


    public static class OrderItem {
        private String productId;
        private int quantity;
        private float price;

        public OrderItem() {}

        public OrderItem(String productId, int quantity, float price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public float getPrice() { return price; }
        public void setPrice(float price) { this.price = price; }
    }


    public static class Payment {
        public enum Status {
            PENDING, SUCCESS, FAILED
        }

        private String id;
        private float amount;
        private Status status;

        public Payment() {}

        public Payment(String id, float amount, Status status) {
            this.id = id;
            this.amount = amount;
            this.status = status;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public float getAmount() { return amount; }
        public void setAmount(float amount) { this.amount = amount; }

        public Status getStatus() { return status; }
        public void setStatus(Status status) { this.status = status; }

        // จำลองกระบวนการชำระเงิน
        public void process() {
            System.out.println("กำลังดำเนินการชำระเงินจำนวน: " + amount);
            this.status = Status.SUCCESS;
        }
    }
}
