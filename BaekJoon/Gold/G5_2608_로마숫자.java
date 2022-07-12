package CJY.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2608 {
    //G5_2608_로마숫자

    static enum RomeNum {
        M(1000),
        D(500),
        C(100),
        L(50),
        X(10),
        V(5),
        I(1);

        private final int value;

        RomeNum(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int sum = romeToArabic(first) + romeToArabic(second);
        System.out.println(sum);
        System.out.println(arabicToRome(sum));
    }

    public static int romeToArabic(String arabic) {
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < arabic.length(); i++) {
            int cur = RomeNum.valueOf(String.valueOf(arabic.charAt(i))).value;
            if (cur > prev) {
                sum = sum - prev - prev + cur;
            } else {
                sum += cur;
            }
            prev = cur;
        }
        return sum;
    }

    public static String arabicToRome(int arabic) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RomeNum.values().length; i++) {
            RomeNum curRome = RomeNum.values()[i];
            if (i%2 == 1) {
                RomeNum nextRome = RomeNum.values()[i + 1];
                int size = arabic / nextRome.value;
                if (size == 9) {
                    sb.append(nextRome).append(RomeNum.values()[i - 1]);
                    arabic -= size * nextRome.value;
                    continue;
                }
            }
            int size = arabic / curRome.value;
            if (size == 4) {
                sb.append(curRome).append(RomeNum.values()[i - 1]);
            } else {
                for (int j = 0; j < size; j++) {
                    sb.append(curRome);
                }
            }
            arabic -= curRome.value * size;
        }
        return sb.toString();
    }
}
