import java.util.Scanner;

public class BJ16918_º½¹ö¸Ç_ÀüÇýÀÎ {

	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int r;
	static int c;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		n = sc.nextInt();
		
		map = new char[r][c];
		
		for(int i=0;i<r;i++) {
			String s = sc.next();
			for(int j=0;j<c;j++) {
				char a = s.charAt(j);
				if(a=='O') {
					map[i][j]=Character.forDigit(0, 10);
				}
					
				else
					map[i][j]=a;
			}
		}

		for(int i=2;i<=n;i++)
			bomb(i);
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='.') System.out.print(map[i][j]);
				else System.out.print("O");
			}
			System.out.println();
		}

	}
	private static void bomb(int time) {
		//Â¦¼öÃÊ: ÆøÅº ¼³Ä¡   È¦¼öÃÊ: ÆøÅº ÅÍÁü
		if(time%2==0) {
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(map[i][j]=='.') {
						map[i][j]=Character.forDigit(time%10, 10);
					}
				}
			}
		} else {
			int nextx=0;
			int nexty=0;
			int bombTime = (time-3)%10;
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					
					if(map[i][j]=='.') continue;
					if(map[i][j]==Character.forDigit(bombTime, 10)) {
						for(int k=0;k<4;k++) {
							nexty=i+dx[k];
							nextx=j+dy[k];
							if(nextx<0 || nexty<0 || nextx>=c || nexty>=r) continue;
							if(map[nexty][nextx]!=Character.forDigit(bombTime, 10))
								map[nexty][nextx]='.';
						}
						map[i][j]='.';
					}
				}
			}
		}

		time+=1;
	}

}
