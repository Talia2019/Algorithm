package CJY.week4;

import java.util.Scanner;

public class G5_2022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double xx = x * x;
        double yy = y * y;
        double c = sc.nextDouble();

        double start = 0;
        double end = Math.min(x, y);
        double mid;
        while (start <= end) {
            mid = (start + end) / 2;
            double mm = mid * mid;
            double xm = Math.sqrt(xx - mm);
            double ym = Math.sqrt(yy - mm);
            double curC = (xm * ym) / (xm + ym);

            //0.001로하면 오차가 커지는듯?
            if (Math.abs(c - curC) <= 0.0001) {
                System.out.println(String.format("%.3f", mid));
                break;
            }
            if (curC > c) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }
}
