import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
    Arrays.sort(people);
        int min=0;
        int answer=0;
        for(int i=people.length-1;i>=min;i--){
            if(people[i]+people[min]<=limit){
                min++;
            }
            answer++;
        }

        return answer;
    }
}