import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int mod = 9901;
        int none = 0;
        int left = 1;
        int right = 2;
        int n = sc.nextInt();
        int[][] dp = new int[3][n + 1];

        dp[left][1] = 1;
        dp[none][1] = 1;
        dp[right][1]= 1;

        for(int i =2 ;i<=n;i++){
            dp[left][i] = (dp[right][i-1]+dp[none][i-1]) % mod;
            dp[right][i] = (dp[left][i-1]+dp[none][i-1]) % mod;
            dp[none][i] = (dp[left][i-1]+dp[none][i-1]+dp[right][i-1]) %mod;
        }

        System.out.println((dp[left][n]+dp[right][n]+dp[none][n])%mod);
    }
}