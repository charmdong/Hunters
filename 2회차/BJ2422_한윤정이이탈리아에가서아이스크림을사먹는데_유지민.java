package Study;
//2422

import java.util.Scanner;
public class BJ2422_한윤정이이탈리아에가서아이스크림을사먹는데_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N,M,count =0;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		for(int i=0;i<M;i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
		}
		
		for(int i=1;i<=N;i++)
		{
			for(int j = i+1;j<=N;j++)
			{
				for(int k = j+1;k<=N;k++)
				{
					if(arr[i][j]!=1&&arr[j][i]!=1&&arr[i][k]!=1&&arr[k][i]!=1&&arr[j][k]!=1&&arr[k][j]!=1)
						count++;
				}
			}
		}
		System.out.println(count);
	}
}
