import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();

        for(int i = 0 ; i < n; i++){
            int aLength = sc.nextInt();
            int bLength = sc.nextInt();

            answer = 0;

            int[] aTest = new int[aLength];
            int[] bTest = new int[bLength];

            for(int j = 0; j <aLength; j++){
                aTest[j] = sc.nextInt();
            }

            for(int j = 0 ; j < bLength; j++){
                bTest[j] = sc.nextInt();
            }

            Arrays.sort(bTest);
            Arrays.sort(aTest);
            for(int j = 0 ; j < aLength; j++){
                int a = aTest[j];
                int sum = 0;
                int l = 0;
                int r = bLength -1;
                while (l <= r){
                    int midNum = (l+r) / 2;
                    int mid = bTest[midNum];
                    if(a > mid){
                        sum = midNum + 1;
                        l = midNum + 1;
                    }else{
                        r = midNum -1;
                    }
                }
                answer += sum;
            }

            System.out.println(answer);
        }
    }
}
