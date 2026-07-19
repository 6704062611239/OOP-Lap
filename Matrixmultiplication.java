package com.mycompany.matrixmultiplication;

import java.util.Scanner;

public class Matrixmultiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int LTemp = input.nextInt();

        double[][] matrixA = new double[N][LTemp];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < LTemp; j++) {
                matrixA[i][j] = input.nextDouble();
            }
        }

        int L = input.nextInt();
        int M = input.nextInt();

        double[][] matrixB = new double[L][M];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = input.nextDouble();
            }
        }

        Matrix mm = new Matrix(matrixA, matrixB);
        double[][] resultC = mm.multiply();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print((int)resultC[i][j]);
                if (j < M - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        input.close();
    }
}

class Matrix {
    private double[][] A;
    private double[][] B;
    private int N, L, M;

    public Matrix(double[][] matrixA, double[][] matrixB) {
        this.A = matrixA;
        this.B = matrixB;
        this.N = matrixA.length;       
        this.L = matrixA[0].length;    
        this.M = matrixB[0].length;    
    }

    public double[][] multiply() {
        double[][] C = new double[N][M];

        for (int i = 0; i < N; i++) {         
            for (int k = 0; k < M; k++) {      
                double sum = 0;
                for (int j = 0; j < L; j++) { 
                    sum += A[i][j] * B[j][k];
                }
                C[i][k] = sum;
            }
        }
        return C;
    }
}