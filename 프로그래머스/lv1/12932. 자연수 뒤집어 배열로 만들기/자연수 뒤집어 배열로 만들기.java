import java.util.*;
class Solution {
    public int[] solution(long n) {
         String numStr = String.valueOf(n);
        int[] answer = new int[numStr.length()];
        String reversedString = reverseString(numStr);
        String[] reversedArr = reversedString.split("");
        for (int i = 0 ;i<reversedArr.length;i++){
            answer[i] = Integer.parseInt(reversedArr[i]);
        }

        return answer;
    }
        public static String reverseString(String str) {
        StringBuilder reversedString = new StringBuilder(str);
        return reversedString.reverse().toString();
    }
}