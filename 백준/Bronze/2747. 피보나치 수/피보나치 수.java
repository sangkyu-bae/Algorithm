

import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();


        int[] dp = new int[N+1];
        if(N < 2){
            System.out.println(1);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 2 ; i <= N ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }


    public static int dfs(int n){
        if(n == 1 || n == 2){
            return 1;
        }

        return dfs(n-1) + dfs(n-2);
    }

}



