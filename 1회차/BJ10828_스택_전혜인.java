import java.util.Scanner;
import java.util.Stack;

public class BJ10828_스택_전혜인 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String input;
		sc.nextLine();
		for(int i=0;i<n;i++) {
			input=sc.nextLine();
			String[] arr = input.split(" ");
			if(arr[0].equals("push")) {
				int a = Integer.parseInt(arr[1]);
				stack.push(a);
			} else if(arr[0].equals("pop")) {
				if(stack.size()>0)
					System.out.println(stack.pop());
				else
					System.out.println(-1);
			} else if(arr[0].equals("top")) {
				if(stack.size()>0)
					System.out.println(stack.peek());
				else
					System.out.println(-1);
			} else if(arr[0].equals("size")) {
				System.out.println(stack.size());
			} else if(arr[0].equals("empty")) {
				if(stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
		
	}

}