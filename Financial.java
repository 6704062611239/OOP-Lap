package com.mycompany.financial;

import java.util.Scanner;

public class Financial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the monthly saving amount : ");
        double monthly = input.nextDouble();
        double sum = 0;
        for(int i = 1;i <= 6;i++){
            sum = (sum + monthly) * (1 + 0.00417);
        }
        System.out.printf("After the sixth month, the account value = %.3f", sum);
    }
}
