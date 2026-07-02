package com.mycompany.fahrenheit2;

import java.util.Scanner;

public class Fahrenheit2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter Fahrenheit = ");
        double fahrenheit = input.nextDouble();
        double celsius = (5.0/9.0) * (fahrenheit-32);
        System.out.printf("Celsius = %.2f ",celsius);
    }
}
