package CJY.week4;

import java.util.Scanner;

public class S1_1527 {
    static int a, b;
    static int[] numberList = {4, 7};
    static int numberSize = 2;
    static boolean isOver;
    static long answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        int aCopy = a, bCopy = b;
        int aLen = 0, bLen = 0;
        while (aCopy > 0) {
            aLen++;
            aCopy /= 10;
        }
        while (bCopy > 0) {
            bLen++;
            bCopy /= 10;
        }
        for (int i = aLen; i <= bLen; i++) {
            permutationRe(i, 0, 0);
            if (isOver)
                break;
        }

        System.out.println(answer);
    }

    public static void permutationRe(int len, int curSize, long endNum) {
        if (curSize == len) {
            if (endNum >= a && endNum <= b)
                answer++;
            if (endNum >= b)
                isOver = true;
            return;
        }
        for (int i = 0; i < numberSize; i++) {
            permutationRe(len, curSize + 1, endNum * 10 + numberList[i]);
        }
    }
}

