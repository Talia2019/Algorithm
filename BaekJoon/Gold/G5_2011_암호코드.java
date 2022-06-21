package CJY.week3;

import java.util.HashMap;
import java.util.Scanner;

public class G5_2011 {
    static String str;
    static int strLen;
    static HashMap<String, Long> hashMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        strLen = str.length();
        hashMap = new HashMap<>();
        System.out.println(getNum(0));
    }

    public static long getNum(int start) {
        if (start == strLen - 1) {
            if (str.charAt(start) == '0')
                return 0;
            else
                return 1;
        }
        if (start > strLen - 1)
            return 1;
        if (!hashMap.containsKey(str.substring(start, strLen))) {
            long value;
            if (str.charAt(start) == '0')
                value = 0;
            else if (str.charAt(start) == '1')
                value = (getNum(start + 1) + getNum(start + 2)) % 1000000;
            else if (str.charAt(start) == '2') {
                if (str.charAt(start + 1) - '0' <= 6)
                    value = (getNum(start + 1) + getNum(start + 2)) % 1000000;
                else
                    value = getNum(start + 1) % 1000000;
            } else
                value = getNum(start + 1) % 1000000;

            hashMap.put(str.substring(start, strLen), value);
        }
        return hashMap.get(str.substring(start, strLen));
    }
}
