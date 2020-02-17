package com.foodhunter.study6;

import java.util.Scanner;

public class BJ1018_체스판다시칠하기_전혜인 {
	static int N, M;
	static char[][] board;

	static char[][] chess1 = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
	
	static char[][] chess2 = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = sc.next().toCharArray();
		}
		int min = 64;
		//맨 왼쪽 위부터 한칸씩 밀어가면서 8*8만큼 잘라서 체스판과 비교.
		for(int r=0;r<N-7;r++) {
			for(int c=0;c<M-7;c++) {
				int tmp = compareWithChessBoard1(r,c);
				if(tmp<min) min = tmp;
				tmp = compareWithChessBoard2(r,c);
				if(tmp<min) min = tmp;
			}
		}
		System.out.println(min);

	}

	//chess1과 비교해서 다른 칸의 숫자만큼 return
	private static int compareWithChessBoard2(int r, int c) {
		int cnt=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(chess1[i][j]!=board[r+i][c+j])
					cnt++;
			}
		}
		return cnt;
	}

	private static int compareWithChessBoard1(int r, int c) {
		int cnt=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(chess2[i][j]!=board[r+i][c+j])
					cnt++;
			}
		}
		return cnt;
		
	}

}
