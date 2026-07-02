package com.mycompany.occurrence;

import java.util.Scanner;

public class Occurrence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numbers : ");
        int max = Integer.MIN_VALUE; 
        int count = 0;
        while (true) {
            int number = input.nextInt();
            if (number == 0) {
                break;
            }
            if (number > max) {
                max = number; 
                count = 1;    
            } 
            else if (number == max) {
                count++;      
            }
        }
        System.out.printf("%d %d", max, count);
    }
}