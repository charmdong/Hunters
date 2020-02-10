import java.util.Arrays;
import java.util.Scanner;

public class Main_B2999_비밀이메일_전혜인 {
	static int N;
	static int R,C;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] secret = sc.next().toCharArray();
		
		N = secret.length;
		int index=0;
		findRC();
		arr = new char[R][C];
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				arr[j][i]=secret[index++];
			}
		}

		readMessage();
	}
	
	private static void readMessage() {
		//int Column = 0;
		for(int i=0;i<R;i++) {
			//System.out.print(i+"�� "+Column+"��");
			for(int j=0;j<C;j++)
				System.out.print(arr[i][j]);
		}
	}

	//R�� C�� ã�� �޼���
	private static void findRC() {
		R=1;
		C=N;
		int c=N;
		while(true) {
			if(N%c==0){
				if(N/c>c) return;
				C=c;
				R=N/c;
			}
			c--;
		}
		
	}

}
