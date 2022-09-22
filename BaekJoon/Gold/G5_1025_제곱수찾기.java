package CJY.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1025 {
    //G5_1025_제곱수찾기
    //코드가..너무더러워서...이게맞는방법일까..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int max = -1;
        for (int gapI = 0; gapI < n; gapI++) {
            for (int gapJ = 0; gapJ < m; gapJ++) {
                if (gapI == 0 && gapJ == 0)
                    continue;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int x = i;
                        int y = j;
                        int number = 0;
                        while (x < n && y < m) {
                            number = number * 10 + map[x][y];
                            if (Math.sqrt(number) % 1 == 0) {
                                max = Math.max(number, max);
                            }
                            x += gapI;
                            y += gapJ;
                        }
                    }

                    for (int j = m - 1; j >= 0; j--) {
                        int x = i;
                        int y = j;
                        int number = 0;
                        while (x < n && y >= 0) {
                            number = number * 10 + map[x][y];
                            if (Math.sqrt(number) % 1 == 0) {
                                max = Math.max(number, max);
                            }
                            x += gapI;
                            y -= gapJ;
                        }
                    }
                }

                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j < m; j++) {
                        int x = i;
                        int y = j;
                        int number = 0;
                        while (x >= 0 && y < m) {
                            number = number * 10 + map[x][y];
                            if (Math.sqrt(number) % 1 == 0) {
                                max = Math.max(number, max);
                            }
                            x -= gapI;
                            y += gapJ;
                        }
                    }

                    for (int j = m - 1; j >= 0; j--) {
                        int x = i;
                        int y = j;
                        int number = 0;
                        while (x >= 0 && y >= 0) {
                            number = number * 10 + map[x][y];
                            if (Math.sqrt(number) % 1 == 0) {
                                max = Math.max(number, max);
                            }
                            x -= gapI;
                            y -= gapJ;
                        }
                    }
                }
            }
        }
        if (max >= 0)
            System.out.println(max);
        else if (n == 1 && m == 1 && Math.sqrt(map[0][0]) % 1 == 0)
            System.out.println(map[0][0]);
        else
            System.out.println(-1);
    }
}
