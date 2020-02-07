package Study4;

import java.util.Scanner;

public class BJ2493_탑_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] top = new int[N]; 
		int[] laser = new int[N]; 
		for(int i=0;i<N;i++) //각 탑의 높이 입력 
		{
			top[i] = sc.nextInt();
		}
	
		for(int i=N-1;i>=1;i--)
		{
			for(int j = i-1;j>=0;j--)
			{
				if(top[i]<=top[j])
				{
					laser[i] = j+1;
					break;
				}
			}
		}	
		for(int i = 0;i<N;i++)
		{
			System.out.print(laser[i]+" ");
		}
		System.out.println();
	}
}
