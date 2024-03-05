import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] a = new int[n + 1];
        for(int i = 1 ;i<=n;i++){
            a[i] = sc.nextInt();
        }

        dp[1] = a[1];
        int max = dp[1];
        for(int i = 2; i<=n;i++){
            dp[i] = Math.max(dp[i-1], 0) + a[i];
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}