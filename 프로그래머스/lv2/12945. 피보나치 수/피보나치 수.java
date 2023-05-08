class Solution {
    public int solution(int n) {
      int answer = 0;
        int[] a=new int[n+1];
        a[0]=0;
        a[1]=1;
        a[2]=1;
        for(int i=3;i<=n;i++){
            a[i]=(a[i-2]+a[i-1])%1234567;
        }
        System.out.println(a[a.length-1]);
        answer=a[n];
        return answer;
    }
}