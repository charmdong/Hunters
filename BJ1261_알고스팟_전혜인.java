
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs + 우선순위큐 사용 (사용안하면  tc2번처럼 벽을 뚫고 가는 경우가 최소인 경우 그 경우를 리턴하고 종료)
 */
public class BJ1261_알고스팟_전혜인 {
	static int R, C;
	static int[][] map;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	static class Point implements Comparable<Point> {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		//우선순위큐의 기준. 벽 뚫은 횟수가 작은 순 정렬
		@Override
		public int compareTo(Point o) {
			if (this.cnt < o.cnt)
				return -1;
			else
				return 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 1; j <= C; j++) {
				map[i][j] = Character.getNumericValue(tmp[j - 1]);
			}
		}

		bfs();

	}

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(1, 1, 0));
		boolean[][] visited = new boolean[R + 1][C + 1];
		visited[1][1] = true;

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (p.r == R && p.c == C) {
				System.out.println(p.cnt);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr <= 0 || nr > R || nc <= 0 || nc > C || visited[nr][nc])
					continue;
				if (map[nr][nc] == 0) {
					pq.add(new Point(nr, nc, p.cnt));
					visited[nr][nc] = true;
				} else {
					pq.add(new Point(nr, nc, p.cnt + 1));
					visited[nr][nc] = true;
				}
			}
		}

	}

}
