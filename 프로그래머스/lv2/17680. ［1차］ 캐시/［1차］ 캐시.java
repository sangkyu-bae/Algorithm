import java.util.*;
class Solution {
 public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            answer = cities.length * 5;
        } else {
            List<String> list = new ArrayList<>();
            for (String city : cities) {
                city = city.toLowerCase();
                if (list.remove(city)) {
                    list.add(city);
                    answer++;
                } else if (list.size() < cacheSize) {
                    list.add(city);
                    answer += 5;
                } else {
                    list.remove(0);
                    list.add(city);
                    answer += 5;
                }
            }
        }
            System.out.println(answer);
            return answer;
    }
 }
        