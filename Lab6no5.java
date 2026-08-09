package com.mycompany.lab6no5;
import java.util.Date;
import java.util.Scanner;

class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

public class Lab6no5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        double bl = sc.nextDouble();
        double al = sc.nextDouble();
        
        Account ac = new Account(id,bl);
        ac.setAnnualInterestRate(al);
        double withdraw = sc.nextDouble();
        ac.withdraw(withdraw);
        System.out.println(ac.getBalance());
        double deposit = sc.nextDouble();
        ac.deposit(deposit);
        System.out.println(ac.getBalance());
        System.out.println(ac.getMonthlyInterestRate());
    }
}