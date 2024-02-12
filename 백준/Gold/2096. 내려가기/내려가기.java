import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] maxDp = new int[5];
        int[] minDp = new int[5];
        int[] maxTemp = new int[5];
        int[] minTemp = new int[5];
        int MAX_VALUE = 10000000;
        int input = 0;

        maxDp[0] = 0;
        minDp[0] = MAX_VALUE;
        maxDp[4] = 0;
        minDp[4] = MAX_VALUE;

        for(int i = 1; i <=n ;i++){
            for(int j = 1; j<= 3;j++){
                input = sc.nextInt();
                maxTemp[j] = input + Math.max(maxDp[j - 1],Math.max(maxDp[j],maxDp[j+1]));
                minTemp[j] = input + Math.min(minDp[j - 1],Math.min(minDp[j],minDp[j+1]));
            }

            for(int j =1 ;j<=3 ;j++){
                maxDp[j] = maxTemp[j];
                minDp[j] = minTemp[j];
            }
        }

        int max = Math.max(maxDp[1],Math.max(maxDp[2],maxDp[3]));
        int min = Math.min(minDp[1],Math.min(minDp[2],minDp[3]));

        System.out.println(max+" "+min);

    }
}