package Study5;

import java.util.Scanner;

public class BJ2979_트럭주차_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, C;
		int count1 = 0, count2 = 0, count3 = 0;
		int[] truck = new int[100];

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		// 요금
		A = A * 1;
		B = B * 2;
		C = C * 3;

		for (int i = 0; i < 3; i++) {
			int s, e;
			s = sc.nextInt();
			e = sc.nextInt();
			for (int j = 0; j < 100; j++)
				if(j>=s&&j<e)
					truck[j]++;
			// if(j>=s)
		}

		for (int i = 0; i < 100; i++) {
			switch (truck[i]) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			default:
				break;
			}
		}
		
		int sum = (count1*A)+(count2*B)+(count3*C);
		System.out.println(sum);

	}

}
