import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
         String answer = "";
        Queue<String> card1Queue=new LinkedList<>();
        Queue<String> card2Queue=new LinkedList<>();

        for(String card:cards1){
            card1Queue.add(card);
        }
        for(String card:cards2){
            card2Queue.add(card);
        }
        Queue<String> goalQueue=new LinkedList<>();
        for (String goalStr:goal){
            goalQueue.add(goalStr);
        }

        while (!goalQueue.isEmpty()){
            String goalStr=goalQueue.poll();

            String card1Str=card1Queue.peek();
            String card2Str=card2Queue.peek();

          
            if(goalStr.equals(card1Str)){
                card1Queue.poll();
            }else if(goalStr.equals(card2Str)){
                card2Queue.poll();
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}