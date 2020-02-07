package Study4;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BJ2257_화학식량_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		int result = 0;

		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		
			if (c == 'C')
				stack.push(12);
			else if (c == 'H')
				stack.push(1);
			else if (c == 'O')
				stack.push(16);
			else if (c == '(')
				stack.push(0);
			else if (c == ')') {
				sum = 0;
				while (!stack.isEmpty()) {
					int a = stack.pop();
					if (a == 0)
						break;
					else
						sum = sum + a;
				}
				stack.push(sum);
			} else if (c >= '2' && c <= '9') {
				stack.push(stack.pop() * (c - '0'));
			}
		}
		while (!stack.isEmpty()) {
			result = result + stack.pop();
		}
		System.out.println(result);
		stack.clear();
	}
}
