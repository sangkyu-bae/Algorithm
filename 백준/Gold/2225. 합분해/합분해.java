
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
     
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) dp[i][0] = 1;
        Arrays.fill(dp[1],1);



        for(int i = 1 ; i <= M ; i++){
            for (int j = 1; j <= N; j++){
               dp[i][j] = (dp[i -1][j] + dp[i][j - 1])%1000000000;
            }
        }

        System.out.println(dp[M][N]);
    }

}



