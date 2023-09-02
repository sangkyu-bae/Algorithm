import java.util.*;

public class Solution {
    public int solution(int n) {
     int answer = 0;
        String stringInt = String.valueOf(n);
        String[] stringArr = stringInt.split("");
        for(int i = 0;i< stringArr.length;i++){
            answer += Integer.parseInt(stringArr[i]);
        }
        return answer;
    }
}