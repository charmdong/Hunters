package Study5;

import java.util.Scanner;

public class BJ2999_비밀이메일_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = sc.next(); // 메세지를 받아요
		char[][] encrypt;
		int N = message.length();
		int R = 0, C = 0;
		int maxR = 0;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (!(r * c == N))

					continue;
				else {
					if (r <= c && r >= maxR) {
						R = r;
						C = c;
					}
				}
			}
		}
		encrypt = new char[R][C];
		int index = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				encrypt[j][i] = message.charAt(index++);

			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				System.out.print(encrypt[i][j]);
		}

	}

}
