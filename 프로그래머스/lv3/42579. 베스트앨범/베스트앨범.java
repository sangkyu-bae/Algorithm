import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
         Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<TT>> orderMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            int value = plays[i];
            genreMap.put(key, genreMap.getOrDefault(key, 0) + value);

            if (orderMap.containsKey(key)) {
                List<TT> list = orderMap.get(key);
                list.add(new TT(i, value));
            } else {
                List<TT> list = new ArrayList<>();
                list.add(new TT(i, value));
                orderMap.put(key, list);
            }
        }

        // 장르별 총 재생 횟수를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());
        genreList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreList) {
            List<TT> list = orderMap.get(entry.getKey());
            list.sort(Comparator.<TT, Integer>comparing(tt -> tt.cnt).reversed());

            result.add(list.get(0).order);
            if (list.size() > 1) {
                result.add(list.get(1).order);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
     class TT{
        int order;
        int cnt;

        public TT(int order,int cnt){
            this.order = order;
            this.cnt = cnt;
        }
    }
}