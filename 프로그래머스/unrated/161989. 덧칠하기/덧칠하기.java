import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
    int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : section) {
            queue.add(a);
        }

        while (!queue.isEmpty()) {
            answer++;
            int a = queue.poll();
            for (int i = a; i < a + m; i++) {
                if(queue.isEmpty()){
                    break;
                }
                if(queue.peek()==i){
                    queue.poll();
                }
            }

        }

        return answer;
    }
}