package Study6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2644_촌수계산_유지민 {
	static int n, m;
	static int[][] map;
	static int[] visited;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 전체 사람 수
		int from = sc.nextInt();
		int to = sc.nextInt();
		// from 부터 to 까지의촌수를 구해요 !
		map = new int[n + 1][n + 1];
		visited = new int[n + 1];
		int m = sc.nextInt(); // 관계의 갯수

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			map[a][b] = 1;
			map[b][a] = 1;
		}
		queue.offer(from);
		while (!queue.isEmpty()) {
			int standard = queue.poll();
			for (int j = 1; j <= n; j++) {
				if (map[standard][j] == 1) {
					if (visited[j] == 0) {
						queue.offer(j);
						visited[j] = visited[standard] + 1;
						;
					}
				}
			}
		}
		if (visited[to] == 0)
			System.out.println(-1);
		else
			System.out.println(visited[to]);
	}

}
