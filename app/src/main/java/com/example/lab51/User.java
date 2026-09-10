package com.example.lab51;

public class User {
    private String userId;
    private String id;
    private String name;
    private String password;

    public User() {}

    public User(String userId, String id, String name, String password) {
        this.userId = userId;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean changeName(String newName) {
        this.name = newName;
        return true;
    }

    public boolean changePassword(String newPass) {
        this.password = newPass;
        return true;
    }

    public boolean authenticate() {
        System.out.println("Authenticating: " + name);
        return true;
    }
}
