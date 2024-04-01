import java.io.*;
import java.util.*;

public class Main {

    static public int[] cube;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cube = new int[25];
        for(int i = 1; i <=24;i++){
            cube[i]= sc.nextInt();
        }

        r();
        exitIfTrue(check());
        r();
        r();
        exitIfTrue(check());
        r();

        u();
        exitIfTrue(check());
        u();
        u();
        exitIfTrue(check());
        u();

        f();
        exitIfTrue(check());
        f();
        f();
        exitIfTrue(check());

        System.out.println(0);


    }

    static void exitIfTrue(boolean b){
        if(b){
            System.out.println(1);
            System.exit(0);
        }
    }

    static void r(){
        int temp1= cube[2];
        int temp2= cube[4];
        cube[2] = cube[6];
        cube[4] = cube[8];
        cube[6] = cube[10];
        cube[8] = cube[12];
        cube[10] = cube[23];
        cube[12] = cube[21];
        cube[23] = temp1;
        cube[21] = temp2;
    }
    static void u(){
        int temp1= cube[5];
        int temp2= cube[6];
        cube[5] = cube[13];
        cube[6] = cube[14];
        cube[13] = cube[21];
        cube[14] = cube[22];
        cube[21] = cube[17];
        cube[22] = cube[18];
        cube[17] = temp1;
        cube[18] = temp2;
    }

    static void f(){
        int temp1= cube[3];
        int temp2= cube[4];
        cube[3] = cube[16];
        cube[4] = cube[14];
        cube[16] = cube[10];
        cube[14] = cube[9];
        cube[10] = cube[17];
        cube[9] = cube[19];
        cube[17] = temp1;
        cube[19] = temp2;
    }
    static boolean check(){
        for(int i = 1 ; i<=24;i++){
            int[] base = {1,5,9,13,17,21};
            if(cube[i] != cube[base[(i-1)/4]]){
                return false;
            }
        }
        return true;
    }
}