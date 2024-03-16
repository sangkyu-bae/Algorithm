import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sound1 = new int[n+1];
        int[] sound2 = new int[n+1];
        for(int i = 1; i <= n ;i++){
            sound1[i] = sc.nextInt();
        }
        for(int i = 1; i <= n ;i++){
            sound2[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][n+1];

        int INF = 1000000000;

        for(int i = 0; i<=n;i++){
            for(int j = 0 ;j<=n;j++){
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;

        for(int i = 1;i<=n;i++){
            for(int j = 1; j<=n ; j++){
                int case1 = dp[i-1][j-1];
                int case2 = dp[i-1][j];
                int case3 = dp[i][j-1];

                dp[i][j] = min(case1,case2,case3) + diff(sound1[i],sound2[j]);
            }
        }

        System.out.println(dp[n][n]);
    }

    static int diff(int a, int b){return (a-b) * (a-b);}
    static int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }



}

