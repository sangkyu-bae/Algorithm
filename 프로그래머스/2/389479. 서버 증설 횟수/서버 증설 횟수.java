import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
 Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for(int i = 0; i < players.length;i++){
            while (!q.isEmpty() && i == q.peek()){
                q.poll();
            }

            int player = players[i];
            if(player/m <= q.size()){
                continue;
            }

            int check = player / m - q.size();
            for(int j = 0; j < check;j++){
                q.add(i + k);
                answer++;
            }
        }

        return answer;
    }
}