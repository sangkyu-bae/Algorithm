import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] fees, String[] records)  throws ParseException{
       Map<String,String> checkCarMap=new HashMap<>();
        Map<String,Integer> feeMap=new HashMap<>();
        Set<String> carNumber=new HashSet<>();
        for(String record:records){
            String[] recordInfo=record.split(" ");
            if(recordInfo[2].equals("IN")){
                checkCarMap.put(recordInfo[1],recordInfo[0]);
                carNumber.add(recordInfo[1]);
            }else if(recordInfo[2].equals("OUT")){
                String key=recordInfo[1];
                long diffMin = getDiffTime(checkCarMap.get(key),recordInfo[0]);
                feeMap.put(key,feeMap.getOrDefault(key,0)+(int)diffMin);
                checkCarMap.remove(key);
            }
        }
        for(String key:checkCarMap.keySet()){
            long diffMin = getDiffTime(checkCarMap.get(key),"23:59");
            feeMap.put(key,feeMap.getOrDefault(key,0)+(int)diffMin);
        }

        Map<String,Integer> fee=new HashMap<>();
        for(String key:feeMap.keySet()){
            int money= getFee(fees,feeMap.get(key));
            fee.put(key,money);
        }
        List<String> al=new ArrayList<>(carNumber);
        Collections.sort(al);
        int[] answer=new int[al.size()];
        
        for(int i=0;i<al.size();i++){
            answer[i]=fee.get(al.get(i));
        }
        
        return answer;
    }
    private Long getDiffTime(String inTimeString,String outTimeString) throws ParseException {
        Date inTime = new SimpleDateFormat("HH:mm").parse(inTimeString);
        Date outTime=new SimpleDateFormat("HH:mm").parse(outTimeString);

        return (outTime.getTime() - inTime.getTime()) / 60000;
    }

       private int getFee(int[] fee,int parkingTime){
        int basicTime=fee[0];
        int basicFee=fee[1];
        int standardTime=fee[2];
        int hourlyRate=fee[3];

        int stayBasicTime=(parkingTime-basicTime);
        if(stayBasicTime<0){
            return basicFee;
        }
        int perTime=stayBasicTime/standardTime;
        if(stayBasicTime%standardTime!=0){
            perTime++;
        }

        return hourlyRate*perTime+basicFee;
    }
}