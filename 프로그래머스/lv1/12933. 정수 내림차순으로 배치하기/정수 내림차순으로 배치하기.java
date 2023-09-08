import java.util.*;
class Solution {
    public long solution(long n) {
              long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        String b= String.valueOf(n);
        String[] a =b.split("");
        for(int i = 0;i<a.length;i++){
            queue.add(Integer.parseInt(a[i]));
        }
        String bb = "";
        while (!queue.isEmpty()){
            bb += String.valueOf(queue.poll());
        }
        answer = Long.parseLong(bb);
        return answer;
    }
}