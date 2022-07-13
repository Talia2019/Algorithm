package CJY.ect.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_1697 {
    //S1_1697_숨바꼭질

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n==k) {
            System.out.println(0);
            System.exit(0);
        }

        boolean[] isVisited = new boolean[100001];

        Queue<Integer> q = new LinkedList<>();
        isVisited[n] = true;
        q.add(n);

        int time = -1;
        while (q.size() > 0) {
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                int add = cur + 1;
                int sub = cur - 1;
                int mul = cur * 2;
                if(add == k || sub == k || mul == k){
                    System.out.println(time + 1);
                    System.exit(0);
                }
                if (mul < 100000 && !isVisited[mul]) {
                    isVisited[mul] = true;
                    q.add(mul);
                }
                if (sub >= 0 && !isVisited[sub]) {
                    isVisited[sub] = true;
                    q.add(sub);
                }
                if (add <= 100000 && !isVisited[add]) {
                    isVisited[add] = true;
                    q.add(add);
                }
            }
        }
    }
}
