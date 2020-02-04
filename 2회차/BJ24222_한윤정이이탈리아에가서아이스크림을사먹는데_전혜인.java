import java.util.Arrays;
import java.util.Scanner;

public class BJ24222_한윤정이이탈리아에가서아이스크림을사먹는데_전혜인 {

	static int cnt=0;
	static boolean[][] nope;
	static int n,m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nope = new boolean[n+1][n+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			nope[a][b] = true;
			nope[b][a] = true;
		}
		combination();
	}
		
	public static void combination() {
		int cnt=0;
		for(int i=1;i<n+1;i++) {
			for(int j=i+1;j<n+1;j++) {
				if(nope[i][j] || nope[j][i]) {
					continue;
				}
					
				for(int k=j+1;k<n+1;k++) {
					if(nope[k][i] || nope[i][k] || nope[k][j] || nope[j][k]) {
						continue;
					}
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
