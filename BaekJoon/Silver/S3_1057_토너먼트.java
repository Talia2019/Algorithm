package CJY.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //Sol 1 - Queue
        //각 라운드별로 큐에 넣으며 지민이와 한수가 만나면 종료
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i == a || i == b) queue.add(new int[]{i, 1});
            else queue.add(new int[]{i, 0});
        }

        int round = 0;
        int number = n + 1;
        out:
        while (queue.size() > 0) {
            int curNum = queue.size();
            round++;
            if (curNum == 1)
                break;
            while (curNum > 0) {
                if (curNum >= 2) {
                    int[] left = queue.poll();
                    int[] right = queue.poll();
                    curNum -= 2;
                    if (left[1] == 1 && right[1] == 1)
                        break out;
                    if (left[1] == 1 || right[1] == 1)
                        queue.add(new int[]{number++, 1});
                    else
                        queue.add(new int[]{number++, 0});
                } else {
                    int[] left = queue.poll();
                    curNum--;
                    if (left[1] == 1)
                        queue.add(new int[]{number++, 1});
                }
            }
        }

        System.out.println(round);

        //Sol 2 - 수학
        //n이 짝수면 다음 라운드에서 n/2가 되고, 홀수면 다음 라운드에서 n/2 + 1가 됨
        int roundA = a / 2 + a % 2;
        int roundB = b / 2 + b % 2;
        round = 0;

        while (roundA != roundB) {
            roundA = roundA % 2 + roundA / 2;
            roundB = roundB % 2 + roundB / 2;
            round++;
        }

        System.out.println(round);
    }
}
