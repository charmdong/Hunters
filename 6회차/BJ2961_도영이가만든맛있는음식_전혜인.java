package com.foodhunter.study6;
import java.util.Scanner;

public class BJ2961_도영이가만든맛있는음식_전혜인 {
	static int min=1000000;
	static int N;
	static int[] bitter;
	static int[] sour;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];
		for(int n=0;n<N;n++) {
			sour[n] = sc.nextInt();
			bitter[n] = sc.nextInt();
		}
		
		//신맛은 곱, 쓴맛은 합
		//조합방법으로 i번째 재료 선택한 경우, 선택안한 경우
		for(int i=0;i<N;i++) {
			SelectIngredient(i, 1, 0);
		}

		System.out.println(min);
	}
	
	private static void SelectIngredient(int i, int s, int b) {
		int diff;
		if(b!=0) {
			diff = Math.abs(s-b);
			if(diff<min) {
				min = diff;
			}
		}
		if(i+1<N)
			SelectIngredient(i+1, s, b); //선택 안하고 넘기는 경우
		
		//선택 하는 경우
		s = s * sour[i];
		b = b + bitter[i];
		diff = Math.abs(s-b);
		if(diff<min) {
			min = diff; //현재 선택으로 둘의 차이가 최소가 됨
		}

		if(i+1<N)
			SelectIngredient(i+1,s,b); //선택한 값을 넘김
		
	}

}
