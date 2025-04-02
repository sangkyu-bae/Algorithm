import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
    int answer = n;
        int[][] dp = new int[info.length + 1][m];

        for(int i = 1 ; i <= info.length;i++){
            Arrays.fill(dp[i],n);
        }

        for(int i = 1; i <= info.length; i++){
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for(int j = 0; j < m; j++){

                dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + a);

                if(j + b < m){
                    dp[i][j + b] = Math.min(dp[i - 1][j],dp[i][j+b]);
                }
            }
        }
        

        for (int i = 0; i < m ;i++){
            answer = Math.min(dp[info.length][i],answer);
        }


        return answer >= n ? -1 :answer;
    }
}