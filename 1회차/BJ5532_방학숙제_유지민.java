package Study;
import java.util.Scanner;
public class BJ5532_방학숙제_유지민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L,A,B,C,D;
		L = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		int mDay = 0,kDay = 0;
		mDay = calDay(B,D);
		kDay = calDay(A,C);
		if (mDay>kDay)
			System.out.println(L-mDay);
		else
			System.out.println(L-kDay);
	}
	public static int calDay(int total,int day)
	{
		if(total%day != 0)
			return total/day + 1;
		else 
			return total/day;
	}
}
