package CJY.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_13975 {
    //G4_13975_파일합치기3
    //제일작은수 두개를 뽑아서 더함을 반복

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();

                sum += (a+b);
                pq.add(a + b);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
