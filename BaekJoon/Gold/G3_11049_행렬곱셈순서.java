import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_11049 {
    static int[][] dp, matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(program(0, n-1));
    }

    public static int program(int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] == 0) {
            int front, back, merge;
            int min = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                front = program(start, i);
                back = program(i + 1, end);
                merge = matrix[start][0] * matrix[i][1] * matrix[end][1];
                if (min > front + back + merge) {
                    min = front + back + merge;
                }
            }
            dp[start][end] = min;
        }
        return dp[start][end];
    }
}
