package com.example.simplebankaccountapps;

import java.io.Serializable;

public class CheckingAccount extends BankAccount implements Serializable {

    private static double serviceCharge=3000.0;
    private static double upperLimit=200000.0;

    public CheckingAccount(String accName, int accountNumber, int age, String phone, String email, double balance, int accountType) {
        super(accName, accountNumber, age, phone, email, balance, accountType);
    }





    public  double getServiceCharge() {
        return serviceCharge;
    }

    public  void setServiceCharge(double serviceCharge) {
        CheckingAccount.serviceCharge = serviceCharge;
    }

    public static double getUpperLimit() {
        return upperLimit;
    }

    public static void setUpperLimit(double upperLimit) {
        CheckingAccount.upperLimit = upperLimit;
    }
}
