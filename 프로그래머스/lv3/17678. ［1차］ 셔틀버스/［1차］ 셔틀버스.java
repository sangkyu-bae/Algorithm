import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(String time : timetable){
            String[] times = time.split(":");
            int realTime=(Integer.parseInt(times[0])*60) +Integer.parseInt(times[1]);
            queue.add(realTime);
        }

        // 출발시간 9시 60*9
        int startTime = 540;
        int lastTime = 0;
        int total=0;

        for(int i = 0; i<n; i++){
            total = 0;
            while (!queue.isEmpty()){
                int time = queue.peek();
                if(time <= startTime && total < m){
                    queue.poll();
                    total++;
                }else break;
                lastTime = time-1;
            }
            startTime += t;
        }

        if(total < m){
            lastTime = startTime-t;
        }
        String hour = String.format("%02d",lastTime/60);
        String min= String.format("%02d",lastTime%60);
        answer = hour+":"+min;
        System.out.println(answer);

        return answer;
    }
}