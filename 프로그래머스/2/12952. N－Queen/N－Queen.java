import java.util.*;

class Solution {
    static int[] map;
    static int cnt = 0;
    static int N;
    
    public int solution(int n) {
        int answer = 0;
        
        map = new int[n];
        N = n;
        
        dfs(0);
        
        return cnt;
    }
    
    public static void dfs(int depth){
        if(N == depth){
            cnt++;
            return;
        }
        
        for(int i = 0; i < N ;i++){
            map[depth] = i;

            if(isAttack(depth)){
                dfs(depth + 1);
            }
        }
    }
    
    public static boolean isAttack(int col){
        int colSum = col + map[col];
        int colMin = col - map[col];
        
        for(int i = 0 ; i < col; i++){
            if(map[i] == map[col]){
                return false;
            }
            
            if(i + map[i] == colSum){
                return false;
            }
            
            if(i - map[i] == colMin){
                return false;
            }
        }
        return true;
    }
}