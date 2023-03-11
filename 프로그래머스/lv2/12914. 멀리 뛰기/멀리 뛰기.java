class Solution {
    public long solution(int n) {
        long answer = 0;
        int a[]=new int[2001];
        a[1]=1;
        a[2]=2;
        for(int i=3;i<=n;i++){
            a[i]=(a[i-1]+a[i-2])%1234567;
        }
        answer=a[n];
        return answer;
    }
  
}