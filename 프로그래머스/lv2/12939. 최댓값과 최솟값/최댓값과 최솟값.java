import java.util.*;

class Solution {
    public String solution(String s) {
  List<Integer> a=new ArrayList<>();
        String intStr = "";
        boolean isCheck=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            String chd="";
            chd+=ch;
            if((48 <= ch && ch <= 57)||chd.equals("-")){
                if(i==s.length()-1){
                    intStr+=ch;
                    int chs=Integer.parseInt(intStr);
                    a.add(chs);
                }
                intStr+=ch;
                isCheck=true;
            }else {
                if(isCheck){
                    int chs=Integer.parseInt(intStr);
                    a.add(chs);
                    intStr="";
                    isCheck=false;
                }
            }
            chd="";
        }

        int min = a.stream().min(Integer::compare).orElse(-1);
        int max = a.stream().max(Integer::compare).orElse(-1);

        String answer = "";
        answer=min+" "+max;

        return answer;
    }
}