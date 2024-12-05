

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] map = new int[n];
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp,1);

        for(int i =0 ; i < n ;i++){
            map[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < i; j ++){
                if(map[i] > map[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            max = Math.max(max,dp[i]);
        }

        System.out.println(n - max);

    }
}



