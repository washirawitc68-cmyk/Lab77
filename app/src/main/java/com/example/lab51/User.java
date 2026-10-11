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

    public class VipUser extends User {
        private String vipStatus;

        public VipUser() {
            super();
        }

        public VipUser(String userId, String id, String name, String password, String vipStatus) {
            super(userId, id, name, password);
            this.vipStatus = vipStatus;
        }

        public String getVipStatus() {
            return vipStatus;
        }

        public void setVipStatus(String vipStatus) {
            this.vipStatus = vipStatus;
        }

        @Override
        public boolean authenticate() {
            System.out.println("Authenticating VIP User: " + getName());
            return super.authenticate();
        }
    }


    public class Address {
        private String street;
        private String city;
        private String zipCode;

        public Address() {}

        public Address(String street, String city, String zipCode) {
            this.street = street;
            this.city = city;
            this.zipCode = zipCode;
        }

        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public String getZipCode() { return zipCode; }
        public void setZipCode(String zipCode) { this.zipCode = zipCode; }

        public boolean isValid() {
            return street != null && city != null && zipCode != null;
        }
    }

}


