import java.math.BigInteger;
import java.util.Scanner;

public class Main_B1914_하노이탑_전혜인 {
	static int N; 
	static BigInteger k; //옮긴 횟수
	static int k_under20;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		k_under20 = 0;
		k= new BigInteger("2");
		System.out.println(k.pow(N).subtract(BigInteger.ONE));
		if(N<=20) {
			moveDisk(1, 3, 2, N);		
		}
			
			
	}
	
	//n-1개의 원반을 모두 noneStack으로 옮기고 마지막 원반을 toStack에 옮긴다.
	//그 후 n-1개의 원반을 모두 noneStack -> toStack으로 옮긴다.

	private static void moveDisk(int from, int to, int tmp, int height) {
		if(height<=1) {
			System.out.println(from+" "+to);
			return;
		}
		moveDisk(from, tmp, to, height-1);
		System.out.println(from+" "+to);
		moveDisk(tmp, to, from, height-1);
		
	}

}
