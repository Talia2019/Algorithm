import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		/* 
		 * tc입력받기
		 * 반복문(tc) for
		 * 	앞에서부터 숫자가 변하는 횟수를 찾기
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			String num = sc.next();
			char flag = '0';
			int sum = 0;
			for(int j=0;j<num.length();j++) {
				char tmp = num.charAt(j);
				if(flag!=tmp) {
					sum++;
					flag = tmp;
				}
			}
			System.out.println("#"+i+" "+sum);
		}
		
	}	//end of main
}	//end of Solution
