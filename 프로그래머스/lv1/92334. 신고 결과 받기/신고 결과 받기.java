import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
   int[] answer = new int[id_list.length];
        Map<String,List<String>> reportMap = new HashMap<>();
        Map<String,Integer> resultMap =new HashMap<>();

        for(String re : report){
            String userName = re.split(" ")[0];
            String reportName = re.split(" ")[1];

            if(!reportMap.containsKey(reportName)){
                List<String> nameList = new ArrayList<>();
                nameList.add(userName);
                reportMap.put(reportName,nameList);
                continue;
            }

            List<String> reportList = reportMap.get(reportName);
            if(!reportList.contains(userName)){
                reportList.add(userName);
            }
        }

        for(String key: reportMap.keySet()){
            List<String> reportName =reportMap.get(key);
            if(reportName.size() >= k){
                for(String name : reportName){
                    resultMap.put(name,resultMap.getOrDefault(name,0)+1);
                }
            }
        }

        for(int i=0 ; i < id_list.length ; i++){
            String name = id_list[i];

            if(!resultMap.containsKey(name)){
                answer[i]=0;
                continue;
            }

            answer[i] = resultMap.get(name);
        }

        for(int a:answer){
            System.out.println(a);
        }
        return answer;
    }
}