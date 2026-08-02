package com.mycompany.lab5no6;

import java.util.Scanner;

public class Lab5no6 {

    public static boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        if (rows == 0) return false;
        int cols = values[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = values[i][j];

                if (j + 3 < cols) {
                    if (current == values[i][j + 1] &&
                        current == values[i][j + 2] &&
                        current == values[i][j + 3]) {
                        return true;
                    }
                }
                if (i + 3 < rows) {
                    if (current == values[i + 1][j] &&
                        current == values[i + 2][j] &&
                        current == values[i + 3][j]) {
                        return true;
                    }
                }
                if (i + 3 < rows && j + 3 < cols) {
                    if (current == values[i + 1][j + 1] &&
                        current == values[i + 2][j + 2] &&
                        current == values[i + 3][j + 3]) {
                        return true;
                    }
                }
                if (i - 3 >= 0 && j + 3 < cols) {
                    if (current == values[i - 1][j + 1] &&
                        current == values[i - 2][j + 2] &&
                        current == values[i - 3][j + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()) return;
        int rows = input.nextInt(); 
        int cols = input.nextInt(); 
        int[][] values = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i][j] = input.nextInt();
            }
        }
        boolean result = isConsecutiveFour(values);
        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}