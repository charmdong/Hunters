package _200201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ16918_º½¹ö¸Ç_±è¹Î°Ç {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ÀÔ·Â
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Ãâ·Â
		StringTokenizer st = new StringTokenizer(br.readLine()); // °ø¹éÀ» ±âÁØÀ¸·Î ½ºÇÊ¸´

		int R, C, N;
		R = Integer.parseInt(st.nextToken()); // Çà
		C = Integer.parseInt(st.nextToken()); // ¿­
		N = Integer.parseInt(st.nextToken()); // ÃÊ
		int[][] map = new int[R][C]; // ¸Ê
		int time = 0;
		// µ¨Å¸
		int[] drow = { -1, 1, 0, 0 }; // »ó ÇÏ ÁÂ ¿ì
		int[] dcol = { 0, 0, -1, 1 }; // »ó ÇÏ ÁÂ ¿ì

		// ÃÊ±â ÆøÅº À§Ä¡
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray(); // charÇüÀ¸·Î ¹Þ´Â´Ù
			for (int j = 0; j < C; j++) {
				if (input[j] == '.') {
					map[i][j] = 0; // ºóÄ­
				} else {
					map[i][j] = 1; // ÆøÅº
				}

			} // end of for(j)

		} // end of for(i)

		// °ÝÀÚÆÇ »óÅÂ ±¸ÇÏ±â
		for (int k = 0; k < N; k++) {
			time++;
			// ¸ÅÃÊ °ÝÀÚÆÇ »óÅÂ
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {	// ÆøÅºÀÌ µé¾îÀÖ´Â Ä­
						
					}
				}
			}
		}

	}

}
