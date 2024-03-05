import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int[] a = new int[n + 1];
        for(int i = 1 ;i<=n;i++){
            a[i] = sc.nextInt();
        }

        dp1[1] = a[1];
        dp2[1] = a[1];
        int max = dp1[1];
        for(int i = 2; i<=n;i++){
            dp1[i] = Math.max(dp1[i-1], 0) + a[i];
            dp2[i] = Math.max(dp1[i-1],dp2[i-1] + a[i]);
            max = Math.max(max,Math.max(dp1[i],dp2[i]));
        }

        System.out.println(max);
    }
}