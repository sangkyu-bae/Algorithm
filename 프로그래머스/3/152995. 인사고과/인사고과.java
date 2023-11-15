import java.util.*;
class Solution {
    public int solution(int[][] scores) {
     int answer = 0;
        int[] wanHo = scores[0];
        int wanHoSum = wanHo[0]+wanHo[1];

        int max = 0;
        Arrays.sort(scores,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }

            return o2[0]-o1[0];
        });


        for(int[] score:scores){
            if(max > score[1]){
                if(score.equals(wanHo) ){
                    return -1;
                }
            }else{
                max = Math.max(max,score[1]);
                if(wanHoSum < score[0]+score[1]){
                    answer++;
                }
            }
        }

        System.out.println(answer);
        return answer+1;
    }
}