import java.util.Arrays;
import java.util.Scanner;

public class BJ1547_공_전혜인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] change = new int[n][2];
		int[] cup = new int[4];
		for(int i=1;i<=3;i++) {
			cup[i]=i;
		}
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int a_index = 0, b_index = 0;
			for(int j=1;j<=3;j++) {
				//컵의 위치 찾기
				if(cup[j] == a) a_index=j;
				if(cup[j] == b) b_index=j;
			}
			
			cup[a_index]=b;
			cup[b_index]=a;
						
		}
		System.out.println(cup[1]);

	}

}
