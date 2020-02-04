import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class JO1809_Å¾_ÀüÇıÀÎ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] result = new int[n];
		Stack<Integer> stackB = new Stack<Integer>();
		Stack<Integer> stackI = new Stack<Integer>();
		for(int i=1;i<=n;i++) {
			int h = sc.nextInt();
			if(stackB.isEmpty()) {
				stackB.push(h);
				stackI.push(i);
				continue;
			}
			if(stackB.peek() <= h) {
				while(!stackB.isEmpty()) {
					if(stackB.peek() <= h) {
						stackB.pop();
						stackI.pop();
					}
					else {
						result[i-1]=stackI.peek();
						break;
					}
				}
				stackB.push(h);
				stackI.push(i);
			} else {
				result[i-1]=stackI.peek();
				stackB.push(h);
				stackI.push(i);
			}
			
		}
		for(int i=0;i<n;i++)
			System.out.print(result[i]+" ");
	}

}
