import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i = 0; i < n;i++){
            coin[i] = sc.nextInt();
            if(coin[i] <= k){
                dp[coin[i]] = 1;
            }
        }

        for(int i = 1; i <= k;i++){
            dp[i] = 100001;
        }

        for(int i = 0; i < n ; i++){
            for(int j = coin[i] ; j <= k; j++){
                dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }

        if(dp[k] == 100001){
            System.out.println("-1");
            return;
        }

        System.out.println(dp[k]);
    }

}