package com.foodhunter.study6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_B7576_토마토_전혜인 {
	static int N, M;
	static int[][] tomato;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Deque<pos> deque;
	// 입력받으면서 deque에 익은 토마토 넣기
	// deque한번 돌면서 토마토 익히기
	// 토마토가 전부 익었는지 확인하는 함수 실행
	// 익었으면 true 반환 안익었으면 -1반환
	// day를 알기위해 익힌 토마토는 그날의 숫자를 넣어줌

	static class pos {
		int row;
		int col;
		int day;

		public pos(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		tomato = new int[M][N];
		deque = new ArrayDeque<pos>();

		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				tomato[row][col] = sc.nextInt();
			}
		}

		// 익은 토마토 deque에 넣기
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (tomato[row][col] == 1)
					deque.add(new pos(row, col, 0));
			}
		}
		if (deque.isEmpty()) {
			System.out.println(-1);
			return;
		}

		int day = 0;

		// deque에서 하나씩 꺼내면서 주위 토마토 익히기
		while (!deque.isEmpty()) {
			pos temp = deque.poll();
			day = temp.day;

			tomatoMakesOne(temp.row, temp.col, temp.day);
		}
		// 모든 토마토 다 익었는지 확인
		if (checkFin()) {
			System.out.println(day);
			return;
		} else {
			System.out.println(-1);
			return;
		}
	}

	// 아직 안익은 토마토가 남아있으면 false, 다 익었으면 true 반환
	private static boolean checkFin() {
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (tomato[row][col] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static void tomatoMakesOne(int row, int col, int day) {
		for (int i = 0; i < 4; i++) {
			if (row + dx[i] >= M || row + dx[i] < 0 || col + dy[i] >= N || col + dy[i] < 0)
				continue;
			if (tomato[row + dx[i]][col + dy[i]] == 0) {
				tomato[row + dx[i]][col + dy[i]] = day + 1;
				deque.add(new pos(row + dx[i], col + dy[i], day + 1));
			}
		}
	}

}
