import java.util.*;
class Solution {
    int [][] map;
    public int[] solution(String[] maps) {
      List<Integer> answer=new ArrayList<>();
        map=new int [maps.length][maps[0].length()];

        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                char dayChar=maps[i].charAt(j);
                int day=-1;
                if(dayChar!='X'){
                    day=Integer.parseInt(String.valueOf(dayChar));
                }
                map[i][j]=day;
            }
        }
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                int day= dfs(i,j);
                if(day>0){
                    answer.add(day);
                }
            }
        }
        if(answer.isEmpty()){
            answer.add(-1);
        }
        
        int[] answerArr=new int[answer.size()];
        for(int i=0;i<answerArr.length;i++){
            answerArr[i]=answer.get(i);
        }
        Arrays.sort(answerArr);
        return answerArr;
    }
    
      private int dfs(int i,int j){
        if(i<0||j<0||i>=map.length||j>=map[i].length){
            return 0;
        }

        if(map[i][j]==-1){
            return 0;
        }

        int answer=map[i][j];
        map[i][j]=-1;

        return answer+dfs(i+1,j)+dfs(i-1,j)+dfs(i,j+1)+dfs(i,j-1);
    }
    
}