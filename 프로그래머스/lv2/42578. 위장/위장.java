import java.util.*;
class Solution {
     public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer>map=new HashMap<>();

        for(String[] arr:clothes){
            String key=arr[1];
            map.put(key,map.getOrDefault(key,0)+1);
        }

        Iterator<Integer> it=map.values().iterator();
        while (it.hasNext()){
            answer*=it.next().intValue()+1;
        }

        return answer-1;
    }
}