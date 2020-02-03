import java.util.Scanner;

public class BJ2455_지능형기차_전혜인 {
	public static void main(String[] args) {
		int people=0;
		Scanner sc = new Scanner(System.in);
		int in;
		int out;
		int max=0;
		sc.nextInt();
		people=sc.nextInt();
		max=people;
		for(int i=2;i<5;i++) {
			people-=sc.nextInt();
			people+=sc.nextInt();
			if(max<people)
				max=people;
		}
		System.out.println(max);
	}

}
