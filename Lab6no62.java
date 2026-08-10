package lab6no62;

import java.util.Scanner;

class Date {
    private int day, year;
    private String month;

    public Date() {
        day = 0;
        month = " ";
        year = 0;
    }

    public Date(int day, int year, String month) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

class Person {
    private String name, surname;
    private int age;
    private Date bDate;

    public Person() {
        name = " ";
        surname = " ";
        age = 0;
        bDate = new Date();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        age = 0;
        bDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBdate() {
        return bDate;
    }

    public void setBdate(Date bDate) {
        this.bDate = bDate;
    }

    @Override
    public String toString() {
        return name + " " + surname
                + ", Age:" + age
                + ", Birth Date:" + bDate;
    }
}

class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private Person objPerson;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
        objPerson = new Person();
    }

    public Account(int id, double balance, Date dateCreated) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        this.dateCreated = dateCreated;
        objPerson = new Person();
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
    
    public Person getObjPerson() {
        return objPerson;
    }

    public void setObjPerson(Person objPerson) {
        this.objPerson = objPerson;
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
    
    public void withdraw(double amount, int withdrawYear) {
        withdraw(amount);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transferMoney(Account acc1, double amount) {

        if (balance >= amount) {
            withdraw(amount);
            acc1.deposit(amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return "Account ID: " + id+ "\nBalance: " + balance+ "\nAnnual Interest Rate: " + annualInterestRate+ "\nDate Created: " + dateCreated+ "\nPerson: " + objPerson;
    }
}


class FixAccount extends Account {

    public FixAccount() {
        super();
    }

    public FixAccount(int id, double balance, Date dateCreated) {
        super(id, balance, dateCreated);
    }

    @Override
    public void withdraw(double amount, int withdrawYear) {

        int accountYear = getDateCreated().getYear();

        if (withdrawYear >= accountYear + 1) {

            super.withdraw(amount);

            System.out.println("Withdraw successful.");

        } else {

            System.out.println(
                "Cannot withdraw. Must wait at least 1 year."
            );
        }
    }

    @Override
    public void transferMoney(Account acc1, double amount) {

        System.out.println(
            "Fix Account cannot transfer money."
        );
    }
}

public class Lab6no62 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Id: ");
        int id = sc.nextInt();
        System.out.print("Balance: ");
        double bl = sc.nextDouble();
        System.out.print("Rate: ");
        double rate = sc.nextDouble();

        Date dateCreated = new Date(1, 2025, "January");
        
        FixAccount acc = new FixAccount(id, bl, dateCreated);
        
        acc.setAnnualInterestRate(rate);
        
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Surname: ");
        String surname = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("BirthDay: ");
        int day = sc.nextInt();
        String month = sc.next();
        int year = sc.nextInt();
        
        Date BirthDate = new Date(day,year,month);
        Person person = new Person(name,surname);
        person.setAge(age);
        person.setBdate(BirthDate);

        acc.setObjPerson(person);
        
        System.out.print("Enter withdrawal year: ");
        int withdrawYear = sc.nextInt();
    
        System.out.print("withdraw : ");
        double withdraw = sc.nextDouble();

        acc.withdraw(withdraw,withdrawYear);


        System.out.print("deposit : ");
        double deposit = sc.nextDouble();

        acc.deposit(deposit);
        
        Account acc2 = new Account(1100, 0, new Date());
        
        System.out.print("transfer : ");
        double transfer = sc.nextDouble();

        acc.transferMoney(acc2, transfer);
        
        System.out.println("Remaining Balance: "+ acc.getBalance());
        System.out.println("Monthly Interest: "+ acc.getMonthlyInterest());
        
    }
}