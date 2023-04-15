import java.util.*;
class Solution {
    public int solution(int[][] targets) {
          int answer = 0;
        Arrays.sort(targets,(o1,o2)->{
            return o1[1]-o2[1];
        });


        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<targets.length;i++){
            int[] tt=new int[2];
            tt[0]=targets[i][0];
            tt[1]=targets[i][1];

            queue.add(tt);
        }

        int start=0;
        int end=0;
        while (!queue.isEmpty()){
            int[] check=queue.poll();
            int checkStart=check[0];
            int checkEnd=check[1];
            if((start==0&&end==0)||(checkStart>=end)){
                System.out.println("start: "+checkStart);
                System.out.println("end :"+checkEnd);
                start=checkStart;
                end=checkEnd;
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}