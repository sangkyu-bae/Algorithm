import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nx = {1,0};
        int[] ny = {0,1};
        int N  = sc.nextInt();
        long[][] dp = new long[N+1][N+1];
        int[][] map = new int[N+1][N+1];
        
        dp[1][1] = 1;
        for(int i = 1;  i <= N; i++){
            for (int j = 1 ; j <=N ;j++){
                int cnt = sc.nextInt();
                map[i][j] = cnt;

                if(cnt == 0){
                    continue;
                }

                if(i + cnt <= N){
                    dp[i + cnt][j] += dp[i][j];
                }

                if(j + cnt <= N){
                    dp[i][j+cnt] += dp[i][j] ;
                }
            }
        }

        System.out.println(dp[N][N]);
    }

}



