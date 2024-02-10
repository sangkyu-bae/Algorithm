import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[k+1][t+1];
        dp[0][0] = 1;

        for(int i = 1; i <= k; i++){
            int coinPrice =sc.nextInt();
            int coinCount = sc.nextInt();

            for(int value = 0 ; value <= t ;value++){
                for(int cnt = 0; cnt<=coinCount;cnt++ ){
                    int nextVal = value+ coinPrice *cnt;
                    if(nextVal > t){
                        break;
                    }
                    dp[i][nextVal] += dp[i-1][value];
                }
            }
        }

        System.out.println(dp[k][t]);
    }
}