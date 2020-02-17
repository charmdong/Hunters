package com.foodhunter.study6;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ18429_근손실_전혜인 {
	static int N;
	static int K;
	static int[] weight;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		weight = new int[N];
		
		for(int n=0;n<N;n++) {
			weight[n] = sc.nextInt();
		}
		
		LinkedList<Integer> arr = new LinkedList<Integer>();
		
		boolean visited[] = new boolean[N];
		Permutation(N,N,arr,visited); //순열로 운동 키트를 사용하는 모든 경우의 수 찾아냄
		System.out.println(cnt);

	}
	
	public static void Permutation(int n, int r, LinkedList<Integer> arr, boolean visited[]) {
		if(arr.size() == r) {
			//한가지 순열이 완성되었을 떄, 만약 하루라도 중량이 500미만으로 내려가는 날이 있으면 return;
			if(!checkWeight(arr, 500)) return;
			cnt++; //없으면 cnt를 증가
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]==false) {
				arr.add(i);
				visited[i]=true;
				Permutation(n,r,arr,visited);
				visited[i]=false;
				arr.removeLast();
			}
		}
		
	}

	//중량이 500보다 작아지지 않으면 true, 작아지면 false 리턴
	private static boolean checkWeight(LinkedList<Integer> arr, int DayWeight) {
		for(int i=0;i<arr.size();i++) {
			DayWeight = DayWeight - K + weight[arr.get(i)];
			if(DayWeight<500)
				return false;
		}
		return true;
		
	}

}
