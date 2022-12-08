package CJY.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_19598 {
    //G5_19598_최소회의실개수

    static int n;

    static class Room implements Comparable<Room>{
        long start, end;

        public Room(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if(o.start == this.start)
                return Long.compare(this.end, o.end);
            return Long.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Room> startQueue = new PriorityQueue<>();
        PriorityQueue<Long> endQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            startQueue.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        endQueue.add(startQueue.poll().end);
        while(startQueue.size() > 0){
            Room cur = startQueue.poll();
            if(endQueue.peek() <= cur.start){
                endQueue.poll();
            }
            endQueue.add(cur.end);
        }

        System.out.println(endQueue.size());
    }
}
