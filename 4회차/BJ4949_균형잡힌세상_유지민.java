package Study4;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BJ4949_균형잡힌세상_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Character> stack = new LinkedList<Character>();

		while (true) {
			boolean balance = true;
			String str = sc.nextLine();
			if (str.equals("."))
				break;
			else {
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					switch (c) {
					case '(':
						stack.push(c);
						break;
					case '[':
						stack.push(c);
						break;
					case ')':
						if (stack.isEmpty()||stack.pop() != '(')
							balance = false;
						break;
					case ']':
						if (stack.isEmpty()||stack.pop() != '[')
							balance = false;
						break;
					default:
						break;
					}
				}
				if(!stack.isEmpty())
					balance = false;
				
				
				if (balance)
					System.out.println("yes");
				else
					System.out.println("no");
				stack.clear();
			}

		}

	}
}
