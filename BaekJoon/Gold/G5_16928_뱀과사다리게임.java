package CJY.ect.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_16928 {
    //G5_16928_뱀과사다리게임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[101];
        boolean[] isVisited = new boolean[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        isVisited[1] = true;
        q.add(1);
        int num = -1;
        while (q.size() > 0) {
            num++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int dice = 1; dice <= 6; dice++) {
                    int next = cur + dice;
                    if(map[next] != 0)
                        next = map[next];
                    if(next == 100){
                        System.out.println(num + 1);
                        System.exit(0);
                    }
                    if(next > 100 || isVisited[next])
                        continue;
                    isVisited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
