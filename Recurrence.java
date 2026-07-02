package com.mycompany.recurrence;

import java.util.Scanner;

public class Recurrence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input n, a0 and a1: ");
        int n = input.nextInt();
        long a0 = input.nextLong();
        long a1 = input.nextLong();
        long[] a = new long[n + 1];
        a[0] = a0;
        a[1] = a1;
        for (int k = 2; k <= n; k++) {
            long kSquared = (long) k * k;
            long threeToTheK = (long) Math.pow(3, k);
            a[k] = (kSquared * a[k - 1]) - a[k - 2] + threeToTheK;
        }
        System.out.print("Output is: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}