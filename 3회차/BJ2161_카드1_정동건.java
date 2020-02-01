package BJ;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ2161 {
    static Scanner sc = new Scanner(System.in);
    static int n, top;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) {
	n = sc.nextInt();

	for (int num = n; num > 0; num--) {
	    dq.push(num);
	}

	while (dq.size() > 1) {
	    top = dq.pop();

	    System.out.print(top + " ");
	    
	    top = dq.pop();
	    dq.addLast(top);
	}

	System.out.println(dq.pop());

	sc.close();
    }
}
