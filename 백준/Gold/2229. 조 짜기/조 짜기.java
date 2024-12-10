

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] map = new int[n + 1];
        int[] dp = new int[n + 1];

        dp[0] = 0;

        int max = 0;
        for(int i = 1; i <= n; i ++){
            map[i] = sc.nextInt();
            for(int j = i -1 ; j >= 1 ; j--){
                max = Math.max(max,Math.abs(map[i]-map[j]) + dp[j-1]);
            }
            dp[i] = max;
        }

        System.out.println(dp[n]);

    }
}



