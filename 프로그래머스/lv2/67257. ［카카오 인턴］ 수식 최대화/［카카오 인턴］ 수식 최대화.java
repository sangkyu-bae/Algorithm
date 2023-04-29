import java.util.*;
class Solution {
     String[] spread={"-","+","*"};
    List<Character> spreads=List.of('-','+','*');
    static List<Character>spreadList=new ArrayList<>();
    static List<Long>number=new ArrayList<>();
    int[] priority=new int[spread.length];
    boolean[]isPriority;

    Long result= Long.valueOf(0);
    public long solution(String expression) {
        long answer = 0;
        isPriority=new boolean[spread.length];
        String num="";
        for(char a:expression.toCharArray()){
            if(spreads.contains(a)){
                number.add(Long.valueOf(Integer.parseInt(num)));
                num="";
                spreadList.add(a);
            }else{
                num+=a;
            }
        }
        number.add(Long.valueOf(Integer.parseInt(num)));

        dfs(expression,0);
        System.out.println(result);
        return result;
    }
    void dfs(String expression,int depth){
        if(depth==spread.length){
            Long now = calc();
            if(now>result){
                result=now;
            }
            return;
        }
        for(int i=0;i<spread.length;i++){
            if(isPriority[i])
                continue;
            isPriority[i]=true;
            priority[depth]=i+1;
            dfs(expression,depth+1);
            isPriority[i]=false;
        }
    }
    private Long calc() {
        List<Long> copyNumList = new ArrayList<>(number);
        List<Character> copyOptList = new ArrayList<>(spreadList);
        char[] order=new char[3];
        int minus=priority[0];
        int plus=priority[1];
        int multiply=priority[2];
        order[minus-1]='-';
        order[plus-1]='+';
        order[multiply-1]='*';


        for (char opt : order) {
            for (int i = 0; i < copyOptList.size(); i++) {
                if (opt == copyOptList.get(i)) {
                    copyNumList.set(i, calcOpt(copyNumList.get(i), copyNumList.get(i + 1), opt));
                    copyNumList.remove(i + 1);
                    copyOptList.remove(i);
                    i--;
                }
            }
        }
        Long a=Math.abs(copyNumList.get(0));
        return a;
    }

    private Long calcOpt(Long a,Long b, char opt) {
        Long res = Long.valueOf(0);
        if (opt == '+') {
            res = a + b;
        } else if (opt == '-') {
            res = a - b;
        } else {
            res = a * b;
        }
        return res;
    }
}