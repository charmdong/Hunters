package Study6;

import java.util.Scanner;

public class BJ2961_도영이가만든맛있는음식_유지민 {
	static int N;
	static boolean selected[];
	static int[][] taste;
	static int sour = 0;
	static int bitter = 1;
	static int diff;
	static int min = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		taste = new int[N][2];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			taste[i][0] = sc.nextInt();
			taste[i][1] = sc.nextInt();
		}

		generateSubSet(0);
		System.out.println(min);
	}

	private static void generateSubSet(int index) {
		if (index == N) {
			int sour = 0;
			int bitter = 1;
			for (int i = 0; i < N; i++) {
				if (selected[i]) { // 선택된거는
					sour = sour + taste[i][1];
					bitter = bitter * taste[i][0];
					diff = Math.abs(sour - bitter);
				}
				min = Math.min(min, diff);
			}
			return;
		}
		// 뽑았을때
		selected[index] = true;
		generateSubSet(index + 1);
		// 안뽑았을
		selected[index] = false;
		generateSubSet(index + 1);
	}

}
