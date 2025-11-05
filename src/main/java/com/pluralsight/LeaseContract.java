package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double INTEREST_RATE = 0.04;
    private static final int TERM_MONTHS = 36;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double expectedEndingValue = price * 0.5;
        double leaseFee = price * LEASE_FEE_RATE;
        return (price - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double monthlyRate = INTEREST_RATE / 12;
        return (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -TERM_MONTHS));
    }
}
