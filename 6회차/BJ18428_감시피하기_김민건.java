package _200214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18428_감시피하기_김민건 {
	static int N;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	// 범위 검사
	static boolean isValid(int i, int j) {
		if (i < 0 || j < 0 || i >= N || j >= N) {
			return false;
		} else
			return true;
	}

	// T가 S를 발견하는 경우 검사
	static boolean search(int row, int col) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int next_y = row + dy[i] * cnt;
			int next_x = col + dx[i] * cnt;
			if (map[next_y][next_x] == 'S') {
				while (map[next_y][next_x] == 'S') {
					new report_point(next_y, next_x);
					next_y = row + dy[i] * cnt;
					next_x = col + dx[i] * cnt;
				}
			}
			cnt++;
		}
		return true;
	}
	// ============================== 입 력 ==============================

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		// ============================== 입 력 ==============================

	}

}

// T의 S발견 좌표 기록
class report_point {
	int row, col;

	public report_point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

}
