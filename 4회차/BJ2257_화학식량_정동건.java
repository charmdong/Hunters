<<<<<<< HEAD
package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author : donggun.chung
 * @since : 2020. 2. 4.
 * @site : BOJ
 * @probNum : 2257 화학식량
 * @time : 76ms
 * @memory : 12.8MB
 */
public class BJ2257 {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println(solution(br.readLine()));
    }

    private static int solution(String str) {
	Stack<Integer> stack = new Stack<>();
	int answer = 0;
	int len = str.length();

	for (int index = 0; index < len; index++) {
	    char ch = str.charAt(index);

	    switch (ch) {
	    case 'H':
	    case 'C':
	    case 'O':
	    case '(':
		int score;
		if (ch == 'H')
		    score = 1;
		else if (ch == 'C')
		    score = 12;
		else if (ch == 'O')
		    score = 16;
		else
		    score = -1;

		stack.push(score);
		break;

	    case ')':
		int total = 0;
		int top;
		
		while (true) {
		    top = stack.pop();

		    if (top == -1)
			break;

		    total += top;
		}
		
		if(total > 0) stack.push(total);
		break;

	    default:
		stack.push((stack.pop() * (ch - '0')));
	    }
	}

	while (!stack.isEmpty()) {
	    answer += stack.pop();
	}

	return answer;
    }
}
=======
package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author : donggun.chung
 * @since : 2020. 2. 4.
 * @site : BOJ
 * @probNum : 2257 화학식량
 * @time : 76ms
 * @memory : 12.8MB
 */
public class BJ2257 {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println(solution(br.readLine()));
    }

    private static int solution(String str) {
	Stack<Integer> stack = new Stack<>();
	int answer = 0;
	int len = str.length();

	for (int index = 0; index < len; index++) {
	    char ch = str.charAt(index);

	    switch (ch) {
	    case 'H':
	    case 'C':
	    case 'O':
	    case '(':
		int score;
		if (ch == 'H')
		    score = 1;
		else if (ch == 'C')
		    score = 12;
		else if (ch == 'O')
		    score = 16;
		else
		    score = -1;

		stack.push(score);
		break;

	    case ')':
		int total = 0;
		int top;
		
		while (true) {
		    top = stack.pop();

		    if (top == -1)
			break;

		    total += top;
		}
		
		if(total > 0) stack.push(total);
		break;

	    default:
		stack.push((stack.pop() * (ch - '0')));
	    }
	}

	while (!stack.isEmpty()) {
	    answer += stack.pop();
	}

	return answer;
    }
}
>>>>>>> 39ae92336bc5ad86f2fdefd205ef079ce725599d
