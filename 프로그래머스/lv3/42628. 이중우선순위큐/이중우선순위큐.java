import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
           int[] answer = new int[2];

        List<Integer> numberList = new ArrayList<>();
        for (String operation : operations) {
            String[] checkOperation = operation.split(" ");
            String command = checkOperation[0];
            int number = Integer.parseInt(checkOperation[1]);

            if (command.equals("I")) {
                numberList.add(number);
                System.out.println("num 추가 : "+number);
            } else if (command.equals("D")) {
                if(!numberList.isEmpty()){
                    if (number < 0) {
                        int min = Collections.min(numberList);
                        numberList.remove(Integer.valueOf(min));
                        System.out.println("최소값 삭제 : " +min);
                        System.out.println("최소값 삭제 후 크기 : " +numberList.size());
                    } else {
                        int max = Collections.max(numberList);
                        numberList.remove(Integer.valueOf(max));
                        System.out.println("최대값 삭제 : " +max);
                        System.out.println("최대값 삭제 후 크기 : " +numberList.size());
                    }
                }
            }
        }

        if (numberList.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        answer[0] = Collections.max(numberList);
        answer[1] = Collections.min(numberList);
        
        return answer;
    }
}