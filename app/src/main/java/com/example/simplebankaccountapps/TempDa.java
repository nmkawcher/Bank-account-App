package com.example.simplebankaccountapps;

import java.util.ArrayList;

public class TempDa {

    public static ArrayList<BankAccount>generateAccount(){



    ArrayList<BankAccount> addaccount=new ArrayList();

    addaccount.add(new SavingsAccount("kawcher",11,22,"0181297112","nm@gmail.com",5000,0));
    addaccount.add(new SavingsAccount("shuvo",21,23,"01617401841","shuvo@gmail.com",4900,0));
    addaccount.add(new CheckingAccount("showrob",42,34,"01912977112","nmshowrob@gmail.com",5600,1));
    addaccount.add(new CheckingAccount("shimul",14,34,"01812955444","shimul@gmail.com",5999,1));

    return addaccount;

    }
}
