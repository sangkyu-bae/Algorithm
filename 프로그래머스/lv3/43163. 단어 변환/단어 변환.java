class Solution {
        boolean[] isVisit;
    int answer = 10000000;
    public int solution(String begin, String target, String[] words) {
           isVisit = new boolean[words.length];
        dfs(0,0,begin,target,words);
        System.out.println(answer);
      return answer == 10000000? 0 : answer;
    }
       void dfs(int depth, int count, String begin, String target,String[] words){

        if(depth == words.length){
            return;
        }
        if(target.equals(begin)){
            answer = Math.min(answer,count);
            return;
        }

        for(int i = 0;i<words.length;i++){

            if(isVisit[i] || !stringChecker(begin,words[i])){
                continue;
            }

            isVisit[i]= true;
            dfs(depth+1,count+1,words[i],target,words);
            isVisit[i] = false;
        }
    }

        boolean stringChecker(String begin, String target){
        int checkCount = 0;
        for(int i = 0;i<begin.length();i++){
            if (begin.charAt(i) != target.charAt(i)) {
                checkCount++;
                if(checkCount > 1){
                    return false;
                }
            }
        }
        return true;
    }
}