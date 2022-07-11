package CJY.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S1_7571 {
    //S1_7571_점모으기
    //평균인줄 알았는데 중앙값이었음!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] xList = new int[m];
        int[] yList = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            xList[i] = Integer.parseInt(st.nextToken());
            yList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xList);
        Arrays.sort(yList);
        
        int xMid, yMid;
        if(m%2 == 1){
            xMid = xList[m/2];
            yMid = yList[m/2];
        }else{
            xMid = (xList[m/2] + xList[m/2 - 1])/2;
            yMid = (yList[m/2] + yList[m/2 - 1])/2;
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += (Math.abs(xList[i] - xMid) + Math.abs(yList[i] - yMid));
        }
        System.out.println(sum);
    }
}
