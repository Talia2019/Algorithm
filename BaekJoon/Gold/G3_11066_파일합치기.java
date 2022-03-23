import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_11066 {
    static int[][] dp;
    static int[] papers;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            dp = new int[k][k];
            sum = new int[k][k];
            papers = new int[k];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < k; i++) {
                papers[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(program(0, k-1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int getSum(int start, int end) {
        if (sum[start][end] == 0) {
            if (end == start)
                sum[start][end] = papers[start];
            else if (end - start == 1)
                sum[start][end] = papers[start] + papers[end];
            else
                sum[start][end] = Math.min(papers[start] + getSum(start + 1, end), papers[start] + papers[start + 1] + getSum(start + 2, end));
        }
        return sum[start][end];
    }

    public static int program(int start, int end) {
        if (start == end)
            return 0;
        if (dp[start][end] == 0) {
            int min = Integer.MAX_VALUE;
            int sum = getSum(start, end);
            for (int i = start; i < end; i++) {
                int front = program(start, i);
                int back = program(i + 1, end);
                if(min > front + back + sum)
                    min = front + back + sum;
            }
            dp[start][end] = min;
        }
        return dp[start][end];
    }
}
