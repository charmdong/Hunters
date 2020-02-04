import java.util.Scanner;

public class BJ2798_ºí·¢Àè_ÀüÇıÀÎ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] card = new int[n];
		for(int i=0;i<n;i++) card[i] = sc.nextInt();
		
		int size=0;
		for(int i=1;i<n;i++) size+=i;
		int[][] arr = new int[size][2];
		
		int p=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				arr[p][0]=i;
				arr[p][1]=j;
				p++;
			}
		}
		
		int max_m = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<n;j++) {
				if(j!=arr[i][0] && j!=arr[i][1]) {
					if(card[arr[i][0]] + card[arr[i][1]] + card[j] <= m)
						if(card[arr[i][0]] + card[arr[i][1]] + card[j] > max_m)
							max_m=card[arr[i][0]] + card[arr[i][1]] + card[j];
				}
			}
		}
		System.out.println(max_m);
	}

}
