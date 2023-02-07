import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
   long sum=0;
        long sum1=0;
        long sum2=0;

        Queue<Integer> firstQueue= new ArrayDeque<>();
        Queue<Integer> secondQueue=new ArrayDeque<>();
        for(int i=0;i<queue1.length;i++){
            firstQueue.add(queue1[i]);
            secondQueue.add(queue2[i]);
            sum1+=queue1[i];
            sum2+=queue2[i];
        }
        sum=sum1+sum2;
        if(sum%2==1) return -1;
        int p1=0,p2=0;
        int limit=queue1.length*2;
        sum=sum/2;
        while (p1<=limit&&p2<=limit){
            if(sum1==sum){
                return p1+p2;
            }

            if(sum1>sum){
                int a=firstQueue.poll();
                sum1-=a;
                sum2+=a;
                secondQueue.add(a);
                p1++;
            }else {
                int a=secondQueue.poll();
                sum1+=a;
                sum2-=a;
                firstQueue.add(a);
                p2++;
            }
        }


        return -1;
    }
}