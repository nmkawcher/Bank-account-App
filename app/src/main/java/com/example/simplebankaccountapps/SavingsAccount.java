package com.example.simplebankaccountapps;

import java.io.Serializable;

public class SavingsAccount extends BankAccount implements Serializable {

    private  static double interestRate=6.0;
    private static double limit=1000;

    public SavingsAccount(String accName, int accountNumber, int age, String phone, String email, double balance, int accountType) {
        super(accName, accountNumber, age, phone, email, balance, accountType);

    }




    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public  double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                '}';
    }
}
