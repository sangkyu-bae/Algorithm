import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
  long left = 1;
        long right = limit;
        while (left <= right){
            long mid = (left + right) / 2;
            long timePrev = 0;
            for(int i = 0 ;i < diffs.length ;i++){
                if (mid < diffs[i]){
                    timePrev += (times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];
                }else{
                    timePrev += times[i];
                }
            }

            if(timePrev > limit){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return (int)left;
    }
}