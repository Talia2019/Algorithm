import java.util.Scanner;

public class Main {
	
//	RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//	집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 
//	아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//	1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//	N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//	i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
//	첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 
//	1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
	
	//둘중에 선택하도록?
	//1. 현재n중 가장 작은값 선택하도록 하고 top down
	//2. n-1최솟값 + 현재 선택가능한 가장작은값
	//1,2중에 더 작은값으로?
	
	//맨앞부터 내가 선택할 수 있는 집 중 가장 적은 비용 선택
	static int[] endA = new int[1001];
	static int[] endB = new int[1001];
	static int[] endC = new int[1001];
	static int[][] price = new int[1001][3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			price[i][0] = sc.nextInt();
			price[i][1] = sc.nextInt();
			price[i][2] = sc.nextInt();
		}
		
		int a = getPrice(n, 0);
		int b = getPrice(n,1);
		int c = getPrice(n,2);
		
		int k = a<b?a:b;
		k = k<c?k:c;
		System.out.println(k);
		

	}
	public static int getPrice(int n, int flag) {	//0:A, 1:B, 2:C
		if(n<0) return 0;
		int[] end = new int[1];
		int first = 0, second = 0;
		switch(flag) {
		case 0:
			end = endA;
			first = 1;
			second = 2;
			break;
		case 1:
			end = endB;
			first = 0;
			second = 2;
			break;
		case 2:
			end = endC;
			first = 0;
			second = 1;
			break;
		}
		if(end[n]==0) {
			first = price[n][first] + getPrice(n-1, first);
			second = price[n][second] + getPrice(n-1, second);
			end[n] = first<second? first:second;
		}
		return end[n];
	}
}
