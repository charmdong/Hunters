package Study;

import java.util.Scanner;

public class BJ1476_날짜계산_유지민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E,S,M;
		//1476
		//1 <= E <= 15
		//1 <= S <= 28
		//1 <= M <= 19
		//1년 - 1씩 증가/ 범위 넘으면 1 
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		int e = 1,s = 1,m = 1,year = 1;
		while(true)
		{
			if(e == E && s == S && m == M)
				break;
			e++;
			s++;
			m++;
			year++;
			
			if(e>15)
				e = 1;
			if(s>28)
				s = 1;
			if(m>19)
				m = 1;
		}
		System.out.println(year);
	}
}
