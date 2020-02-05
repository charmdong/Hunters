package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, answer;
    static int[] time, price;
    
    public static void main(String[] args) throws Exception {
	String[] cmd;
	n = Integer.parseInt(br.readLine());
	
	time = new int[n + 1];
	price = new int[n + 1];
	
	for(int index = 1; index <= n; index++) {
	    cmd = br.readLine().split(" ");
	    
	    time[index] = Integer.parseInt(cmd[0]);
	    price[index] = Integer.parseInt(cmd[1]);
	}
	
	solution(1, 0);
	
	System.out.println(answer);
    }

    private static void solution(int day, int pTotal) {
	if(day > n + 1) {
	    return;
	}
	
	if(day == n + 1) {
	    if(answer < pTotal) {
		answer = pTotal;
	    }
	    return;
	}
	
	solution(day + time[day], pTotal + price[day]);
	solution(day + 1, pTotal);
    }
}
