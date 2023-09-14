import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
   
    Map<String,String> upMap = new HashMap<>();
        Map<String,Integer> moneyMap = new HashMap<>();

        int length = enroll.length;
        int[] answer = new int[length];
        for(int i = 0 ; i< length;i++){
            if(!upMap.containsKey(enroll[i])){
                upMap.put(enroll[i],referral[i]);
                moneyMap.put(enroll[i],0);
            }
        }

        int sellLength = seller.length;

        for(int i = 0;i<sellLength;i++){
            String person = seller[i];
            int totalMoney = amount[i] * 100;
            int commission = totalMoney /10;
            int money = totalMoney - commission;
            if(upMap.containsKey(person)){
                moneyMap.put(person,moneyMap.get(person)+money);
                while (!upMap.get(person).equals("-")){
                    person= upMap.get(person);
                    if(totalMoney == 0){
                        break;
                    } else {
                        totalMoney /= 10;
                        commission = totalMoney/10;
                        money =totalMoney-commission;
                        moneyMap.put(person, moneyMap.get(person)+money);
                    }
                }
            }
        }

        for(int i = 0 ;i < enroll.length;i++){
            answer[i] = moneyMap.get(enroll[i]);
        }

        return answer;
    }
}