import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] temp =new int[n+1];

        int num = 0;

        for(int i = 1; i<=n;i++){
            for(int j = 1;j <= i;j++){
                num = sc.nextInt();
                temp[j] = num + Math.max(dp[j],dp[j-1]);
            }

            for(int j = 1; j <= i; j++){
                dp[j] = temp[j];
            }
        }
        int answer = 0;
        for(int i : dp){
            answer = Math.max(i,answer);
        }

        System.out.println(answer);

    }
}