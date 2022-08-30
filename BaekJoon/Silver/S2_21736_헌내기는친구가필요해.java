package CJY.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_21736 {
    //S2_21736_헌내기는친구가필요해

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char[][] campus = new char[n][m];
        int[] doyeon = new int[2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = str.charAt(j);
                if(campus[i][j] == 'I'){
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(doyeon);
        int cnt = 0;
        while(queue.size() > 0){
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dir[d][0];
                int ny = cur[1] + dir[d][1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(visited[nx][ny])
                    continue;
                switch(campus[nx][ny]){
                    case 'P':
                        cnt++;
                    case 'O':
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        break;
                }
            }
        }

        if(cnt == 0)
            System.out.println("TT");
        else
            System.out.println(cnt);
    }
}
