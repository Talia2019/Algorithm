package CJY.week12;

import java.util.*;

public class G5_14395 {
    //G5_14395_4연산

    static int t;
    static String[] operators = {"*", "+", "/"};

    static class ST {
        long num;
        String op;

        public ST(long num, String op) {
            this.num = num;
            this.op = op;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        t = sc.nextInt();

        if (s == t) {
            System.out.println(0);
        } else if (t == 1) {
            System.out.println("/");
        } else {
            bfs(s);
        }

    }

    public static void bfs(long s) {
        Queue<ST> q = new LinkedList<>();
        q.offer(new ST(s, ""));

        Set<Long> visited = new HashSet<>();
        visited.add(s);

        while (q.size() > 0) {
            ST cur = q.poll();
            if (cur.num == t) {
                System.out.println(cur.op);
                return;
            }

            for (int i = 0; i < 3; i++) {
                long next = 0;
                switch (i) {
                    case 0:
                        next = cur.num * cur.num;
                        break;
                    case 1:
                        next = cur.num + cur.num;
                        break;
                    case 2:
                        next = 1;
                        break;
                }
                if(!visited.contains(next)){
                    visited.add(next);
                    q.offer(new ST(next, cur.op + operators[i]));
                }
            }
        }

        System.out.println(-1);
    }
}
