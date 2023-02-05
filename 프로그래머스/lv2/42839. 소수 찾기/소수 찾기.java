import java.util.*;
class Solution {
     private boolean[] visit;
    private Set<Integer>hashSet=new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        char[] charArr=numbers.toCharArray();
        visit=new boolean[numbers.length()];
        dfs(numbers,"");

         for(Integer a: hashSet){
            if(prime(a)) answer++;
        }
        return answer;
    }
    private void dfs(String number,String temp){
        for(int i=0;i<number.length();i++){
            if(!visit[i]){
                visit[i]=true;
                temp+=number.charAt(i);
                hashSet.add(Integer.parseInt(temp));
                dfs(number,temp);
                visit[i]=false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }
     static boolean prime(int n) {
        if(n<2) return false;

        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}