package _200208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2606_바이러스_김민건 {

	static int N, connect, result;

	static int[][] map; // 그래프
	static boolean[] check; // 방문

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		check[start] = true;
		queue.offer(start);
		int virus = 0; // 감염 된 컴퓨터의 수

		
		while (!queue.isEmpty()) {
			int x = queue.poll();

			for (int i = 1; i < map.length; i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
				if (map[x][i] == 1 && check[i] != true) {
					queue.offer(i);
					check[i] = true;
					virus++;
				}
			}
		}
		System.out.println(virus); // 모든 탐색을 마치고 cnt 출력
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		connect = sc.nextInt();

		check = new boolean[N+1];
		map = new int[N + 1][N + 1];

		for (int i = 0; i < connect; i++) {
			int connect_a = sc.nextInt();
			int connect_b = sc.nextInt();
			map[connect_a][connect_b] = 1;
			map[connect_b][connect_a] = 1;

		}

		bfs(1);

	}

}
