package com.foodhunter.study6;
import java.util.Scanner;
import java.util.Stack;

public class BJ7576_토마토_전혜인 {
	static int N, M;
	static int[][] tomato;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		tomato = new int[M][N];

		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				tomato[row][col] = sc.nextInt();
			}
		}

		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(tomato[row][col]);
			}
			System.out.println();
		}
		int day = 0;
		while (true) {
			if(day==M*N) {
				System.out.println(-1);
				return;
			}
			System.out.println("------------------");
			System.out.println(day+"일째");
			day++;
			Stack stack = new Stack();
			for (int row = 0; row < M; row++) {
				for (int col = 0; col < N; col++) {
					if (tomato[row][col] == 1) {
						// 사방 토마토 1로 
						stack.add(col);
						stack.add(row);
						//tomatoMakesOne(row, col); //주위 토마토 1로 바꾸는 함수
						
						
//						for(int i=0;i<4;i++) {
//							if(row+dx[i]>=M || row+dx[i]<0 || col+dy[i]>=N || col+dy[i]<0)
//								continue;
//							if(tomato[row+dx[i]][col+dy[i]]==0) {		
//								tomato[row+dx[i]][col+dy[i]] = 1;
//							}
//						}
						
					}
				}
			}
			for (int row = 0; row < M; row++) {
				for (int col = 0; col < N; col++) {
					System.out.print(tomato[row][col]);
				}
				System.out.println();
			}
			while(!stack.isEmpty()) {
				tomatoMakesOne((int)stack.pop(), (int)stack.pop());
			}
			boolean ifZero = false;
		L:	for (int row = 0; row < M; row++) {
				for (int col = 0; col < N; col++) {
					if (tomato[row][col] == 0) {
						ifZero=true;
						break L;
					}
				}
			}
			if(!ifZero) break;
		}
		
		System.out.println(day);

	}

	private static void tomatoMakesOne(int row, int col) {
		for(int i=0;i<4;i++) {
			if(row+dx[i]>=M || row+dx[i]<0 || col+dy[i]>=N || col+dy[i]<0)
				continue;
			if(tomato[row+dx[i]][col+dy[i]]==0) {		
				tomato[row+dx[i]][col+dy[i]] = 1;
			}
		}

	}

}
