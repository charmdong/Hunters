import java.util.Scanner;

public class BJ5532_¹æÇÐ¼÷Á¦_ÀüÇýÀÎ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L=sc.nextInt();
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int D=sc.nextInt();
		
		int korean;
		int math;
		
		if(A%C==0) {
			korean=A/C;
		}else {
			korean=A/C+1;
		}
		
		if(B%D==0) {
			math=B/D;
		} else {
			math=B/D+1;
		}
		
		if(math>korean)
			L=L-math;
		else
			L=L-korean;
		
		System.out.println(L);
	}

}
