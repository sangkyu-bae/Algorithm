import java.util.*;
class Solution {
    public long solution(int[] weights) {
       long answer = 0;
        int firstComparePerson=0;
        int secondComparePerson=0;
        Set<Double> doubles=new HashSet<>();
        double doubleArr[]= {2,3,4};
        double ratio=0;
        for(int i=0;i< doubleArr.length;i++){
            for(int j=i+1;j<doubleArr.length;j++){
                ratio=doubleArr[i]/doubleArr[j];
                doubles.add(ratio);
                ratio=doubleArr[j]/doubleArr[i];
                doubles.add(ratio);
            }
        }

        for(int i=0; i<weights.length;i++){
            for(int j=i+1;j<weights.length;j++){
                firstComparePerson=weights[i];
                secondComparePerson=weights[j];
                if(firstComparePerson==secondComparePerson){
                    answer++;
                }else if(doubles.contains((double)firstComparePerson/secondComparePerson)){
                    answer++;
                }else if(doubles.contains((double)secondComparePerson/firstComparePerson)){
                    answer++;
                }
            }
        }

        return answer;
    }
}