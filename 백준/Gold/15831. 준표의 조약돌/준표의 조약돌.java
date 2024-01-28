import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();

        char[] stoneArr = new char[N];
        String a = sc.next();
        for(int i = 0; i < a.length(); i++){
            stoneArr[i] = a.charAt(i);
        }

        int rightIndex = 0;

        int blackStoneCnt = 0;
        int whiteStoneCnt = 0;

        int ans = 0;
        for(int i = 0; i <N ;i++){

            while(rightIndex < N){
                if(blackStoneCnt == B && stoneArr[rightIndex] =='B') break;
                if(stoneArr[rightIndex++] == 'W') whiteStoneCnt++;
                else blackStoneCnt++;
            }
            
            if(whiteStoneCnt >= W)
                ans = Math.max(ans, rightIndex - i);
            
            if(stoneArr[i] == 'W') whiteStoneCnt--;
            else blackStoneCnt--;
        }

        System.out.println(ans);
    }
}