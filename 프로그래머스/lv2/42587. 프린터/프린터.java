import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
    int answer=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        for(int a:priorities){
            queue.add(a);
        }

        while (!queue.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==queue.peek()){
                    answer++;
                    if(location==i){
                        return answer;
                    }
                    queue.poll();
                }
            }
        }
        return -1;
    }
}