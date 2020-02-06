package Study4;

import java.util.Scanner;

public class BJ14501_퇴사_유지민 {
	static int[] days;
	static int[] pay;
	static int max;
	static int N = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // N일까지 근무가능
		int totalPay = 0;

		days = new int[N];
		pay = new int[N];
		for (int i = 0; i < N; i++) { // 입력받기
			days[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		// index랑 total pay
		dfs(0, 0);
		System.out.println(max);

	}

	private static void dfs(int index, int totalPay) {
		// 기저조건
		if (index >= N) {
			if (max < totalPay)
				max = totalPay;
			return;
		}
		// 재귀
		if (index + days[index] <= N) //상담 가능한 
			dfs(index + days[index], totalPay + pay[index]);
		if (index + 1 <= N) //상담 가능하지 않은 날 
			dfs(index + 1, totalPay);

	}

}
