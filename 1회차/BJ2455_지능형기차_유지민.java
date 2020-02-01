package Study;
import java.util.Scanner;

public class BJ2455_지능형기차_유지민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] max = new int[4];
		int maxP = 0;
		int in;
		int out;
		for(int i=0;i<4;i++)
		{
			out = sc.nextInt();
			maxP = maxP - out;
			in = sc.nextInt();
			maxP = maxP + in;
			max[i] = maxP;
		}
		maxP = 0;
		for(int i=0;i<4;i++)
		{
			if(max[i]>maxP)
				maxP = max[i];
		}
		System.out.println(maxP);
	}
}
