import java.util.*;
import java.time.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
         String answer = "";
        int time=0;
        m=changeMelody(m);
        for(String ms:musicinfos){
            String music="";
            String[] info=ms.split(",");
            String startTimeString = info[0];
            String endTimeString = info[1];
            String musicName=info[2];
            String sheetMusic=info[3];
            sheetMusic=changeMelody(sheetMusic);
            // LocalTime으로 시작 시간과 종료 시간을 파싱한다.
            LocalTime startTime = LocalTime.parse(startTimeString);
            LocalTime endTime = LocalTime.parse(endTimeString);

            // 두 시간 사이의 시간 차이를 구한다.
            Duration duration = Duration.between(startTime, endTime);

            // Duration 객체에서 분 단위의 값을 추출한다.
            long minutes = duration.toMinutes();
            int min= (int) minutes;
            int i=0;
            while (minutes>0){
                music+=sheetMusic.charAt(i);

                if(i>=sheetMusic.length()-1){
                    i=0;
                }else{
                    i++;
                }
                minutes--;
            }

            if(music.indexOf(m)>-1&&min>time){
              answer=musicName;
              time=min;
              System.out.println(music);
              System.out.println(min);
            }
        }
        if(answer.equals("")){
            answer="(None)";
        }
        System.out.println(answer);
        return answer;
    }
      String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");

        return newMelody;
    }
}