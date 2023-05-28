class Solution {
    public int[] solution(int n, long left, long right) {
       int len = (int) right - (int) left;
        int[] answer=new int[len+1];

        int j=0;
        for(long i = left;i <= right;i++){
            int max=Math.max((int)(i/n),(int)(i%n))+1;
            answer[j]=max;
            j++;
        }
        
        return answer;
    }
}