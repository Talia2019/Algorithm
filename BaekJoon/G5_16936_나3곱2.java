package CJY.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_16936 {
//    G5_16936_나3곱2
//    3의 배수가 아닌 것 뒤에 3의 배수가 나올 수는 없 -> 3의배수들을 앞쪽에위치

    static int n;
    static Long[] arrayA, arrayB;
    static Set<Long> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arrayA = new Long[n];
        arrayB = new Long[n];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrayB[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arrayB, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 % 3 == 0 && o2 % 3 == 0)
                    return o1.compareTo(o2);
                if (o1 % 3 == 0)
                    return -1;
                if (o2 % 3 == 0)
                    return 1;
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < n; j++)
                set.add(arrayB[j]);

            arrayA[0] = arrayB[i];
            loop(1, arrayB[i]);
        }
    }

    public static void loop(int cnt, long x) {
        if (cnt == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arrayA[i]).append(" ");
            }
            System.out.println(sb);
            System.exit(0);
        }

        long num;

        //div 3
        num = x / 3;
        if (x % 3 == 0 && set.contains(num)) {
            set.remove(num);
            arrayA[cnt] = num;
            loop(cnt + 1, num);
        }

        //mul 2
        num = x * 2;
        if (set.contains(num)) {
            set.remove(num);
            arrayA[cnt] = num;
            loop(cnt + 1, num);
        }
    }
}
