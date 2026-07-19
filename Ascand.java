package com.mycompany.ascand;

import java.util.Arrays;
import java.util.Scanner;

public class Ascand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter n : ");
        int n = input.nextInt();
        
        double[] rawData = new double[n];
        System.out.print("Enter number : ");
        for (int i = 0; i < n; i++) {
            rawData[i] = input.nextDouble();
        }
        
        AscendSortFreq sorter = new AscendSortFreq(rawData);
        
        double[] B = sorter.AscendSort();
        double[] C = sorter.SortCommuFreq(B);
        
        for (double val : B) {
            System.out.print((int)val + " "); 
        }
        System.out.println();
        
        for (double val : C) {
            System.out.print((int)val + " ");
        }
        System.out.println();
    }
}

class AscendSortFreq {
    private double[] A;

    public AscendSortFreq(double[] inputA) {
        this.A = Arrays.copyOf(inputA, inputA.length);
    }

    public double[] AscendSort() {
        double[] B = Arrays.copyOf(this.A, this.A.length);
        Arrays.sort(B); 
        
        int uniqueCount = 0;
        for (int i = 0; i < B.length; i++) {
            if (i == 0 || B[i] != B[i - 1]) {
                uniqueCount++;
            }
        }
        
        double[] uniqueB = new double[uniqueCount];
        int index = 0;
        for (int i = 0; i < B.length; i++) {
            if (i == 0 || B[i] != B[i - 1]) {
                uniqueB[index++] = B[i];
            }
        }
        return uniqueB;
    }

    public double[] SortCommuFreq(double[] B) {
        double[] C = new double[B.length];
        
        for (int i = 0; i < B.length; i++) {
            int count = 0;
            for (int j = 0; j < this.A.length; j++) {
                if (this.A[j] <= B[i]) {
                    count++;
                }
            }
            C[i] = count; 
        }
        return C;
    }
}