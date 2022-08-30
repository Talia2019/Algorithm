package CJY.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16507 {
    //S1_16507_어두운건무서워

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] picture = new int[r + 1][c + 1];
        int[][] sumArr = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for (int j = 1; j <= c; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
                sum += picture[i][j];
                sumArr[i][j] = sum;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = r1; j <= r2; j++) {
                sum += (sumArr[j][c2] - sumArr[j][c1] + picture[j][c1]);
            }
            sb.append(sum / ((r2 - r1 + 1) * (c2 - c1 + 1))).append("\n");
        }

        System.out.println(sb);

    }
}
