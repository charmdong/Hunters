import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1260_DFS와BFS_전혜인2 {
	static int n;
	static int m;
	static int v;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
		
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;
		
		int a;
		while(!q.isEmpty()) {
			a = q.poll();
			System.out.print(a+" ");
			for(int i=1;i<=n;i++) {
				if(map[a][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}

	private static void dfs(int v) {
		System.out.print(v+" ");
		visited[v]=true;
		for(int i=1;i<=n;i++) {
			if(map[v][i]==1 && !visited[i])
				dfs(i);
		}
		return;
		
	}

}
