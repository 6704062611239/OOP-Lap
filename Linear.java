package com.mycompany.linear;
import java.util.Scanner;
public class Linear {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a b c d e f : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        
        Algeba linear = new Algeba(a,b,c,d,e,f);
        
        if(linear.isSovable()){
            System.out.print("x = "+linear.getX()+" y = "+linear.getY());
        }else{
            System.out.print("The equation has no solution");
        }
    }
}

class Algeba{
    private double a,b,c,d,e,f;
    
    public Algeba(double a,double b,double c,double d,double e,double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public double geta(){
        return a;
    }
    public double getb(){
        return b;
    }
    public double getc(){
        return c;
    }
    public double getd(){
        return d;
    }
    public double gete(){
        return e;
    }
    public double getf(){
        return f;
    }
    
    public boolean isSovable(){
        return (a*d - b*c) != 0;
    }
    
    public double getX(){
        return (e*d - b*f)/(a*d - b*c);
    }
    public double getY(){
        return (a*f - e*c)/(a*d - b*c);
    }
        
}