package com.mycompany.lab5no3;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab5no3 {

    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            if (num1 == num2) {
                result.add(num1);
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        while (input.hasNextInt()) {
            int num = input.nextInt();
            if (num == 0) {
                break;
            }
            list1.add(num);
        }
        while (input.hasNextInt()) {
            int num = input.nextInt();
            if (num == 0) {
                break;
            }
            list2.add(num);
        }
        ArrayList<Integer> result = intersect(list1, list2);
        for (int k = 0; k < result.size(); k++) {
            System.out.print(result.get(k));
            if (k < result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}