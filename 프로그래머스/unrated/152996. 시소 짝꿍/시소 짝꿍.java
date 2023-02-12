import java.util.*;
class Solution {
    public long solution(int[] weights) {
      long answer = 0;

        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> keys=new HashSet<>();

        for(int i=0;i<weights.length;i++){
            map.put(weights[i], map.getOrDefault(weights[i],0)+1);
            keys.add(weights[i]);
        }

        for(int key:keys){
            int firstMark=key*2;
            int init=map.get(key);
            if(firstMark%3==0){
                if(map.containsKey(firstMark/3)){
                    System.out.println("1");
                    System.out.println((long)map.get(firstMark/3).intValue()*init);
                    answer+=(long)map.get(firstMark/3).intValue()*init;
                }
            }

            if(firstMark%4==0){
                if(map.containsKey(firstMark/4)){
                    answer+=(long)map.get(firstMark/2)*init;
                }
            }

            int secondMark=key*3;
            if(secondMark%2==0){
                if(map.containsKey(secondMark/2)){
                    answer+=(long)map.get(secondMark/2)*init;
                }
            }

            if(secondMark%4==0){
                if(map.containsKey(secondMark/4)){
                    answer+=(long) map.get(secondMark/4)*init;
                }
            }

            int thirdMark=key*4;
            if(thirdMark%2==0){
                if(map.containsKey(thirdMark/2)){
                    answer+=(long) map.get(thirdMark/2)*init;
                }
            }

            if(thirdMark%3==0){
                if (map.containsKey(thirdMark/3)){
                    answer+=(long) map.get(thirdMark/3)*init;
                }
            }
            if(init>1){
                answer+=(long)init*(long)(init-1)/2;
            }

            map.remove(key);
        }

        return answer;
    }
}