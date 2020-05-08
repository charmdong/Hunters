package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 프림 알고리즘
 */
public class BJ1922_네트워크연결_전혜인 {
	static int N, M;
	static int[][] com;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		com = new int[N][N];
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			com[a-1][b-1] = cost;
			com[b-1][a-1] = cost;
		}

		int[] res = new int[N];
		Arrays.fill(res, 99999);
		res[0] = 0;

		// 비선택 정점
		List<Integer> notChoosed = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			notChoosed.add(i);
		}

		int main = 0; // 임의의 정점 0 선택
		notChoosed.remove(0); //0은 선택되었으니까 제외
		for (int t = 0; t < N-1; t++) {
			// 선택된 정점 main에서 다른 정점들까지 최소 비용 갱신
			for (int nc : notChoosed) {
				if (com[main][nc] != 0 && res[nc] > com[main][nc]) {
					res[nc] = com[main][nc];
				}
			}
			
			//값이 최소인 정점을 다음 정점으로 선택
			int min=99999;
			int minIndex = -1;
			//값이 최소인 인덱스번호 받아옴
			for (int nc : notChoosed) {
				if(res[nc]<min) {
					min = res[nc];
					minIndex = nc;
				}
			}
			//그 점을 다음 정점으로 선택
			main = minIndex;
			//선택되었으므로 제외
			for (int i=0;i<notChoosed.size();i++) {
				if(notChoosed.get(i)==main) {
					notChoosed.remove(i);
				}
			}
		}
		
		int total = 0;
		for(int i=0;i<N;i++) {
			total+=res[i];
		}
		System.out.println(total);
	}

}
