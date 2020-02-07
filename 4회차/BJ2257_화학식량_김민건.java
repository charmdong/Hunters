package _200203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2257_화학식량_김민건 {

	static char[] arr = new char[102];
	static boolean[] visited = new boolean[102];
	static int tmp;

	/*
	 * H20(물) CH3COOH(아세트산) H : 수소 , C : 탄소, O : 산소 숫자는 2이상 9이하
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		arr = str.toCharArray();
		System.out.println(recursive(str, 0, len));

	}

	public static int recursive(String str, int pos, int len) {

		int ret = 0;
		for (int i = pos; i < len; i++) {

			// 중복 방지
			if (visited[i])
				continue;
			visited[i] = true;

			char c = arr[i];

			switch (c) {
			case '(':
				ret += recursive(str, i + 1, len); // 재귀 시작
				break;

			case 'H':
				ret += 1;
				tmp = 1;
				break;

			case 'C':
				ret += 12;
				tmp = 12;
				break;

			case 'O':
				ret += 16;
				tmp = 16;
				break;

			case ')': // 재귀 종료
				// 숫자 일때
				if (i+1 < arr.length && '2' <= arr[i + 1] && arr[i + 1] <= '9') {
					visited[i + 1] = true;
					ret *= (arr[i + 1] - '0');
				}

				return ret;

			default:
				ret += (tmp * (arr[i] - '0')) - tmp;

			}// end of switch

		} // end of for
		return ret;
	}

}
