package com.pluralsight;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    // Abstract methods for subclasses to implement
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

    // Getters
    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    // toString for debugging or output
    @Override
    public String toString() {
        return "Contract{" +
                "date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicle=" + vehicle +
                ", totalPrice=" + getTotalPrice() +
                ", monthlyPayment=" + getMonthlyPayment() +
                '}';
    }
}