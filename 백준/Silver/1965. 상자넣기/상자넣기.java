import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
     
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];  
        int[] boxs = new int[n + 1]; 
        
        for(int i = 1; i <= n; i++) {
            boxs[i] = sc.nextInt();  
        }


        for(int i = 1; i <= n; i++) {
            dp[i] = 1; 
            for(int j = 1; j < i; j++) {
                if(boxs[i] > boxs[j]) {  
                    dp[i] = Math.max(dp[i], dp[j] + 1);  
                }
            }
        }

        // dp 배열에서 가장 큰 값을 찾으면 가장 긴 증가하는 부분 수열의 길이
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);  // 결과 출력
    }
}