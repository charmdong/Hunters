package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs+priorityqueue
 * 1261 알고스팟이랑 똑같아
 */
public class BJ4485_녹색옷입은애가젤다지_전혜인 {
	static int N;
	static int[][] map;

	static class Point implements Comparable<Point> {
		int y, x, cost;

		public Point(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			if (this.cost < o.cost)
				return -1;
			else
				return 1;
		}
		
	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			N = Integer.parseInt(bf.readLine());
			if (N == 0)
				return;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("Problem " + tc + ": " + bfs());
			tc++;

		}
	}

	private static int bfs() {
		int min = 99999;
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		boolean visited[][] = new boolean[N][N];

		queue.add(new Point(0, 0, map[0][0]));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.y == N - 1 && p.x == N - 1) {
				if (min > p.cost)
					min = p.cost;
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				queue.add(new Point(ny, nx, p.cost + map[ny][nx]));
			}
		}
		return min;
	}

}
