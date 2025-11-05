package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;

    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(date, customerName, customerEmail, vehicle);
        this.financeOption = financeOption;
        this.processingFee = vehicle.getPrice() < 10000 ? 295.0 : 495.0;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double salesTax = price * SALES_TAX_RATE;
        return price + salesTax + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financeOption) {
            return 0.0;
        }

        double totalPrice = getTotalPrice();
        double annualInterestRate;
        int termMonths;

        if (getVehicle().getPrice() >= 10000) {
            annualInterestRate = 0.0425;
            termMonths = 48;
        } else {
            annualInterestRate = 0.0525;
            termMonths = 24;
        }

        double monthlyRate = annualInterestRate / 12;
        return (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termMonths));
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public double getRecordingFee() {
        return RECORDING_FEE;
    }
}