package study8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178_미로탐색 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point front = queue.poll();

			if (front.x == N - 1 && front.y == M - 1) {
				System.out.println(front.cnt);
			}

			for (int d = 0; d < 4; d++) {
				int nx = front.x + dx[d];
				int ny = front.y + dy[d];

				if (isIn(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx,ny,front.cnt+1));
				}
			}
		}

	}

	private static boolean isIn(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

}
