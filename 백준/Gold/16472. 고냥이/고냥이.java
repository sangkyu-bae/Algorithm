import java.io.*;
import java.util.Scanner;

public class Main {

    static int cnt = 0;
    static int[] frequency = new int[26];
    static void increase(char alp){
        if(frequency[alp - 'a']++ == 0)
            cnt++;
    }

    static void decrease(char alp){
        if(--frequency[alp -'a'] == 0)
            cnt--;
    }

    static int getAlphabetCount(int[] alphabetFrequency){
        int cnt = 0;
        for(int i = 0; i < alphabetFrequency.length;i++ ){
            if(alphabetFrequency[i] > 0){
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String catTalk = sc.next();
        char[] nyang = catTalk.toCharArray();
        int L = nyang.length;

        int ans = 0;
        int nextIndex = 0;

        for(int i = 0 ;i < L;i++){
            while (nextIndex < L){
                increase(nyang[nextIndex++]);
                if(cnt > N){
                    decrease(nyang[--nextIndex]);
                    break;
                }
            }

            decrease(nyang[i]);
            ans = Math.max(ans, nextIndex - i);
        }

        System.out.println(ans);
        
    }

}