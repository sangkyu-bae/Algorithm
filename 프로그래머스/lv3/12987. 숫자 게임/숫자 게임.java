import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
                int answer = 0;
        PriorityQueue<Integer> aQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<A.length;i++){
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }

        while (!bQueue.isEmpty()){
            int bNum = bQueue.poll();
            while (!aQueue.isEmpty()){
                int aNum = aQueue.poll();
                if(bNum > aNum){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}