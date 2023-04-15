import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
            int answer = 0;
        List<Integer> leftList=new ArrayList<>();
        List<Integer> rightList=new ArrayList<>();
        for(int[]a:sizes){
            if(a[0]>a[1]){
                leftList.add(a[0]);
                rightList.add(a[1]);
            }else{
                leftList.add(a[1]);
                rightList.add(a[0]);
            }
        }
        leftList.sort((o1, o2) -> o2-o1);
        rightList.sort((o1, o2) -> o2-o1);
        answer=leftList.get(0)*rightList.get(0);

        System.out.println(answer);
        return answer;
    }
}