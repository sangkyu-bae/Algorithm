import java.util.*;
class Solution {
    static Set<Integer>[] set;
    static int answer;
    static int[] request;
    static boolean[] isVisit;
    static int limit;
    static int length;
    public static int solution(int n, int[][] q, int[] ans) {
        limit = n;
        set = new Set[q.length];
        isVisit = new boolean[n + 1];
        length = q.length;
        request = new int[5];

        for(int i = 0 ; i < length; i++ ){
            set[i] = new HashSet<>();
            for(int j = 0 ; j < 5; j++){
                set[i].add(q[i][j]);
            }
        }

        dfs(0,1,ans);
        System.out.println(answer);
        return answer;
    }


    public static void dfs(int count, int cur,int[] ans){
        if(count == 5){
            if(isCompare(ans)){
                answer++;
            }
            return;
        }


        for(int i = cur ; i <= limit ; i++){
            if(isVisit[i]){
                continue;
            }
            request[count] = i;
            isVisit[i] = true;
            dfs(count+1,i+1,ans);
            isVisit[i] = false;
        }
    }

    public static boolean isCompare(int[] ans){

        for(int i = 0 ;i < length; i++){
            int sum = 0;
            Set<Integer> nums = set[i];
            for(int num :request){
                if(nums.contains(num)){
                    sum++;
                }
            }
            if(ans[i] != sum){
                return false;
            }
        }

        return true;
    }

}