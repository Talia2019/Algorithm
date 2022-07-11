package CJY.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S2_1141 {
    //S2_1141_접두사

    //길이가 길면 누군가의 접두사가 될 수 없음 -> 내림차순 정렬후 긴 애들부터 부분집합에 넣음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings, (o1, o2) -> {
            if (o1.length() == o2.length())
                return 0;
            else if (o1.length() > o2.length())
                return -1;
            else
                return 1;
        });

        Set<String> notPrefixSet = new HashSet<>();
        notPrefixSet.add(strings[0]);
        int num = 1;
        for (String cur : strings) {
            boolean isPrefix = true;
            for (String compare : notPrefixSet) {
                isPrefix = true;
                for (int i = 0; i < cur.length(); i++) {
                    if(cur.charAt(i) != compare.charAt(i)){
                        isPrefix = false;
                        break;
                    }
                }
                if(isPrefix){
                    break;
                }
            }
            if(!isPrefix){
                notPrefixSet.add(cur);
                num++;
            }
        }
        System.out.println(num);
    }
}
