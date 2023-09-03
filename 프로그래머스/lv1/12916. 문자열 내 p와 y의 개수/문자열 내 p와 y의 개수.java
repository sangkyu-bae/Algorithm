import java.util.*;
class Solution {
    boolean solution(String s) {
        int pSum = 0;
        int ySum = 0;
        s=s.toLowerCase();
        String[] numArr = s.split("");
        for(int i = 0 ; i < numArr.length; i++){
            if(numArr[i].equals("p"))pSum++;
            else if(numArr[i].equals("y"))ySum++;
        }
        if(pSum == ySum) return true;
        
        return false;
    }
}