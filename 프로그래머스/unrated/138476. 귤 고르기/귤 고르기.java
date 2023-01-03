import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:tangerine){
            int a=map.containsKey(i) ? map.get(i) : 0;
            map.put(i,a+1);
        }
        HashMap<Integer,Integer> map3 = new HashMap<>(map);
      Map<Integer,Integer> tt=sortByValue(map3);

        int sum=0;
        int cnt=0;
        List<Integer> addList=new ArrayList<>();
        for (Integer key:tt.keySet()){
             sum+=tt.get(key);
             addList.add(key);
             cnt++;
             if(sum>=k) break;
        
        }

        return cnt;
    }
     public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm){
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}