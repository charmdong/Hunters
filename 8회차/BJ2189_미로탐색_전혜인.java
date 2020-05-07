import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2189_미로탐색_전혜인 {
	static int N,M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int n=0;n<N;n++) {
			char[] tmp = br.readLine().toCharArray();
			for(int m=0;m<M;m++) {
				map[n][m] = Character.getNumericValue(tmp[m]);
			}
		}
		
		bfs();
		
	}
	
	static class Point{
		int r,c;
		int cnt;
		public Point(int r, int c, int cnt) {
			this.r=r;
			this.c=c;
			this.cnt=cnt;
		}
	}
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		queue.add(new Point(0,0,1));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r==N-1 && p.c==M-1) {
				System.out.println(p.cnt);
				return;
			}
			for(int d=0;d<4;d++) {
				int nr = p.r+dy[d];
				int nc = p.c+dx[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc])
					continue;
				if(map[nr][nc]==1) {
					queue.add(new Point(nr,nc,p.cnt+1));
					visited[nr][nc] = true;
				}
			}
		}
		
	}

}
