import java.util.*;
class Solution {    
    boolean[] visited;
    String[] userIds;
    String[] bannedIds;
    Set<String> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
       int answer = 0;
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[user_id.length];
        dfs(0,"");

        System.out.println(result.size());
         answer = result.size();
        return answer;
    }
    
     void dfs(int depth,String userId){
        if(depth == bannedIds.length){
            String[] userArr = userId.split(" ");
            Arrays.sort(userArr);
            String user ="";
            for(String id : userArr){
                user += id;
            }
            result.add(user);
            return;
        }

        for(int i=0;i<userIds.length;i++){
            if(checkId(userIds[i],bannedIds[depth]) && !visited[i]){
                visited[i] = true;
                dfs(depth+1,userId+" "+userIds[i]);
                visited[i] = false;
            }
        }
    }
    
     boolean checkId(String userId, String bannedId){
        if(userId.length() != bannedId.length()){
            return false;
        }
        for(int i =0;i<userId.length();i++){
            char bannedChar = bannedId.charAt(i);
            if(bannedChar =='*'){
                continue;
            }
            if(bannedChar != userId.charAt(i)){
                return false;
            }
        }

        return true;
    }
}