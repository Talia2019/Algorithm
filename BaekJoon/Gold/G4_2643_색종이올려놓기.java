package CJY.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_2643 {
    //G4_2643_색종이올려놓기
    //굉장히 비효율적인 노가다로 풀었음ㅎㅎ 빠른풀이들을 보니 dp사용
    
    public static int n, max;
    public static int[][] papers;
    public static List<Integer>[] smaller;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        papers = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            papers[i][0] = Integer.parseInt(st.nextToken());
            papers[i][1] = Integer.parseInt(st.nextToken());
        }

        smaller = new List[n];
        for (int i = 0; i < n; i++) {
            smaller[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if ((papers[i][0] >= papers[j][0] && papers[i][1] >= papers[j][1]) || (papers[i][0] >= papers[j][1] && papers[i][1] >= papers[j][0])) {
                        smaller[i].add(j);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            loop(i, 1, visited);
        }
        System.out.println(max);
    }

    public static void loop(int cur, int num, boolean[] visited) {
        if (num > max)
            max = num;

        for (int next : smaller[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                loop(next, num + 1, visited);
                visited[next] = false;
            }
        }
    }
}
