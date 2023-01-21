import java.util.*;
class Solution {
    public int solution(int[] cards) {
   int answer = 0;
        Map<Integer,Integer> group =new HashMap<>();
        Map<Integer,Integer> key=new HashMap<>();
        Map<Integer,Integer> initKey=new HashMap<>();


        for(int i=0;i<cards.length;i++){
            if(!initKey.containsKey(cards[i])){
                initKey.put(cards[i],i);
            }
        }

        int cnt=0;
        int groupKey=1;

        while (true){
            if(initKey.isEmpty()){
                break;
            }
            int a=0;
            int card=cards[cnt];
            while (true){
                if(initKey.isEmpty()){
                    break;
                }
                if(!key.containsKey(card)){
                    a++;
                    key.put(card,1);
                    group.put(groupKey,group.getOrDefault(groupKey,0)+1);
                    initKey.remove(card);
                    card=cards[card-1];
                }else{
                    Set<Integer> keySet=initKey.keySet();
                    List<Integer> keyList=new ArrayList<>(keySet);
                    cnt=initKey.get(keyList.get(0));
                    groupKey++;
                    break;
                }
            }
        }
        List<Integer> integers=new ArrayList<>(group.values());
        Collections.sort(integers,Collections.reverseOrder());

        answer=0;
        if(integers.size()>1){
            answer=integers.get(0)*integers.get(1);
        }

        return answer;
    }
}