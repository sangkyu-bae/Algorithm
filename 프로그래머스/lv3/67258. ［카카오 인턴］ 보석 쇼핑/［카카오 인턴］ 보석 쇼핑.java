import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
          int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>();
        for(String gem : gems){
            gemSet.add(gem);
        }
        Map<String, Integer> map = new HashMap<>();

        int start = 0;
        int end =0;

        int left = 0;
        int right = 0;

        int maxValue = Integer.MAX_VALUE;

        int length = gems.length;

        while (true){

            if(map.size() == gemSet.size()){
                map.put(gems[left],map.get(gems[left])-1);

                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }

                left++;
            }else if(length == right){
                break;
            }else {
                map.put(gems[right],map.getOrDefault(gems[right],0)+1);
                right++;
            }

            if(map.size() == gemSet.size()){
                if(right - left < maxValue){
                    maxValue = right - left;
                    start = left+1;
                    end = right;
                }
            }
        }
        
        answer[0] = start;
        answer[1] = end;

        return answer;
    }
}