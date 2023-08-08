import java.util.*;
class Solution {
     ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    boolean[] isVisit;
    public int solution(int n, int[][] edge) {
             for(int i = 0;i<n+1;i++){
            map.add(new ArrayList<>());
        }
        isVisit = new boolean[n+1];

        for(int[] i:edge){
            int v = i[0];
            int w = i[1];
            map.get(v).add(w);
            map.get(w).add(v);
        }

        return bfs(n);
    }
    
        int bfs(int n){
        Queue<int[]> queue= new LinkedList<>();
        int answer = 0;
        queue.add(new int[]{1,0});
        int maxDepth = 0;
        isVisit[1] = true;

        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int v = arr[0];
            int depth = arr[1];

            if(maxDepth == depth) answer++;
            else if (maxDepth < depth){
                maxDepth = depth;
                answer = 1;
            }

            for(int i = 0; i<map.get(v).size();i++){
                int w = map.get(v).get(i);
                if(!isVisit[w]){
                    queue.add(new int[]{w,depth+1});
                    isVisit[w] = true;
                }
            }
        }

        return answer;
    }
}