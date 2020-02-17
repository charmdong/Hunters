package com.foodhunter.study6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ2644_촌수계산_전혜인 {
	static int N;
	static int findA;
	static int findB;
	static int[] parents;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		findA = sc.nextInt();
		findB = sc.nextInt();

		//찾아야 하는 두 사람이 같은사람이면 0촌 리턴
		if (findA == findB) {
			System.out.println(0);
			return;
		}

		//모든 부모를 저장할 배열을 생성
		parents = new int[N + 1];

		//부모는 -1로 초기화 (제일 선조인 경우는 -1저장되어있음)
		for (int i = 1; i <= N; i++)
			parents[i] = -1;

		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			parents[c] = p;
		}

		boolean rightA = ifAisUpper(); // findA가 findB보다 위쪽에 있는 경우 (findA가 findB의 선조인 경우)

		if (!rightA) { //ifAisUpper에서 못찾은 경우
			boolean rightB = ifBisUpper(); // findB가 findA보다 위쪽에 있는 경우
			if (!rightB) { //둘다 아닌 경우는 연결된 선조가 없는 경우
				System.out.println(-1);
			}

		}
	}

	private static boolean ifBisUpper() {
		ArrayList<int[]> p1Arr = new ArrayList<int[]>(); // 첫번쨰 사람의 선조와, 그 선조와의 촌수(cnt)를 저장하는 2차원 ArrayList
		ArrayList<int[]> p2Arr = new ArrayList<int[]>(); // 두번쨰 사람의 선조와, 그 선조와의 촌수(cnt)를 저장하는 2차원 ArrayList

		int temp = findA;
		int cnt = 0;
		// p1의 조상 따라가기
		if (parents[temp] == -1) {
			p1Arr.add(new int[] { 0, temp });
		}
		while (true) {
			if (parents[temp] == -1) //더이상 선조가 없으면 break
				break;
			p1Arr.add(new int[] { ++cnt, parents[temp] }); //p1Arr에 선조들과 거기까지의 촌수 (cnt)저장
			temp = parents[temp];

		}

		temp = findB;
		cnt = 0;

		// p1과 temp의 부모 비교
		if (parents[temp] == findA) {
			System.out.println(1);
			return true;
		}

		// p2의 조상 따라가면서 p1의 조상에 있는지 여부 확인
		while (true) {
			if (parents[temp] == -1)
				break;

			// p1의 조상과 temp의 부모 비교
			for (int i = 0; i < p1Arr.size(); i++) {
				if (parents[temp] == p1Arr.get(i)[1]) {
					cnt += p1Arr.get(i)[0];
					System.out.println(cnt + 1);
					return true;
				}
			}

			p2Arr.add(new int[] { ++cnt, parents[temp] });
			temp = parents[temp];

		}

		return false;
	}

	private static boolean ifAisUpper() {
		ArrayList<int[]> p1Arr = new ArrayList<int[]>(); // 첫번쨰 사람의 선조와, 그 선조와의 촌수(cnt)를 저장하는 2차원 ArrayList
		ArrayList<int[]> p2Arr = new ArrayList<int[]>(); // 두번쨰 사람의 선조와, 그 선조와의 촌수(cnt)를 저장하는 2차원 ArrayList

		int temp = findB;
		int cnt = 0;
		// p1의 조상 따라가기
		if (parents[temp] == -1) {
			p2Arr.add(new int[] { 0, temp });
		}
		while (true) {
			if (parents[temp] == -1)
				break;
			p2Arr.add(new int[] { ++cnt, parents[temp] });
			temp = parents[temp];

		}

		temp = findA;
		cnt = 0;

		// p1과 temp의 부모 비교
		if (parents[temp] == findB) {
			System.out.println(1);
			return true;
		}

		// p2의 조상 따라가면서 p1의 조상에 있는지 여부 확인
		while (true) {
			if (parents[temp] == -1)
				break;

			// p1의 조상과 temp의 부모 비교
			for (int i = 0; i < p2Arr.size(); i++) {
				if (parents[temp] == p2Arr.get(i)[1]) { //p2의 조상에서 p1의 조상을 발견한 경우
					cnt += p2Arr.get(i)[0]; //양쪽 선조까지의 cnt를 더한 후 출력
					System.out.println(cnt + 1); 
					return true;
				}
			}

			p1Arr.add(new int[] { ++cnt, parents[temp] }); //발견하지 못한 경우 다음 조상으로 이동
			temp = parents[temp];

		}
		return false;
	}

}
