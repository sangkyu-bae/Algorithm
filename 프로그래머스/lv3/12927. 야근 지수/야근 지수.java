import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
     long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : works){
            queue.add(a);
        }

        for(int i = 0; i<n;i++){
            int workTime = queue.poll()-1;
            queue.add(workTime);
        }

        while (!queue.isEmpty()){
            int num = queue.poll();
            if(num > 0){
                answer += Math.pow(num,2);
            }
        }
    
        return answer;
    }
}