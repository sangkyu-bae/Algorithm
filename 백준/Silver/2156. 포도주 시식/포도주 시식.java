import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] graphs = new int[n+1];
        int[][] dp = new int[3][n+1];

        for(int i = 1; i < graphs.length ;i++){
            graphs[i] = sc.nextInt();
        }


        dp[0][1] = 0;
        dp[1][1] = graphs[1];
        dp[2][1] = graphs[1];

        for(int i = 2; i <= n ;i++){
            dp[0][i] = Math.max(dp[0][i-1],Math.max(dp[1][i-1],dp[2][i-1]));
            dp[1][i] = dp[0][i-1] + graphs[i];
            dp[2][i] = dp[1][i-1] + graphs[i];
        }

        int ans = Math.max(dp[0][n],Math.max(dp[1][n],dp[2][n]));

        System.out.println(ans);
    }

}