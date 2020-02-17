package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author donggun.chung
 * @date 2020. 2. 13.
 * @site BOJ
 * @time 96ms
 * @memory 13MB
 */
public class BJ1018_체스판다시칠하기_정동건 {
	static final int LEN = 8;
	static int N, M, answer = Integer.MAX_VALUE;
	static char[][] board;
	static char[][] cmp1 = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
	static char[][] cmp2 = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		
		board = new char[M][N];
		
		for(int row = 0; row < M; row++) {
			str = br.readLine().split("");
			
			for(int col = 0; col < N; col++) {
				board[row][col] = str[col].charAt(0);
			}
		}
		
		for(int row = 0; row <= M - 8; row++) {
			for(int col = 0; col <= N - 8; col++) {
				int res = solution(row, col);
				
				if(answer > res) answer = res;
			}
		}
		
		System.out.println(answer);
	}
	
	private static int solution(int y, int x) {
		int diff1 = 0;
		int diff2 = 0;
		
		for(int row = y; row < y + LEN; row++) {
			for(int col = x; col < x + LEN; col++) {
				if(board[row][col] != cmp1[row - y][col - x]) {
					diff1++;
				}
				
				if(board[row][col] != cmp2[row - y][col - x]) {
					diff2++;
				}
			}
		}
		
		return (diff1 < diff2) ? diff1 : diff2;
	}

}
