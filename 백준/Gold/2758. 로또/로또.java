import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t=0 ; t < tc ;t++){

            int n= sc.nextInt(), m = sc.nextInt();
           long[][] dp = new long[n + 1][m + 1];

            Arrays.fill(dp[0],1);

            for(int i = 1; i <= n;i++){
                for(int j = 1; j <= m;j++){
                    dp[i][j] = dp[i-1][j/2] + dp[i][j-1];
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}

