package _200212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018_체스판다시칠하기_김민건 {

	static char[][] map; // 체스판 입력
	static char[][] check; // 비교대상

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		check = new char[2][8];
		check[0] = "WBWBWBWB".toCharArray();
		check[1] = "BWBWBWBW".toCharArray();

		// 입력
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		for (int i = 0; i < H; i++) {

			map[i] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE; // 최댓값

		// 8칸씩
		for (int i = 0; i <= H - 8; i++) {
			for (int j = 0; j <= W - 8; j++) {
				min = Math.min(min, solution(i, j));
			}
		}
		System.out.println(min);

	}

	private static int solution(int y, int x) {
		int min = Integer.MAX_VALUE; // 최댓값
		for (int i = 0; i < 2; i++) { // i = 0 'W' 먼저 시작/ i = 1 'B' 먼저 시작
			int cnt = 0;
			for (int j = 0; j < 8; j++) { // 8 x 8 검사.
				for (int k = 0; k < 8; k++) {

					if (map[y + j][x + k] != check[(i + j) % 2][k]) {
						cnt++; // 조건 체크
					}

				}
			}
			min = Math.min(min, cnt);
		}
		return min;
	}
}
