package boj;

import java.util.Scanner;

public class Main_G1_11401_이항계수3 {

	public static final long DIVNUM = 1000000007;
	public static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		long up = factorial(n);
		long bot = factorial(k) * factorial(n - k) % DIVNUM;
		System.out.println(up * power(bot, DIVNUM - 2) % DIVNUM);
	}

	public static long factorial(long n) {
		long fac = 1L;
		while (n > 1) {
			fac = (fac * n) % DIVNUM;
			n--;
		}
		return fac;
	}

	public static long power(long n, long k) {
		if (k == 1)
			return n;

		long half = power(n, k / 2);
		
		if (k % 2 == 0)
			return (half * half) % DIVNUM;
		else
			return (((half * half) % DIVNUM) * n % DIVNUM) % DIVNUM;
	}
}
