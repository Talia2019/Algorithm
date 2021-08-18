import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

// 	S1 1992 쿼드트리

//	4개의 재귀에서 나온값이 모두 같으면 하나만
//	다르면 괄호쓰고 모두 적음

	public static int[][] video;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		video = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(quadTree(0, 0, n));
	}

	public static String quadTree(int x, int y, int n) { // x,y부터 몇개 볼건지
		if (n == 1) {
			return Integer.toString(video[x][y]);
		}

		String result;
		String[] returns = new String[4];
		int num = n / 2;

		returns[0] = quadTree(x, y, num);
		returns[1] = quadTree(x, y + num, num);
		returns[2] = quadTree(x + num, y, num);
		returns[3] = quadTree(x + num, y + num, num);

		if ((returns[0].equals("0") && returns[0].equals(returns[1]) && returns[2].equals(returns[3]) && returns[1].equals(returns[2]))
				||(returns[0].equals("1") && returns[0].equals(returns[1]) && returns[2].equals(returns[3]) && returns[1].equals(returns[2])))	
			result = returns[0];
		else
			result = "(" + returns[0] + returns[1] + returns[2] + returns[3] + ")";

		return result;

	}

}
