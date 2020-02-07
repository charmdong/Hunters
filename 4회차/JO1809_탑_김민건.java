package JUNGOL_0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO1809_탑_김민건 {

	static int[] arr;

	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		stack = new Stack<Integer>();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			if (N == 1) {
				stack.push(0);
				break;
			}
			search(N - 1);
			N--;
		}
		// stack -> String
		while (!stack.isEmpty()) {
			str.append(stack.pop() + " ");
		}

		System.out.println(str);

	}

	public static void search(int end) {
		int com = end - 1;
		while (com >= 0) {
			if (arr[end] < arr[com]) { // 레이저가 건물에 막히는 경우
				stack.push(com + 1);
				return;
			} else if (com == 0) {// 끝까지 레이저가 막히지 않는 경우
				stack.push(0);
				return;
			}
			--com;

		} // end of while

	} // end of search

}
