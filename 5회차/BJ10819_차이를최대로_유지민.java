package Study5;

import java.util.Scanner;

public class BJ10819_차이를최대로_유지민 {
	static int N;
	static int[] arr; //처음에 주어지는 수 
	static boolean[] visited;
	static int[] newArr;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		newArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int index) {
		if (index == N) {// 기저조건 
			int total = 0;
			for (int i = 2; i <= N ; i++) {
				total  = total + Math.abs(arr[newArr[i-2]] - arr[newArr[i - 1]]);
			}
			if(max<total)
				max = total;
			return;
		}
		for (int i = 0; i < N; i++) { // 선택해서 배열에 넣기 
			if (visited[i] == false) {
				visited[i] = true;
				newArr[index] = i;
				dfs(index + 1);
				visited[i] = false;
			}
		}

	}

}
