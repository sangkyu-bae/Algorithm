import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);


        int N =sc.nextInt();
        int[] dp = new int[N + 1];
        boolean[] isVip = new boolean[N + 1];

        int vipCnt = sc.nextInt();


        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2 ; i <=N ; i++) {
            dp[i] = dp[i -1] +dp[i-2];
        }

        int checkCnt = 0;
        int result = 1;
        for(int i = 0 ; i < vipCnt; i++){
            int fixCnt = sc.nextInt();
          result *= dp[fixCnt - checkCnt - 1];
          checkCnt = fixCnt;
        }

        result *= dp[N - checkCnt];


        System.out.println(result);
    }

}



