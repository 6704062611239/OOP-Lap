package lab5no1;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab5no1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        double sum = 0;
        
        while (true) {
            String line = input.nextLine();

            if (line.isEmpty()) {
                break;
            }

            String[] nums = line.split(" ");

            for (String s : nums) {
                double number = Double.parseDouble(s);
                list.add(number);
                sum += number;
            }
        }

        double min = list.get(0);
        double max = list.get(0);
        for(int i=0;i<list.size();i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        
        System.out.println("AVG = " + (sum / list.size()));
        System.out.println("MAX = " + (int)max);
        System.out.println("MIN = " + (int)min);
        for(int i=0;i<list.size();i++){
            if(list.get(i) % 2 != 0){
                System.out.print((int)list.get(i).doubleValue()+" ");
            }
        }
    }
}