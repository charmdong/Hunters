import java.util.Scanner;

public class Main_B2606_바이러스_전혜인 {

	static int comNum;
	static int connectNum;
	static boolean[][] connectArr;
	static boolean[] visited;
	static int cnt=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		comNum = sc.nextInt();
		connectNum = sc.nextInt();
		connectArr = new boolean[comNum+1][comNum+1];
		
		for(int i=0;i<connectNum;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			connectArr[a][b] = true;
			connectArr[b][a] = true;
		}
		visited = new boolean[comNum+1];
		System.out.println(Virus(1)-1);
	}

	private static int Virus(int index) {
		cnt++;
		visited[index]=true;
		
		for(int i=1;i<=comNum;i++) {
			if(connectArr[index][i] && !visited[i])
				Virus(i);
		}
		
		return cnt;
	}

}
