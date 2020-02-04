package Study3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ5397_키로거_유지민 {
	public static void main(String[] args) throws IOException {
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		;
		for (int tc = 0; tc < T; tc++) {
			String keyboard = br.readLine();
			for (int i = 0; i < keyboard.length(); i++) {
				char temp = keyboard.charAt(i);
				if (temp == '<') {
					if (!stack1.empty()) {
						stack2.push(stack1.pop());
					}
				} else if (temp == '>') {
					if (!stack2.empty()) {
						stack1.push(stack2.pop());
					}
				} else if (temp == '-') {
					if (!stack1.empty()) {
						stack1.pop();
					}
				} else {
					stack1.push(temp);
				}
			}
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			while (!stack2.isEmpty())
				bw.write(stack2.pop());
			bw.write("\n");
		}
		bw.close();
	}
}
