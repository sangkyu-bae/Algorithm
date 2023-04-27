class Solution {
    public int solution(int n) {
 int answer = 0;

        int first=1;
        int second=1;
        for(int i=1;i<n;i++){
            answer=(first+second)%1000000007;
            first=second;
            second=answer;
        }

        System.out.println(answer);
        return answer;
    }
}