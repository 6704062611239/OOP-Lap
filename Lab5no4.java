package com.mycompany.lab5no4;

import java.util.Scanner;

public class Lab5no4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()) return;
        int M = input.nextInt(); // จำนวนแถว
        int N = input.nextInt(); // จำนวนหลัก

        int K = input.nextInt(); // ขนาดพื้นที่บริการ (K x K)

        // สร้างตาราง Prefix Sum ขนาด (M+1) x (N+1) เพื่อให้คิด Index ง่ายขึ้น
        long[][] pref = new long[M + 1][N + 1];

        // 1. อ่านข้อมูลประชากร และสร้างตาราง 2D Prefix Sum
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int val = input.nextInt();
                pref[i][j] = val + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }

        long maxSum = 0;

        // 2. หาผลรวมสูงสุดของทุกพื้นที่ขนาด K x K ในเวลา O(1) ต่อพื้นที่
        for (int i = K; i <= M; i++) {
            for (int j = K; j <= N; j++) {
                // คำนวณผลรวมกรอบ K x K ที่มีมุมขวา下อยู่ที่ (i, j)
                long currentSum = pref[i][j] - pref[i - K][j] - pref[i][j - K] + pref[i - K][j - K];
                
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        // 3. พิมพ์ผลรวมประชากรที่ดีที่สุด
        System.out.println(maxSum);

        input.close();
    }
}