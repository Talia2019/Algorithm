package CJY.week15;

import java.util.Arrays;
import java.util.Scanner;

public class S1_10597 {
    //S1_10597_순열장난

    public static String origin;
    public static int last;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        origin = sc.next();
        last = origin.length();
        if (last >= 10)
            last = ((last - 9) / 2) + 9;

        boolean[] visited = new boolean[last + 1];
        loop("", 0, visited);
    }

    public static void loop(String result, int index, boolean[] visited) {
        if (index >= origin.length()) {
            System.out.println(result);
            System.exit(0);
        }

        int cur = origin.charAt(index) - '0';
        if (cur > 0 && cur <= last && !visited[cur]) {
            visited[cur] = true;
            loop(result + cur + " ", index + 1, visited);
            visited[cur] = false;
        }

        if (index < origin.length() - 1) {
            cur = cur * 10 + (origin.charAt(index + 1) - '0');
            if(cur > 0 && cur <= last && !visited[cur]){
                visited[cur] = true;
                loop(result + cur + " ", index + 2, visited);
                visited[cur] = false;
            }
        }

    }
}
