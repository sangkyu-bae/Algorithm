import java.io.*;
import java.util.*;

public class Main {
    static int index  = 0;
    static int checkSum = 0;
    static int[] frequency = new int[26];

    public static void increase(char a){
        if(frequency[ a - 'a'] == 0){
            checkSum++;
        }

        frequency[ a - 'a' ] ++;
    }

    public static void decrease(char a){
        if(--frequency[a - 'a'] == 0){
            checkSum--;
        }
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] alpArr = sc.next().toCharArray();

        int ans = 0;

        for(int i = 0 ; i < alpArr.length;i++){
            while (index < alpArr.length){
                increase(alpArr[index++]);

                if(checkSum > n){
                    decrease(alpArr[--index]);
                    break;
                }
            }

            decrease(alpArr[i]);
            ans = Math.max(ans,index - i);
        }

        System.out.println(ans);
    }
}
