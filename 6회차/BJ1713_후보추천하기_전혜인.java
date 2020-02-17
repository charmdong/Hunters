package com.foodhunter.study6;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1713_후보추천하기_전혜인 {
	static int pictureNum;
	static int recommendNum;
	
	//[후보번호, 추천수, 들어온 시간]
	static class rec{
		int num; //추천받은 학생번호
		int cnt; //추천수
		int t; //들어온 시간


		public rec(int num, int cnt, int t) {
			this.num = num;
			this.cnt = cnt;
			this.t = t;
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pictureNum = sc.nextInt();
		recommendNum = sc.nextInt();
		
		int index=0; // 현재 걸린 액자 수(배열에 넣은 학생 수)
		
		rec recommendArr[] = new rec[pictureNum];
L:		for(int t=0;t<recommendNum;t++) {
			//후보가 배열에 있는지 확인
			int now = sc.nextInt(); //현재 추천받은 학생 번호
			for(int i=0;i<index;i++) {
				if(now == recommendArr[i].num) {
					//추천 수 증가
					recommendArr[i].cnt++;
					continue L; //다음 추천 받음
				}
			}
			
			//추천받은 학생이 현재 배열에 없는 경우	
			//액자의 수가 다 차지 않았으면 배열에 넣어줌
			if(index!=pictureNum) {
				recommendArr[index] = new rec(now,0,t);
				index++;
				continue L;
			}
			
			//액자의 수가 다 찼으면 제일 추천수가 작은 후보 제거하고 넣어줌(같은 후보가 있으면 오래된 후보 제거)
			int minIndex=0;
			for(int i=1;i<index;i++) {
				if(recommendArr[i].cnt<recommendArr[minIndex].cnt) {
					minIndex=i;
				}
				if(recommendArr[i].cnt==recommendArr[minIndex].cnt) {
					if(recommendArr[i].t<recommendArr[minIndex].t) {
						minIndex=i;
					}
				}
			}
			

			recommendArr[minIndex] = new rec(now,0,t);
			continue L;
		}
		
		//최종 후보들의 번호만 따로 저장해서 정렬
		int finalCand[] = new int[pictureNum];
		for(int i=0;i<pictureNum;i++) {
			finalCand[i] = recommendArr[i].num;
		}
			
		Arrays.sort(finalCand);
		
		for(int i=0;i<pictureNum;i++)
			System.out.print(finalCand[i]+" ");
	}

}
