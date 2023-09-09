class Solution {
    public long solution(int[] sequence) {
         long answer = 0;
        int size =sequence.length;
        int[] perseArr = new int[size];
        int[] minPerseArr = new int[size];

        int n = 1;
        for(int i = 0 ; i< size;i++){
            perseArr[i] = sequence[i]*n;
            n*=-1;
            minPerseArr[i] = sequence[i]*n;
        }

        long[] dpFirst = new long[size];
        long[] dpSecond = new long[size];

        dpFirst[0] = perseArr[0];
        dpSecond[0] = minPerseArr[0];
        answer = Math.max(dpFirst[0],dpSecond[0]);

        for(int i = 1 ; i< size;i++){
            dpFirst[i] = Math.max(dpFirst[i-1]+perseArr[i],perseArr[i]);
            dpSecond[i] = Math.max(dpSecond[i-1]+minPerseArr[i],minPerseArr[i]);

            long max = Math.max(dpFirst[i],dpSecond[i]);
            answer = Math.max(answer,max);
        }


        return answer;
    }
}