package Study5;

import java.util.Scanner;

public class BJ2606_바이러스_유지민 {
	static int num;
	static int connect;
	static boolean[] visited;
	static int[][] com;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt(); // 컴퓨터 수
		connect = sc.nextInt(); // 연결된 쌍의 수
		com = new int[num + 1][num + 1];
		visited = new boolean[num + 1];
		count = 0;
		for (int i = 0; i < connect; i++) { // 연결된 쌍 배열에 넣기
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			com[c1][c2] = 1;
			com[c2][c1] = 1;
		}
		dfs(1);
		System.out.println(count);

	}
	static void dfs(int index) {
		visited[index] = true;
		for (int i = 1; i <= num; i++) {
			if (!visited[i] && com[index][i] == 1) {
				count++;
				dfs(i);
			}
		}
		
	}
	
}
