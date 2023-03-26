import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
       List<String> list=new ArrayList<>();
        int duplication=words.length;
        boolean isDuplication=false;

        int anomalyNum=0;
        boolean isAnomaly=false;

        char[] initArr=words[0].toCharArray();
        char last = initArr[0];
        for(int i=0;i<words.length;i++){
            String word=words[i];
            char[] checkChars=word.toCharArray();
            if(list.contains(word)){
                isDuplication=true;
                duplication=i+1;
                break;
            }
            if(last!=checkChars[0]){
                isAnomaly=true;
                anomalyNum=i+1;
                break;
            }
            last=checkChars[checkChars.length-1];
            list.add(word);
        }

        if(isAnomaly){
            System.out.println(anomalyNum);
            int order=anomalyNum%n;
            int width=anomalyNum/n;
            System.out.println("isAnomaly");
            if(order>0){
                width++;
            }else {
                order=n;
            }
            int[] result={order,width};
            for(int a:result){
                System.out.println(a);
            }
            return result;
        }

        if(isDuplication){
            int order=duplication%n;
            int width=duplication/n;
            if(order>0){
                width++;
            }else {
                order=n;
            }
            int[] result={order,width};
            System.out.println("isDuplication");

            for(int a:result){
                System.out.println(a);
            }
            return result;
        }

        int[] answer={0,0};
        return answer;
    }
}