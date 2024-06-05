package com.example.hnsc.models;

public class Order {
    private int id;
    private String number;
    private double total;
    private int address_id;

    public Order() {
    }

    public Order(int id, String number, double total, int address_id) {
        this.id = id;
        this.number = number;
        this.total = total;
        this.address_id = address_id;
    }

    public Order(String number, double total, int address_id) {
        this.number = number;
        this.total = total;
        this.address_id = address_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
