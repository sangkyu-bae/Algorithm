import java.util.*;
class Solution {
    public String solution(int[] numbers) {
      String answer = "";
        List<String>list=new ArrayList<>();
        for(int a: numbers){
            list.add(Integer.toString(a));
        }

        list.sort((o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });
        if(list.get(0).equals("0")) return "0";
    
        for(String a:list){
            answer+=a;
        }
       
        return answer;
    }
}