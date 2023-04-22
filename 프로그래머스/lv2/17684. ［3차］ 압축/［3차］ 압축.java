import java.util.*;
class Solution {
    public int[] solution(String msg) {
  Map<String,Integer>dictionary=new HashMap<>();
        int num=1;
        for(char ch = 'A'; ch <= 'Z'; ch++){
            dictionary.put(String.valueOf(ch),num);
            num++;
        }

        List<Integer> result=new ArrayList<>();
        Queue<Character> queue=new LinkedList<>();

        for(int i=0;i<msg.length();i++){
            queue.add(msg.charAt(i));
        }

        int j=1;
        while (!queue.isEmpty()){
            String nowStr=String.valueOf(queue.poll());
            String checkStr=nowStr;
            if(j<msg.length()){
                for(int i=j;i<msg.length();i++){
                    checkStr+=msg.charAt(i);
                    if(!dictionary.containsKey(checkStr)){
                        dictionary.put(checkStr,num++);
                        break;
                    }else{
                        nowStr+=queue.poll();
                        j++;
                    }
                }
            }
            result.add(dictionary.get(nowStr));
            j++;
        }

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}