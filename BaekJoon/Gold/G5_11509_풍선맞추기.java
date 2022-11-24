package CJY.week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G5_11509 {
    //G5_11509_풍선맞추기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] balloons = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> arrows = new HashMap<>();
        arrows.put(balloons[0] - 1, 1);
        int arrowNum = 1;
        int num = 0;
        for (int i = 1; i < n; i++) {
            int balloon = balloons[i];
            if (arrows.containsKey(balloon)) {
                num = arrows.get(balloon);
                if (num == 1) {
                    arrows.remove(balloon);
                } else {
                    arrows.put(balloon, num - 1);
                }
            } else {
                arrowNum++;
            }
            num = arrows.getOrDefault(balloon - 1, 0);
            arrows.put(balloon - 1, num + 1);
        }

        System.out.println(arrowNum);
    }
}
