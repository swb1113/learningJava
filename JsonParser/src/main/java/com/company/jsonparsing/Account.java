package com.company.jsonparsing;

import java.util.List;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties
public class Account {
    private String name;
    private int accountID;
    private Double balance;

    public Account(){
    }

    public Account(String name, int accountID, Double balance){
        this.name = name;
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
