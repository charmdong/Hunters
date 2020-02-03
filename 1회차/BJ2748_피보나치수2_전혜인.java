import java.util.Scanner;

public class BJ2748_피보나치수2_전혜인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==0) {
			System.out.println(0);
			return;
		}
		if(n==1) {
			System.out.println(1);
			return;
		}
		long a1 = 0;
		long a2 = 1;
		long tmp;
		for(int i=2;i<=n;i++) {
			tmp = a1+a2;
			a1=a2;
			a2=tmp;
		}
		System.out.println(a2);
	}
}