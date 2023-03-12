import java.util.*;
class Solution {
    public String[] solution(String[] files) {
    String[] answer = {};
        Arrays.sort(files,(o1,o2)->{
            o1=o1.toLowerCase();
            o2=o2.toLowerCase();


            String[] o1Parse=parseFileName(o1);
            String[] o2Parse=parseFileName(o2);
            int headValue = o1Parse[0].compareTo(o2Parse[0]);

            if(headValue == 0) {
                int num1 = Integer.parseInt(o1Parse[1]);
                int num2 = Integer.parseInt(o2Parse[1]);

                return num1 - num2;
            } else {
                return headValue;
            }
//            if(o1Parse[0].equals(o2Parse[0])){
//                int o1Num=Integer.parseInt(o1Parse[1]);
//                int o2Num=Integer.parseInt(o2Parse[1]);
//                return o1Num-o2Num;
//            }
//            return o1.compareTo(o2);
        });

        for(String a:files){
            System.out.println(a);
        }
        return files;
    }
    
       public String[] parseFileName(String file) {
        String head = "";
        String num = "";

        boolean isNum = false;
        boolean isHead = true;
        boolean isTail = false;

        for (int i = 0; i < file.length(); i++) {
            char b = file.charAt(i);

            if (isHead) {
                if (48 <= b && b <= 57) {
                    isHead = false;
                    isNum = true;
                    num += b;
                } else {
                    head += b;
                }
            } else if (isNum) {
                if (!(48 <= b && b <= 57)) {
                    isNum = false;
                    isTail = true;
                } else {
                    num += b;
                }
            }
        }

        String[] files={head,num};
        return files;
    }
}