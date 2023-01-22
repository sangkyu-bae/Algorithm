import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        /*
        int checkNum=0;
        int nextNum=0;
        
        String op=Integer.toBinaryString(n);
        String opArr[]=op.split("");
        
        for(String a:opArr){
            if(a.equals("1"))checkNum++;
        }
        
        for(int i=n+1;;i++){
            if(checkNum==nextNum) break;
            nextNum=0;
            String ops=Integer.toBinaryString(i);
            String opArrs[]=ops.split("");
            for(String a:opArrs){
                if(a.equals("1")){
                    nextNum++;
                }
            }
            answer=i;
        }
        */
        int bit =Integer.bitCount(n);
        while(true){
            if(bit==Integer.bitCount(++n)) break;
        }
        return n;
    }
}