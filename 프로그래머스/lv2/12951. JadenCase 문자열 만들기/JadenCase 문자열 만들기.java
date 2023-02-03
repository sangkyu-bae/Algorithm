import java.util.*;
class Solution {
    public String solution(String s) {
        String []str=s.split("");
        String answer = "";
        answer+=str[0].toUpperCase();
        for(int i =1;i<str.length;i++){
            if(!str[i-1].equals(" ")){
                answer+=str[i].toLowerCase();
            }else if(str[i-1].equals(" ")){
                answer+=str[i].toUpperCase();
            }
        }
        
        /*
        for(int i=0;i<stringArr.length;i++){
            String a=stringArr[i];
            char ch=a.charAt(0);
            a=a.toLowerCase();
            boolean isNum=Character.isDigit(ch);
            if(!isNum){
                ch=Character.toUpperCase(ch);
                String str=a.substring(0,1);
                String changStr="";
                changStr+=ch;
                a=a.replaceFirst(str,changStr);
            }
            if(i==stringArr.length-1){
                answer+=a;
            }else{
                answer+=a+" ";
            }
        }
        */
       
        return answer;
    }
}