import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] numArr = new int[N];
        for(int i = 0; i < N; i++){
            numArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);

        int anwser = Integer.MAX_VALUE;
        for(int i = 0; i< numArr.length;i++){
            int r = i+1;
            int leftNum = numArr[i];
            while (r < numArr.length){

                int rigthNum = numArr[r];
                if(rigthNum - leftNum >= M){
                    anwser = Math.min(anwser, rigthNum -leftNum);
                    break;
                }
                r++;
            }
        }

        System.out.println(anwser);

    }

}