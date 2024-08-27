

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] a;
    static int[][] dp;
    static int n;
    static int[] cost;
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n + 1];
        dp = new int[n + 1][2];
        a= new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            a[i] = new ArrayList<>();
        }

        for(int i = 1; i <=n ;i++){
            cost[i] = sc.nextInt();
        }

        for(int i = 1; i<n ; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            a[s].add(e);
            a[e].add(s);
        }

        dfs(4,0);

        System.out.println(Math.max(dp[4][0],dp[4][1]));

    }

    static void dfs(int start,int perv){
        for(int i : a[start]){
            if(i == perv){
                continue;
            }

            dfs(i,start);
            dp[start][1] += dp[i][0];
            dp[start][0] += Math.max(dp[i][1],dp[i][0]);
        }

        dp[start][1] += cost[start];
    }
    //밟은경우 1번째 안밟은 경우 0

}
