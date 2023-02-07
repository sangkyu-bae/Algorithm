import java.util.*;
class Solution {
    public int solution(int[] order) {
       int answer = 0;
        Stack<Integer> stack= new Stack<>();
        Stack<Integer> checkStack=new Stack<>();
        for(int i=order.length-1;i>-1;i--){
            stack.push(order[i]);
        }
        for(int i=0;i<order.length;i++){
            int a=stack.peek();
            if(a==i+1){
                stack.pop();
                answer++;
                while (true){
                    if(stack.isEmpty()||checkStack.isEmpty()){
                        break;
                    }
                    int b=stack.peek();
                    int j=checkStack.peek();
                    if(b==j){
                        answer++;
                        stack.pop();
                        checkStack.pop();
                    }else{
                        break;
                    }
                }
            }else{
                checkStack.push(i+1);
            }
        }

        return answer;
    }
}