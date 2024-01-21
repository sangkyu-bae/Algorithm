import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        char[] sequence = sc.next().toCharArray();
        int[] minimumCount = new int[4];
        int[] count = new int[4];
        for(int i =0 ;i < 4 ;i++){
            minimumCount[i] = sc.nextInt();
        }

        for(int i = 0 ; i < P;i++){
            count[baseToIndex(sequence[i])]++;
        }

        int answer = 0;
        if(checkDna(count,minimumCount)){
            answer++;
        }
        for(int i = P ;i < S;i++){
            count[baseToIndex(sequence[i-P])]--;
            count[baseToIndex(sequence[i])]++;
            if(checkDna(count,minimumCount)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkDna(int[] countArr,int[] checkArr){
        for(int i = 0;i<countArr.length;i++){
            if(countArr[i] < checkArr[i]){
                return false;
            }
        }

        return true;
    }

    public static int baseToIndex(char nowChar){
        if(nowChar == 'A'){
            return 0;
        }

        if(nowChar == 'C'){
            return 1;
        }

        if(nowChar == 'G'){
            return 2;
        }

        if(nowChar == 'T'){
            return 3;
        }

        return -1;
    }

}