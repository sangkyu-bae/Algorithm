import java.util.*;
import java.util.regex.Pattern;
class Solution {
    public int solution(String str1, String str2) {
       int answer = 0;
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();

        List<String> str1List=new ArrayList<>();
        List<String> str2List=new ArrayList<>();

        String str1Check="";
        String str2Check="";
        for(int i=0;i<str1.length()-1;i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);

            if(Character.isLetter(a) && Character.isLetter(b)) {
                String str = Character.toString(a) + Character.toString(b);
                str1List.add(str);
            }
        }

        for(int i=0;i<str2.length()-1;i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);

            if(Character.isLetter(a) && Character.isLetter(b)) {
                String str = Character.toString(a) + Character.toString(b);
                str2List.add(str);
            }
        }
//        for(String a:str1List){
//           if(str2List.contains(a)){
//               min++;
//           }
//        }
        List<String>intersection=new ArrayList<>();
        List<String>union=new ArrayList<>();
        for(String s : str1List) {
            if(str2List.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가
                intersection.add(s);
            }
            union.add(s);
        }

        // 합집합 구하기
        for(String s : str2List) { // 교집합에서 제외된 것 뺀 나머지 합집합에 추가
            union.add(s);
        }
        int min=intersection.size();
        int sum=union.size();
        double jacarde=(double) min/(double) sum;
        answer=(int)(jacarde*65536);
        if(sum==0){
            answer=65536;
        }
        return answer;
    }
  
}