import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];
        try{
            for(String x : X.split("")){
                xCnt[Integer.parseInt(x)]++;
            }
            for(String y : Y.split("")){
                yCnt[Integer.parseInt(y)]++;
            }

            for(int i=9 ; i >= 0 ;i--){
                while (xCnt[i]>0 && yCnt[i]>0){
                    answer.append(i);

                    xCnt[i]--;
                    yCnt[i]--;
                }
            }
            if("".equals(answer.toString()))
                return "-1";
            if("0".equals(answer.toString().substring(0,1)))
                return "0";
         
        }catch (Exception e){
            e.toString();
            System.out.println(answer.toString());
        }

        return answer.toString();
    }
}