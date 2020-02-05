package _200203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ4949_균형잡힌세상_김민건 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();

		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				return;

			boolean check = true;

			// 한글자씩 검사
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				switch (c) {
				case '(':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') { // 비어있거나 대칭이 없다면
						check = false;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						check = false;
					}
					break;
				} // end of switch

			} // end of for

			if (!stack.isEmpty()) { // empty가 아니라면
				check = false;
			}
			if (check == true) {
				System.out.println("yes");
			} else
				System.out.println("no");
			stack.clear();

		}
	}
}
