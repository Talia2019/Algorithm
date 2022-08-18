package CJY.week11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G5_12919 {
    //G5_12919_A와B2
    static String s, t;
    static int sLen;
    static Map<String, Integer> dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.nextLine();
        t = sc.nextLine();

        sLen = s.length();

        dp = new HashMap<>();
        loop(t, t.length());

        System.out.println(0);
    }

    public static int loop(String str, int len) {
        if (len == sLen) {
            if (str.equals(s)) {
                System.out.println(1);
                System.exit(0);
            } else {
                return 0;
            }
        }

        if (dp.get(str) == null) {
            int a = 0, b = 0;
            if(str.charAt(str.length() - 1) == 'A')
                a = loop(str.substring(0, str.length() - 1), len - 1);
            if(str.charAt(0) == 'B')
                b = loop(reverseString(str.substring(1)), len - 1);
            if (a == 0 && b == 0)
                dp.put(str, 0);
            else if (a == 0)
                dp.put(str, 1);
            else if (b == 0)
                dp.put(str, 1);
            else
                dp.put(str, 1);
        }

        return dp.get(str);
    }

    public static String reverseString(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}
