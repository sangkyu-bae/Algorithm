import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] sArr=s.split("");
        String str="";
        String result="";
        
        int zero=0;
        int count=0;
        
        String octal="";
        int num=0;
        boolean init=true;
    
        for(int i=0;;i++){
            if(result.equals("1")){
                break;
            }
            if(init){
                for(String st:sArr){
                    if(st.equals("0")){
                        zero++;
                    }else{
                        str+=st;   
                    }
                }
                
                num=str.length();
                octal=Integer.toBinaryString(num);
                result=octal;
                str="";
                count++;
                init=false;
            }else{
                sArr=octal.split("");
                for(String st:sArr){
                    if(st.equals("0")){
                        zero++;
                    }else{
                        str+=st;   
                    }
                }
                num=str.length();
                octal=Integer.toBinaryString(num); 
                result=str;
                str="";
                count++;
            }
        }
        int[] answer = {count,zero};
        return answer;
    }
}