import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
      Queue<Integer> a=new LinkedList<>();
        List<Integer>ch=new ArrayList<>();

        for(int i =0;i<progresses.length;i++){
            int end=100-progresses[i];
            int endDay=end/speeds[i];
            if(end%speeds[i]>0){
                endDay++;
            }
            a.add(endDay);
        }

        Integer d=a.peek();
        int cnt=0;
        for(int i=0;i<progresses.length;i++){
            if(!a.isEmpty()){
                if(a.peek()<=d){
                    a.remove();
                    cnt++;
                }else{
                    d=a.peek();
                    ch.add(cnt);
                    cnt=0;
                    cnt++;
                    a.remove();
                }
            }
            if(a.isEmpty()){
                //System.out.println(cnt);
                ch.add(cnt);
                break;
            }
            //System.out.println(cnt);
        }
        
        for (int ds:ch){
            System.out.println(ds);
        }
        
        int[] answer = {};
        answer=ch.stream().mapToInt(i->i).toArray();
        return answer;
    }
}