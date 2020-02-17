package Study6;

import java.util.Scanner;

public class BJ1018_체스판다시칠하기_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		char[][] board = new char[N][M];
		char[][] perfectboard1 = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
		char[][] perfectboard2 = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
		int count1 = 0, count2 = 0;
		int min = 100;
		for (int i = 0; i < N; i++) // 보드 채우기
		{
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				count1 = 0;
				count2 = 0;
				for (int a = 0; a < 8; a++) {
					for (int b = 0; b < 8; b++) {
						if (board[i + a][j + b] != perfectboard1[a][b]) {
							count1++;
						}
						if (board[i + a][j + b] != perfectboard2[a][b]) {
							count2++;
						}
					}

				}

				if (count1 <= count2 && count1 < min)
					min = count1;
				else if (count1 > count2 && count2 < min)
					min = count2;

			}
		}
		System.out.println(min);
	}

}
