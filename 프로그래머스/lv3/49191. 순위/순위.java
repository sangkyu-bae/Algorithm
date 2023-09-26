import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
      int answer = 0;

        boolean [][] wins = new boolean[n+1][n+1];
        boolean [][] loses = new boolean[n+1][n+1];

        for(int[] result:results){
            wins[result[0]][result[1]] = true;
            loses[result[1]][result[0]] = true;
        }

  
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if((wins[i][k] == true) && (wins[k][j] == true)) {
                        wins[i][j] = true;
                        loses[j][i] = true;
                    }
                    if((loses[i][k] == true) && (loses[k][j] == true)) {
                        wins[j][i] = true;
                        loses[i][j] = true;
                    }
                }
            }
        }
 
        for(int i=1;i<=n;i++){
            int tmpNumber = 0;
            for(int j=1;j<=n;j++){
                if((loses[i][j] == true) || (wins[i][j] == true)) tmpNumber++;
            }
            if(tmpNumber == n-1) answer++;
        }
        System.out.println(answer);

        return answer;
    }
}