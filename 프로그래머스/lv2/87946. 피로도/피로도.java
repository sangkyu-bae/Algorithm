import java.util.*;
class Solution {
//     private int answer = 0;
//     private boolean[] visit;
//     public int solution(int k, int[][] dungeons) {
//         visit = new boolean[dungeons.length];

//         dfs(0, k, dungeons);

//         return answer;
//     }
//     private void dfs(int depth, int k, int[][]dungeons){
//         for(int i = 0; i<dungeons.length; i++){
//             if(!visit[i]&& dungeons[i][0]<=k){
//                 visit[i] = true;
//                 dfs(depth+1, k-dungeons[i][1], dungeons);
//                 visit[i] = false;
//             }
//         }
//         answer = Math.max(answer, depth);
//     }
     boolean[] isVisit;
    int result=0;
    public int solution(int k, int[][] dungeons) {
        isVisit=new boolean[dungeons.length];
        dfs(k,dungeons,0);
        System.out.println(result);
        return result;
    }
    void dfs(int k,int[][] dungeons,int depth){
        for(int i=0;i<dungeons.length;i++){
            if(k>=dungeons[i][0]&&k>=dungeons[i][1]&&!isVisit[i]){
                isVisit[i]=true;
                dfs(k-dungeons[i][1],dungeons,depth+1);
                isVisit[i]=false;
            }
        }
        result=depth>result?depth:result;
    }
}