package Study5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1260_DFS와BFS_유지민 {
	static boolean[] visitedD;
	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 갯수
		int M = sc.nextInt(); // 간선의 갯수
		int V = sc.nextInt(); // 탐색을 시작 할 정점의 번호
		arr = new int[N + 1][N + 1];

		Queue<Integer> queue = new LinkedList<Integer>();
		visitedD = new boolean[N + 1];
		boolean[] visitedB = new boolean[N + 1];

		for (int i = 0; i < M; i++) // 정점 표시
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		dfs(V);
		System.out.println();

		// BFS
		queue.offer(V);
		visitedB[V] = true;
		while (!queue.isEmpty()) {
			int standard = queue.poll();
			System.out.print(standard + " ");

			for (int j = 1; j <= N; j++) {
				if (!visitedB[j] && arr[standard][j] == 1) {
					queue.offer(j);
					visitedB[j] = true;
				}
			}
		}
		System.out.println();

	}
	// DFS

	static void dfs(int index) {
		visitedD[index] = true;
		System.out.print(index + " ");

		for (int i = 1; i <= N; i++) {
			if (!visitedD[i] && arr[index][i] == 1) {
				dfs(i);
			}
		}
	}
}
