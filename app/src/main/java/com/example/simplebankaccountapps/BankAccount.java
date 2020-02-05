package com.example.simplebankaccountapps;

import java.io.Serializable;

public abstract class BankAccount implements Serializable {

    private  String accName;

    private  int accountNumber;
    private int age;
    private String phone;
    private String email;
    private double balance;// initail balance will be balance(main balance)

    private int accountType; // for saving =0,checking will be 1;

    private int upperlimit=200000;
    private int lowerlimit=1000;
    private int minwith=1000;
    private int mindeposit=1000;


    public BankAccount(String accName, int accountNumber, int age, String phone, String email, double balance, int accountType) {
        this.accName = accName;
        this.accountNumber = accountNumber;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccName() {
        return accName;
    }

    public int getaccountNumber() {
        return accountNumber;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public double getbalance() {
        return balance;
    }

    public int getaccountType() {
        return accountType;
    }


  public final String deposit(double ammount){

        if(balance+ammount<=upperlimit){

            balance+=ammount;

            return "your account is credited with ammount:  "+ammount;
        }

        return "unAcceptable request";
  }


    public final String withdraw(double ammonut){

        if(balance-ammonut>=lowerlimit ){

            balance=balance-ammonut;

            return "your account has been debited with amount :"+ammonut;
        }


            return "insufficient fund";




    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setAccountNumber(int accountNumber) {
        accountNumber = accountNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accName='" + accName + '\'' +
                ", AccountNumber=" + accountNumber +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Balance=" + balance +
                ", AccountType=" + accountType +
                '}';
    }
}
