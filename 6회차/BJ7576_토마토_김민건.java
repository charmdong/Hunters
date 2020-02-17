package _200214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576_토마토_김민건 {

	static int M, N, cnt, days = 0;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	static boolean isValid(int i, int j) {
		if (i < 0 || j < 0 || i >= N || j >= M) {
			return false;
		}
		return true;
	}
	
	public static void BFS() {
		Queue<Tomato> q = new LinkedList<Tomato>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					q.add(new Tomato(i, j));
			}
		}

		while (!q.isEmpty()) {

			Tomato tomato = q.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = tomato.y + dy[i];
				int nextx = tomato.x + dx[i];

				if (!isValid(nexty, nextx)) // 범위
					continue;
				if (map[nexty][nextx] != 0) // '0'이 아닐때
					continue;

				map[nexty][nextx] = map[tomato.y][tomato.x] + 1; // 1을 지속적으로 더해 준다.
				q.add(new Tomato(nexty, nextx));
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					return;
				}
				days = Math.max(days, map[i][j]);
			}
		}
		System.out.println(days - 1);
	}

	// =========================== 입 력 ===========================

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();

		// =========================== 입 력 ===========================

	}
}

class Tomato {
	int x;
	int y;

	Tomato(int y, int x) {
		this.y = y;
		this.x = x;
	}
}