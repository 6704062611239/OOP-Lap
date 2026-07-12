package com.mycompany.table;

import java.util.Scanner;

public class Table {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please input number of columns and rows: ");
        int columns = input.nextInt();
        int rows = input.nextInt();
        int[][] arr = new int[rows][columns];
        
        for(int j = 1; j < columns; j++) {
            arr[0][j] = j + 1; 
        }
        for(int i = 1; i < rows; i++) {
            arr[i][0] = i + 1; 
        }
        
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                arr[i][j] = arr[i][0] * arr[0][j];
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if (i == 0 && j == 0) {
                    System.out.print("    "); 
                } else {
                    System.out.printf("%-4d", arr[i][j]);
                }
            }
            System.out.println();
        }
    }    
}