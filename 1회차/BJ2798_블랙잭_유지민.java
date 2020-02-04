package Study;
import java.util.Scanner;

public class BJ2798_블랙잭_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,M;
		N = sc.nextInt();
		M = sc.nextInt();
		int[] card = new int[N];
		int max = 0;
		
		for(int i=0;i<N;i++)
		{
			card[i] = sc.nextInt();
		}
		
		for(int i=0;i<N-2;i++)
		{
			for(int j=i+1;j<N-1;j++)
			{
				for(int k=j+1;k<N;k++)
				{
					int sum = card[i] +card[j]+card[k];
					if(sum<=M&&max<sum)
						max = sum;
				}
			}
		}
		System.out.println(max);
	}

}
