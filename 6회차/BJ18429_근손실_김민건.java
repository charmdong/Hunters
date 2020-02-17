package _200214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18429_근손실_김민건 {

	static int N, K, weight, cnt;
	static int[] plus;
	static int[] kit;
	static boolean[] visited;

	static void permitation(int index) {
		weight = 0;
		if (index == N) { // kit의 갯수와 같을 경우
			for (int j = 0; j < N; j++) {
				weight += plus[kit[j]];
				weight -= K;
				if (weight < 0) {
					return;
				}
			}
			cnt++;
			return;
		} else {

			for (int i = 0; i < N; i++) { // 키트의 갯수 만큼
				if (visited[i]) { // 방문 체크
					continue;
				} else {
					visited[i] = true;
					kit[i] = index;
					permitation(index + 1);
					visited[i] = false;
				}

			}
		}
	}

	// ========================= 입 력 =========================

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // kit 갯수
		K = Integer.parseInt(st.nextToken()); // 감소되는 중량

		cnt = 0;
		plus = new int[N];
		kit = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			plus[i] = Integer.parseInt(st.nextToken());
		}

		permitation(0);
		System.out.println(cnt);

		// ========================= 입 력 =========================
	}

}
