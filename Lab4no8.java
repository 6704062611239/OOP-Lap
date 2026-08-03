package lab4no8;
import java.util.Scanner;

public class Lab4no8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int W = input.nextInt();
        int[][] a = new int[H][W];
        
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                a[i][j] = input.nextInt();
            }
        }
        
        int maxsum = -1;
        int col = 0;
        int row = 0;
        
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                
                if (j + 1 < W) {
                    int diff = Math.abs(a[i][j] - a[i][j+1]);
                    if (diff <= 10) {
                        int sum = a[i][j] + a[i][j+1];
                        if (sum > maxsum) {
                            maxsum = sum;
                            row = i;
                            col = j;
                        }
                    }
                }
                if (i + 1 < H) {
                    int diff = Math.abs(a[i][j] - a[i+1][j]);
                    if (diff <= 10) {
                        int sum = a[i][j] + a[i+1][j];
                        if (sum > maxsum) {
                            maxsum = sum;
                            row = i;
                            col = j;
                        }
                    }
                }
            }
        }
        System.out.println((row+1) + " " + (col+1));
    }
    
}
