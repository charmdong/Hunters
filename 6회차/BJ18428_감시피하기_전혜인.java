package com.foodhunter.study6;

import java.util.ArrayList;
import java.util.Scanner;

//5%틀렸습니다.

public class BJ18428_감시피하기_전혜인 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N;
	static int[][] map; // 선생님은 -1, 학생은 1, 장애물은 2, 아무것도 없으면 0
	static ArrayList<int[]> look;
	static int[][] teacher;

	static String result = "NO";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		look = new ArrayList<int[]>();
		int TN = 0; // 선생님 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char temp = sc.next().charAt(0);
				if (temp == 'X')
					map[i][j] = 0;
				else if (temp == 'T') {
					map[i][j] = -1;
					TN++;
					sightArr(i, j); // i,j선생이 볼 수 있는 위치를 배열에 저장
				} else if (temp == 'S')
					map[i][j] = 1;
			}
		}
		teacher = new int[TN][2];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					teacher[index][0] = i;
					teacher[index][1] = j;
					index++;
				}
			}
		}

		int[][] comArr = new int[3][2];
		combination(comArr, look.size(), 3, 0, 0);
		System.out.println(result);
	}

	private static void combination(int[][] comArr, int n, int r, int index, int target) {
		if (r == 0) {
//			for(int i=0;i<3;i++)
//				System.out.print(comArr[i][0]+","+comArr[i][1]+"    ");
//			System.out.println();
			if (checkPossible(comArr)) {
				// 학생이 안걸림
				result = "YES";
			}
			return;
		}
		if (target == n)
			return;

		if (map[look.get(target)[0]][look.get(target)[1]] != 1) {
			comArr[index][0] = look.get(target)[0];
			comArr[index][1] = look.get(target)[1];
			combination(comArr, n, r - 1, index + 1, target + 1);
			combination(comArr, n, r, index, target + 1);
		} else {
			combination(comArr, n, r, index, target + 1);
		}
	}

	private static boolean checkPossible(int[][] comArr) {
		// 배열 깊은 복사
		int[][] map2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, map2[i], 0, N);
		}

		boolean checkSight = true;

		for (int i = 0; i < 3; i++) {
			map2[comArr[i][0]][comArr[i][1]] = 2;
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map2[i][j] + " ");
//			}
//			System.out.println();
//		}

		L: for (int i = 0; i < 3; i++) {
			int tempI = teacher[i][0];
			int tempJ = teacher[i][1];
//			System.out.println("현재 선생 위치 : " + tempI + " " + tempJ);
			for (int p = 0; p < 4; p++) {
				int row = tempI;
				int col = tempJ;
				while (true) {
//					System.out.println("현재 좌표 : " + row + " " + col);
					if (row + dx[p] < 0 || row + dx[p] >= N || col + dy[p] < 0 || col + dy[p] >= N)
						break;
					if (map2[row][col] == 2) {
//						System.out.println(row + " " + col + " 장애물에 막힘");
						break; // 장애물에 막힘
					}

					if (map2[row][col] == 1) {
//						System.out.println("학생 걸림");
						checkSight = false; // 학생이 걸림
						break L;
					}

					row += dx[p];
					col += dy[p];

				}
			}
		}

		// 시선에 안닿으면 true 리턴
		if (checkSight)
			return true;
		return false;
	}

	// (i,j)위치의 선생의 시선에 닿는 위치 저장해줌
	private static void sightArr(int i, int j) {
		int tempI = i;
		int tempJ = j;
		for (int p = 0; p < 4; p++) {
			i = tempI;
			j = tempJ;
			while (true) {
				if (i + dx[p] < 0 || i + dx[p] >= N || j + dy[p] < 0 || j + dy[p] >= N)
					break;
				int[] arr = { i + dx[p], j + dy[p] };
				boolean alreadyIn = false; // 이미 해당 위치가 배열에 들어가있으면 true

				for (int k = 0; k < look.size(); k++) {
					if (look.get(k)[0] == arr[0] && look.get(k)[1] == arr[1])
						alreadyIn = true;
				}
				if (!alreadyIn)
					look.add(arr); // 배열에 없으면 add

				i += dx[p];
				j += dy[p];

			}
		}

	}

}
