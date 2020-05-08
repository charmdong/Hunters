package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1922_네트워크연결 {
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		parents = new int[N+1];
		rank = new int[N+1];
		int[][] edges = new int[M][3];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}

		});
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if (a == b)
				continue;
			union(a, b);
			result += edges[i][2];
			cnt++;
			if (cnt == N - 1)
				break;
		}
		System.out.println(result);
	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
