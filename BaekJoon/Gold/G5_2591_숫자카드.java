package CJY.week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G5_2591 {
    //G5_2591_숫자카드

    static Map<String, Long> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        map = new HashMap<>();

        System.out.println(getNum(x));
    }

    public static long getNum(String x) {
        if (map.containsKey(x))
            return map.get(x);

        long ret = 0;

        if (x.charAt(0) == '0') {
            map.put(x, ret);
            return ret;
        }


        int len = x.length();

        if (len == 2) {
            if (Integer.parseInt(x) <= 34) {
                ret = 1 + getNum(x.substring(1, len));
                map.put(x, ret);
                return ret;
            }
            ret = getNum(x.substring(1, 2));
            map.put(x, ret);
            return ret;
        }

        if (len == 1) {
            ret = 1;
            map.put(x, ret);
            return ret;
        }

        if (Integer.parseInt(x.substring(0, 2)) <= 34) {
            ret = getNum(x.substring(1, len)) + getNum(x.substring(2, len));
            map.put(x, ret);
            return ret;
        } else {
            ret = getNum(x.substring(1, len));
            map.put(x, ret);
            return ret;
        }
    }
}
