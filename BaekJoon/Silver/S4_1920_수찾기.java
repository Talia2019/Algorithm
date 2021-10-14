package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S4_1920_수찾기 {

	// 얘는 해쉬로해도 될거같은데..

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
//		int[] a = new int[n];
		Set<String> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			set.add(st.nextToken());
//			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " "); 
		for (int i = 0; i < m; i++) {
			if(set.contains(st.nextToken())) sb.append("1").append("\n");
			else sb.append("0").append("\n");
		}
		
		System.out.println(sb);

	}

}
