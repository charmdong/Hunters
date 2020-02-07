package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author : donggun.chung
 * @since : 2020. 2. 4.
 * @site : JUNGOL
 * @probNum : 1809 탑
 * @time : 1788ms
 * @memory : 31MB
 */
public class JO1809 {
    static class Top {
	int index;
	int height;

	public Top(int i, int h) {
	    index = i;
	    height = h;
	}
    }

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int[] hList = new int[n];

	String[] input = br.readLine().split(" ");
	for (int index = 0; index < n; index++) {
	    hList[index] = Integer.parseInt(input[index]);
	}

	solution(hList);
    }

    private static void solution(int[] hList) {
	Stack<Top> stack = new Stack<>();
	int len = hList.length;
	int[] answer = new int[len];

	for (int index = len - 1; index >= 0; index--) {
	    if (stack.isEmpty()) {
		stack.push(new Top(index, hList[index]));
	    } else {
		if (stack.peek().height >= hList[index]) {
		    stack.push(new Top(index, hList[index]));
		} else { // stack 안에 있는 신호탑의 신호가 현재 탑에 수신되는 경우
		    while (!stack.isEmpty() && stack.peek().height < hList[index]) {
			answer[stack.pop().index] = index + 1;
		    }

		    stack.push(new Top(index, hList[index]));
		}
	    }
	}

	for (int index = 0; index < len; index++) {
	    System.out.print(answer[index] + " ");
	}
	System.out.println();
    }
}
