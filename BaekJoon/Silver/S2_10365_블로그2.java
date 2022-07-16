package CJY.week7;

import java.util.Scanner;

public class S2_20365 {
    //S2_10365_블로그2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int redNum = 0, blueNum = 0;
        boolean redFlag = false, blueFlag = false;

        for (int i = 0; i < str.length(); i++) {
            if(!redFlag && str.charAt(i)=='R'){
                redFlag = true;
                blueFlag = false;
                redNum++;

            } else if(!blueFlag && str.charAt(i)=='B'){
                blueFlag = true;
                redFlag = false;
                blueNum++;
            }
        }
        System.out.println((1 + Math.min(redNum, blueNum)));
    }
}
