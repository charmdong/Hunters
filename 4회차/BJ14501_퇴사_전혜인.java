import java.util.Scanner;

public class BJ14501_ล๐ป็_ภüวýภฮ {

	static int[] t;
	static int[] p;
	static int n;
	static int max=0;
	
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n+1];
		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
//		
//		for(int i=0;i<n;i++) {
//			comb(visited,0,0,0);
//		}
//		
		comb(1,0);
		
		System.out.println(max);
	}
	
	private static void comb(int index, int totalMax) {
		if(index>n) return;
		if(index+t[index]<=n+1) { 
			if(totalMax+p[index] > max) max=totalMax+p[index];
			comb(index+t[index], totalMax+p[index]);
		}
		if(index+1<=n+1) {
			comb(index+1, totalMax);
		}
		
	}

}
