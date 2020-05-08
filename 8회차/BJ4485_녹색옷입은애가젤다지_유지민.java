package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지 {
	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int cost;

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int tc = 0;
		while (true) {
			++tc;
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			int[][] map = new int[N][N];
			int[][] cost = new int[N][N];
			int ans = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}

			cost[0][0] = map[0][0];
			PriorityQueue<Point> pq = new PriorityQueue<>();
			Point p = new Point(0, 0, cost[0][0]);
			pq.add(p);
			cost[p.x][p.y] = map[p.x][p.y];

			while (!pq.isEmpty()) {
				p = pq.poll();

				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					if (isIn(nx, ny) && cost[nx][ny] > map[nx][ny] + p.cost) {
						cost[nx][ny] = map[nx][ny] + p.cost;
						pq.add(new Point(nx, ny, cost[nx][ny]));

					}
				}

			}
			ans = cost[N - 1][N - 1];
			System.out.println("Problem " + tc + ": " + ans);
		}
	}

	private static boolean isIn(int nx, int ny) {

		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}

}
