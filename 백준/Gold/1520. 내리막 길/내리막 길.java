import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[][] map;
    static int N,M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int cnt = 0;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dp = new int[N][M];
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }


        System.out.println(dfs(0,0));

    }

    //n 행, m 열
    //y 행, x 열
    public static int dfs(int n,int m){
        if(n == N - 1 && m == M - 1){
            return 1;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        dp[n][m] = 0;
        for(int i = 0; i < 4; i++){

            int moveX = dx[i] + m;
            int moveY = dy[i] + n;
            int now =map[n][m];

            if(moveY < 0 || moveY >= N|| moveX < 0 || moveX >= M){
                continue;
            }

            if(now <=  map[moveY][moveX]){
                 continue;
            }

            dp[n][m] += dfs(moveY,moveX);
        }

        return dp[n][m];
    }
}
