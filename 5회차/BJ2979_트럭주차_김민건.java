package _200208;

import java.util.Scanner;

public class BJ2979_트럭주차_김민건 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int in, out, sum = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		boolean[][] arr = new boolean[3][100];

		for (int i = 0; i < 3; i++) {
			in = sc.nextInt();
			out = sc.nextInt();
			for (int j = in; j < out; j++) {
				arr[i][j] = true;
			}

		}
		int a_a = 0;
		int a_b = 0;
		int a_c = 0;
		for (int j = 1; j < 100; j++) {

			if (arr[0][j] == true && arr[1][j] == true && arr[2][j] == true) {
				sum += 3 * c;
				a_c = +3 * c;
				continue;
			} else if (arr[0][j] == true && arr[1][j] == true || arr[0][j] == true && arr[2][j] == true
					|| arr[1][j] == true && arr[2][j] == true) {
				sum += 2 * b;
				a_b += 2 * b;
				continue;
			} else if (arr[0][j] == true || arr[1][j] == true || arr[2][j] == true) {
				sum += a;
				a_a += a;
			}
		}

		System.out.println(sum);

	}

}
