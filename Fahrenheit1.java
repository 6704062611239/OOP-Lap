package com.mycompany.fahrenheit1;

import javax.swing.JOptionPane;

public class Fahrenheit1 {
    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog("Enter Fahrenheit");
        double fahrenheit = Double.parseDouble(text);
        double celsius = (5.0 / 9.0) * (fahrenheit - 32);
        String resultMessage = String.format("Celsius = %.2f", celsius);
        JOptionPane.showMessageDialog(null, resultMessage, "Result", JOptionPane.PLAIN_MESSAGE);
    }
}