import java.util.*;
class Solution {
    public long solution(long n) {
       long answer = 0;
        Double sqrt = Math.sqrt(n);
        if(sqrt == sqrt.intValue()){
            answer = (long) Math.pow(sqrt+1,2);
        }else{
            return -1;
        }
        return answer;
    }
}