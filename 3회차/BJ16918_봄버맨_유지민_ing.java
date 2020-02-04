package Study3;

import java.util.Scanner;

public class BJ16918_봄버맨_유지민_ing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		int[][] game;
		int R, C, N;
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt(); // 초
		game = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) { // 초기상태 저장
				if (sc.next().charAt(0) == '.') {
					game[i][j] = -1;
				} else
					game[i][j] = 3;
			}
		}
		for (int t = 1; t <= N; t++) {
			if (t == 1) // 1초
			{
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (game[i][j] > 0)
							game[i][j]--;
					}
				}
			} else if (t % 2 == 0) // 아무것도 일어나지 않은 1초 후
			{
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (game[i][j] > 0)
							game[i][j]--;
					}
				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (game[i][j] == -1)
							game[i][j] = 3; // 폭탄이 아니였던거
					}
				}
			} else if (t % 2 == 1) // 폭탄 아닌거 폭탄만들고나서 1초 후
			{
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (game[i][j] > 0)
							game[i][j]--;
					}
				}
				// 3초지난 폭탄 터짐!
				int[][] temp = new int[R][C];

				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (game[i][j] == 0) {
							game[i][j] = -1;

							for (int d = 0; d < 4; d++) {
								int x = j + dx[d];
								int y = i + dy[d];
								if (0 <= y && y < R && 0 <= x && x < C) {
									temp[y][x] = -1;
								}
							}
						}

					}
				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (temp[i][j] == -1) {
							game[i][j] = -1;
						}
					}
				}

			}

		}
		// 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (game[i][j] == -1)
					System.out.print(".");
				else
					System.out.print("0");
			}
			System.out.println();
		}

	}

}
