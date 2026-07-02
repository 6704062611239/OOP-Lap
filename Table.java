package com.mycompany.table;

import java.util.Scanner;

public class Table {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please input number of columns and rows: ");
        int columns = input.nextInt();
        int rows = input.nextInt();
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if (i == 0) {
                    arr[0][j] = j + 2;
                }
                if (j == 0) {
                    arr[i][0] = i + 1;
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if (i > 0 && j > 0) {
                    arr[i][j] = arr[i][0] * arr[0][j];
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.printf("%-4d", arr[i][j]);
            }
            System.out.println();
        }
    }    
}