import java.util.*;
class Solution {
    static int[][]map;
    boolean[] isVisit;
    public int solution(int n, int[][] computers) {
       int answer = 0;
        isVisit =new boolean[n];
        map=computers;

        for(int i=0;i<n;i++){
            if(!isVisit[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    void bfs(int cnt){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cnt);

        while (!queue.isEmpty()){
            int visit = queue.poll();
            isVisit[visit] =true;
            for(int i=0;i<isVisit.length;i++){
                if(!isVisit[i]){
                    if(map[visit][i]==1){
                        queue.add(i);
                    }
                }
            }
        }
    }
}