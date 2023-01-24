import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue=new LinkedList<>();
        for(int a:prices){
            queue.add(a);
        }

        List<Integer> list=new ArrayList<>();
        int check=0;
        int cnt=0;
        while (queue.size()>0){
            int a=queue.poll();
            for(int i=cnt;i< prices.length;i++){
                if(prices[i]<a){
                    list.add(i-cnt);
                    check=i;
                    break;
                }
            }
            if(check==0){
                list.add(prices.length-(cnt+1));
            }else {
                check=0;
            }
            cnt++;
        }

        int[] answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}