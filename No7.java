package com.mycompany.no7;

import java.util.Scanner;

public class No7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input x,n : ");
        int x = input.nextInt();
        int n = input.nextInt();
        int sum = 0;
        for(int i = 0;i <= n;i++){
            sum = sum + (int)Math.pow(x,i);
        }
        System.out.printf("Output = %d",sum);
    }
}
