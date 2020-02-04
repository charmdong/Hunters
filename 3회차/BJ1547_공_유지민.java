package Study3;

import java.util.Scanner;

//공  bronze3
public class	BJ1547_공_유지민 {
	static int[] ball = { 1, 2, 3 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			swap(x, y);
		}
		System.out.println(ball[0]);

	}

	private static void swap(int x, int y) {
		int temp;
		int indexX = 0, indexY = 0;
		for(int i=0;i<3;i++)
		{
			if(ball[i]==x)
				indexX = i;
			else if(ball[i]==y)
				indexY = i;
		}
	
		temp = ball[indexX];
		ball[indexX] = ball[indexY];
		ball[indexY] = temp;
	}

}
