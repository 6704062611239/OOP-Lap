package com.mycompany.noru;

import java.util.Scanner;

public class Noru {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. รับข้อมูลพายุ: บรรทัดแรก (xc, yc, r, v)
        double xc = input.nextDouble();
        double yc = input.nextDouble();
        double r = input.nextDouble();
        double v = input.nextDouble();

        // 2. รับจำนวนบ้าน n หลัง
        int n = input.nextInt();

        // สร้าง Array เก็บพิกัดบ้าน
        double[][] houseXy = new double[n][2];
        // สร้าง Array ชนิด boolean เพื่อมาร์คว่าบ้านหลังไหนโดนพายุไปแล้วบ้าง (เริ่มต้นเป็น false ทั้งหมด)
        boolean[] isAffected = new boolean[n];

        // รับพิกัดบ้านแต่ละหลังเก็บลงอาเรย์
        for (int i = 0; i < n; i++) {
            houseXy[i][0] = input.nextDouble(); // พิกัด x
            houseXy[i][1] = input.nextDouble(); // พิกัด y
        }

        int totalAffectedHouses = 0;

        // 3. เริ่มต้นจำลองการเคลื่อนที่ ณ ชั่วโมงที่ 0 (ก่อนเริ่มเคลื่อนที่ เช็กผลกระทบรอบแรกก่อน)
        totalAffectedHouses += checkImpact(xc, yc, r, houseXy, isAffected);

        // 4. วนลูปจำลองเหตุการณ์ไปทีละชั่วโมง จนกว่าความเร็วพายุจะน้อยกว่า 1.0
        while (v >= 1.0) {
            // ใน 1 ชั่วโมง พายุเคลื่อนที่ไปทางทิศตะวันตก (xc ลดลง) เป็นระยะทาง = ความเร็ว * เวลา (1 ชั่วโมง)
            double distanceMoved = v * 1.0;
            xc = xc - distanceMoved;

            // พายุอ่อนกำลังลงในทุกๆ 1 ชั่วโมง รัศมีและความเร็วลดลง 0.2 เท่า (เหลือ 0.8 เท่า)
            r = r * 0.8;
            v = v * 0.8;

            // เช็กผลกระทบของบ้าน ณ สิ้นชั่วโมงนี้ และบวกสะสมจำนวนบ้านที่ได้รับผลกระทบเพิ่ม
            totalAffectedHouses += checkImpact(xc, yc, r, houseXy, isAffected);
        }

        // 5. แสดงผลรวมจำนวนบ้านทั้งหมดที่ได้รับผลกระทบ
        System.out.println(totalAffectedHouses);
    }

    // ฟังก์ชันสำหรับเช็กว่า ณ ชั่วโมงนั้นๆ มีบ้านหลังไหนอยู่ในรัศมีพายุบ้าง
    public static int checkImpact(double xc, double yc, double r, double[][] houseXy, boolean[] isAffected) {
        int countInThisHour = 0;
        
        for (int i = 0; i < houseXy.length; i++) {
            // ถ้าบ้านหลังนี้ยังไม่เคยโดนพายุในชั่วโมงก่อนหน้า ค่อยเอามาคิด
            if (!isAffected[i]) {
                double hX = houseXy[i][0];
                double hY = houseXy[i][1];

                // คำนวณระยะห่างจากศูนย์กลางพายุถึงตัวบ้าน
                double distance = Math.sqrt(Math.pow(hX - xc, 2) + Math.pow(hY - yc, 2));

                // ถ้าระยะห่างน้อยกว่าหรือเท่ากับรัศมีพายุ แปลว่าโดนพายุถล่ม
                if (distance <= r) {
                    isAffected[i] = true; // มาร์คไว้ว่าโดนแล้ว ห้ามคิดซ้ำ
                    countInThisHour++;
                }
            }
        }
        return countInThisHour;
    }
}