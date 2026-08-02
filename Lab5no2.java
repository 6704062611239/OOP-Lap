package com.mycompany.lab5no2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab5no2 {

    public static void addStars(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, "*"); 
        }
    }

    public static void removeStars(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("*")) {
                list.remove(i);
                i--; 
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (input.hasNextLine()) {
            String word = input.nextLine().trim();
            if (word.isEmpty()) continue; 

            try {
                int n = Integer.parseInt(word);
                for (int k = 0; k < n; k++) {
                    if (input.hasNextInt()) {
                        int command = input.nextInt();
                        
                        if (command == 1) {
                            addStars(list);
                        } else if (command == 2) {
                            removeStars(list);
                        }
                        System.out.println(list);
                    }
                }
                break;
            } catch (NumberFormatException e) {
                list.add(word);
            }
        }
    }
}