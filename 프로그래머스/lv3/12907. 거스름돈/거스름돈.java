class Solution {
    public int solution(int n, int[] money) {
           int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i : money){
            for(int j = i; j<n+1 ;j++){
                dp[j] += dp[j-i];
            }
        }

        return dp[n]%1000000007;
    }
}