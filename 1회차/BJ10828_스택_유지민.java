package Study;

import java.util.Scanner;
//stack
public class BJ10828_스택_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stack = new int[N];
		int j = 0; 
		for (int i = 0; i < N; i++) {
			String order = sc.next();

			switch (order) {
			case "push":
				stack[++j] = sc.nextInt();
				break;
			case "pop":
				if (j == 0)
					System.out.println(-1);
				else {
					System.out.println(stack[j--]);
				}
				break;
			case "size":
				System.out.println(j);
				break;
			case "empty":
				if (j == 0)
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (j == 0)
					System.out.println(-1);
				else
					System.out.println(stack[j]);
				break;
			default:
				break;
			}
		}
	}

}
