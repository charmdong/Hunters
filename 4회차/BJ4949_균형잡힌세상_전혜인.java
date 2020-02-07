import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BJ4949_±ÕÇüÀâÈù¼¼»ó_ÀüÇıÀÎ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input;
		while(true) {
			input = sc.nextLine().toCharArray();
			int size=input.length;
			if(input[0]=='.' && size==1) {
				break;
			}
			Stack<Character> stack = new Stack<Character>();
			boolean result = true;
			L:for(int i=0;i<size;i++) {
				//System.out.print(input[i]);
				//System.out.println("ºñ¾ú´Ï : "+stack.isEmpty());
				switch(input[i]) {
				case '(':
					stack.push('(');
					break;
				case ')':
					if(stack.isEmpty() || stack.pop()!='(') {
						System.out.println("no");
						result = false;
						break L;
					}
					break;
				case '[':
					stack.push('[');
					break;
				case ']':
					if(stack.isEmpty() || stack.pop()!='[') {
						System.out.println("no");
						result = false;
						break L;
					}
					break;		
				default:
					break;
				}
			}
			if(result) {
				if(stack.isEmpty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
				
		}

	}

}