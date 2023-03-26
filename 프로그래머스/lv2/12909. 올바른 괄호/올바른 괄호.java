import java.util.*;
class Solution {
    boolean solution(String s) {
      boolean answer = true;
        Queue <Character>queue=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char nowChar=s.charAt(i);
            if(nowChar=='('){
                queue.add(nowChar);
            }else {
               if(queue.isEmpty()){
                   answer= false;
               }else{
                   queue.poll();
               }
            }
        }
        if(!queue.isEmpty()){
            answer=false;
        }
        return answer;
    }
}