import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>((o1,o2)->  o1.end - o2.end);
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0 ;i<n;i++){
           meetings.add(new Meeting(sc.nextInt(),sc.nextInt()));
        }

        meetings.sort((o1,o2)->{
            if(o1.start == o2.start){
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int ans = 1;

        for(Meeting meeting : meetings){

            if(queue.isEmpty()){
                queue.add(meeting);
                continue;
            }

            while (!queue.isEmpty() && queue.peek().end <= meeting.start){
                queue.poll();
            }
            queue.add(meeting);
            ans = Math.max(ans,queue.size());
        }

        System.out.println(ans);
    }

    static class Meeting{
        int start;
        int end;

        public Meeting(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}