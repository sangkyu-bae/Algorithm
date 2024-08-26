
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] a;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int q = sc.nextInt();
        dp = new int[n + 1];
        a = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            a[i] = new ArrayList<>();
        }
        for(int i = 0 ; i <n - 1;i++){
            int j = sc.nextInt();
            int k = sc.nextInt();


            a[j].add(k);
            a[k].add(j);
        }

        dfs(r,-1);

        for(int i = 0; i < q ; i++) {
            System.out.println(dp[sc.nextInt()]);
        }

    }

    static void dfs(int start, int prev){
        dp[start] = 1;
        List<Integer> graphList = a[start];

        for(Integer i : graphList){
            if(i==prev){
                continue;
            }
            dfs(i,start);
            dp[start] += dp[i];
        }

    }

}
