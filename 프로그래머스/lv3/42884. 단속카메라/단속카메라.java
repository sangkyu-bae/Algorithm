import java.util.*;
class Solution {
    public int solution(int[][] routes) {
         int answer = 1;
        Comparator<int[]> comparator =new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        };
        Arrays.sort(routes,comparator);
     
        int checkPoint = routes[0][1];
        for(int i=0;i<routes.length;i++){
            int inPoint = routes[i][0];
            int outPoint = routes[i][1];
            if(checkPoint >= inPoint){
                checkPoint =Math.min(checkPoint,outPoint);
            }else{
                answer++;
                checkPoint = outPoint;
            }
        }
 

        return answer;
    }
}