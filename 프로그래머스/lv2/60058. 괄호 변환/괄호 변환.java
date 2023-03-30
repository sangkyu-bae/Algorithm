import java.util.*;

class Solution {
    public String solution(String p) {
            String answer = "";
        String a=dfs(p);
        System.out.println(a);
        return a;
    }
    
     boolean isCheck(String checkStr){
        Stack<Character>characters=new Stack<>();
        for(int i=0;i<checkStr.length();i++){
            char nowChar=checkStr.charAt(i);
            if(characters.isEmpty()){
                characters.push(nowChar);
            }else{
                char checkChar=characters.peek();
                if(nowChar==')'&&checkChar=='('){
                    characters.pop();
                }else{
                    characters.push(nowChar);
                }
            }
        }
        return characters.isEmpty();
    }
    
        String dfs(String w){
        String result="";
        if(w.equals("")){
            return result;
        }
        int cntL=0,cntR=0;
        int checkIndex=0;

        for(int i=0;i<w.length();i++){
            if(w.charAt(i)=='('){
                cntL++;
            }else{
                cntR++;
            }
            if((cntL!=0&&cntR!=0)&&(cntL==cntR)){
                checkIndex=i;
                break;
            }
        }

        String u=w.substring(0,checkIndex+1);
        String v=w.substring(checkIndex+1,w.length());

        if(isCheck(u)){
            result=u+dfs(v);
        }else{
            result="("+dfs(v)+")";
            u=u.substring(1,u.length()-1);
            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='('){
                    result+=")";
                }else{
                    result+="(";
                }
            }
        }
        return result;
    }
}