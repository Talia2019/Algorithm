package CJY.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1756 {
    //G5_1756_피자굽기
    //풀이보고 풀었음 ㅠ.ㅠ
    //정렬 + 이분탐색

    public static int[] oven;
    public static int bottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        oven = new int[d];
        oven[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < d; i++) {
            int o = Integer.parseInt(st.nextToken());
            oven[i - 1] = Math.min(o, oven[i - 1]);
        }
        bottom = d;
        st = new StringTokenizer(br.readLine(), " ");
        
        //이분탐색
        for (int i = 0; i < n; i++) {
            if (bottom == -1)
                break;
            binary(Integer.parseInt(st.nextToken()), 0, bottom - 1);
        }
        System.out.println(bottom + 1);
    }

    //target보다 크거나 같은 최소인덱스 찾기
    static void binary(int target, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (oven[mid] >= target) {
                res = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        bottom = res;
    }
}
