package Study6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7576_토마토_유지민 {
	static int M, N, count = 0;
	static int[][] map;
	static Queue<Integer> queueX = new LinkedList<Integer>();
	static Queue<Integer> queueY = new LinkedList<Integer>();

	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					visited[i][j] = true;
					queueX.offer(i);
					queueY.offer(j);
				}
			}
		}
		while (!queueX.isEmpty() && !queueY.isEmpty()) {
			int x = queueX.poll();
			int y = queueY.poll();

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (map[nx][ny] != 0)
					continue;
				if (map[nx][ny] == 0) {
					queueX.offer(nx);
					queueY.offer(ny);

					visited[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		if (count != 0)
			System.out.println(-1);
		else
			System.out.println(max - 1);
	}
}
