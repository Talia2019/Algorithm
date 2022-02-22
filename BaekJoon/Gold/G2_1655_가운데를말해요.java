import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_1655 {

    // 정렬 nlogn * n = 10000000000넘음
    // 우선순위 큐 두개
    // 하나는 나보다 큰값이 들어가는애 max heap, 하나는 나보다 작은값들이 들어가는애 min heap
    // max heap은 가장큰거, min heap은 가장 작은거
    // 크기가 같으면 max heap에 넣고, min heap top < max heap top 면 swap
    // 크기가 다르면 min heap에 넣고, min heap top < max heap top 면 swap
    // 더 작은 중간값을 출력해야 하니까!
    // max heap top이 답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (minHeap.size() == maxHeap.size())
                maxHeap.add(Integer.parseInt(br.readLine()));
            else
                minHeap.add(Integer.parseInt(br.readLine()));

            if (minHeap.size() > 0 && minHeap.peek() < maxHeap.peek()) {
                int min = minHeap.poll();
                int max = maxHeap.poll();
                minHeap.add(max);
                maxHeap.add(min);
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
