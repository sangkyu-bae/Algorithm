import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] dp = new int[h+2][w+2];
        int[][][] image = new int[2][h+2][w+2];

        for(int img =0 ; img < 2;img++){
            for(int i = 1; i <= h ;i++){
                for(int j = 1; j<=w;j++){
                    image[img][i][j] = sc.nextInt();
                }
            }
        }
        int MAX_VALUE = 100_000_000_0;
        for(int i = 1 ; i<=h ; i++){
            Arrays.fill(dp[i], MAX_VALUE);
        }

        int answer = MAX_VALUE;

        for(int r = 1; r <= h; r++){
            for(int c = 1; c <= w ; c++){
                int c1 = dp[r - 1][c-1];
                int c2 = dp[r - 1][c];
                int c3 = dp[r - 1][c+1];
                int diff = image[0][r][c] -image[1][r][c];


                dp[r][c] = Math.min(c1,Math.min(c2,c3)) + (diff *diff);
            }
        }

        for(int i = 1 ; i <= w ; i++){
            answer = Math.min(answer,dp[h][i]);
        }

        System.out.println(answer);
    }
}