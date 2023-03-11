import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
         int answer = 0;
        List<Character>a=new ArrayList<>();
        for(int i=0;i<skill.length();i++){
            a.add(skill.charAt(i));
        }

        for(String skillTree:skill_trees){
            boolean isTrue=true;
            boolean[] isCheck=new boolean[skill.length()];
            for(int i=0;i<skillTree.length();i++){
                char nowChar=skillTree.charAt(i);
                if(a.contains(nowChar)){
                    int index=a.indexOf(nowChar);
//                    System.out.println("=========");
//                    System.out.println(nowChar);
//                    System.out.println(index);
//                    System.out.println("==");
                    if(index!=0){
//                        System.out.println(index);
                        for(int j=0;j<index;j++){
//                            System.out.println(skillTree);
//                            System.out.println(j);
//                            System.out.println(isCheck[j]);
////                            System.out.println(nowChar);
//                            System.out.println("=========");
                            if(isCheck[j]==false){
                                isTrue=false;
                                break;
                            }
                        }
                    }
                    if(isTrue){
                        isCheck[index]=true;
                    }else{
                        break;
                    }
                }
            }
            if(isTrue){
                answer++;
            }
        }
        return answer;
    }
}