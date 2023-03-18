import java.util.*;
class Solution {
        static int[][]map;
    public int solution(int n, int[][] wires) {
      int answer = n;
        map=new int[n][n];
        for(int i=0;i<wires.length;i++){
            int x=wires[i][0];
            int y=wires[i][1];
            map[x-1][y-1]=1;
            map[y-1][x-1]=1;
        }

        for(int i=0;i<wires.length;i++){
            int x=wires[i][0];
            int y=wires[i][1];

            map[x-1][y-1]=0;
            map[y-1][x-1]=0;
            answer=Math.min(answer,bfs(n,x-1));

            map[x-1][y-1]=1;
            map[y-1][x-1]=1;
        }

        return answer;
    }
     public int bfs(int n,int start){
       boolean[] isVisit=new boolean[n];
        Queue<Integer> queue=new LinkedList();
        queue.add(start);
        int cnt=1;
        while (!queue.isEmpty()){
            int visit=queue.poll();
            isVisit[visit]=true;
            for(int i=0;i<n;i++){
                if(!isVisit[i]){
                    if(map[visit][i]==1){
                        queue.add(i);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(Math.abs(n-2*cnt));
        return Math.abs(n-2*cnt);
    }
}