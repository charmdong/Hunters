package BJ;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author : donggun.chung
 * @since : 2020. 2. 8.
 * @site : BOJ
 * @probNum : 1914 하노이 탑
 * @time : 3828ms
 * @memory : 175MB
 */
public class BJ1914_하노이탑_정동건 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    
    public static void main(String[] args) {
	n = sc.nextInt();
	
	BigInteger answer = BigInteger.ONE;
	
	for(int index = 0; index < n; index++) {
	    answer = answer.multiply(BigInteger.valueOf(2));
	}
	
	answer = answer.subtract(BigInteger.valueOf(1));
	
	System.out.println(answer);
	
	if(n <= 20) {
	    hanoi(n, 1, 3, 2);
	}
    }
    
    private static void hanoi(int n, int from, int to, int assistant) {
	if(n == 1) {
	    System.out.println(from + " " + to);
	    return;
	}
	
	hanoi(n - 1, from, assistant, to);
	System.out.println(from + " " + to);
	hanoi(n - 1, assistant, to, from);
    }

}
