package _200208;

import java.util.Scanner;

public class BJ10819_차이를최대로_김민건 {

	static int N;
	static int[] arr, arr2; // 입력배열, 임시배열
	static boolean[] visited; // 방문확인
	static int result; // 정답

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = 0;
		N = sc.nextInt();
		arr = new int[N];
		arr2 = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		recursive(0);
		System.out.println(result);

	}

	private static void recursive(int index) {

		if (index == N) { // index를 채웠다면
			int sum = 0; // 초기화
			// 만든 배열로 값 계산
			for (int i = 0; i < N - 1; i++)
				sum += Math.abs(arr2[i] - arr2[i + 1]);
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true; // 방문 표시
			arr2[index] = arr[i]; // 새로운 배열 만들기
			recursive(index + 1); // 재귀
			visited[i] = false; // 방문 해제
		}

	}
}
