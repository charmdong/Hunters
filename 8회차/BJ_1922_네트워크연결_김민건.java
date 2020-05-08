package BJ_200503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1922_네트워크연결_김민건 {

	public static int N, M, minCost;
	public static int[] parent;
	public static PriorityQueue<edge> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		minCost = 0;
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수
		pq = new PriorityQueue<edge>();
		parent = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		} // end of input

		// 부모 초기화
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}

		while (!pq.isEmpty()) {
			edge ed = pq.poll();

			int x = find(ed.x);
			int y = find(ed.y);

			if (x == y)
				continue;
			unionNode(x, y);
			minCost += ed.cost;
		}

		sb.append(minCost + "\n");
		System.out.println(sb);
		br.close();
	} // end of main

	// 초기화
	public static void makeSet(int idx) {
		parent[idx] = idx;
	}

	// 부모 탐색
	public static int find(int idx) {
		if (parent[idx] == idx)
			return idx;
		return parent[idx] = find(parent[idx]);
	}

	// union
	public static void unionNode(int a, int b) {
		int nodeA = find(a);
		int nodeB = find(b);

		if (nodeA != nodeB)
			parent[a] = b;
	}
}

// 가중치 정보 클래스
class edge implements Comparable<edge> {
	int x, y, cost;

	public edge(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(edge o) {
		return this.cost - o.cost; // 오름차순 정렬 ( return 값이 양수일때 자리바꿈 )
	}

}
