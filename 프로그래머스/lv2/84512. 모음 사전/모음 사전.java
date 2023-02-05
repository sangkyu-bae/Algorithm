import java.util.*;
class Solution {
    private String[] strings=new String[]{"A","E","I","O","U"};
    private List<String> list=new ArrayList<>();
    int add = 0;
    int answer=0;
    public int solution(String word) {
         dfs(word,"",0);

        return answer;
    }
    
     public void dfs(String word,String temp,int depth){
           list.add(temp);
        if(word.equals(temp)){
            answer=add;
        }
        if(depth==5){
            return;
        }
        for(int i=0; i< strings.length;i++){
       add++;
            dfs(word,temp+strings[i],depth+1);
        }
    }
}