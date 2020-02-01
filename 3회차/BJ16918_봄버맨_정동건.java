package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ16918 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, N, bCnt;
    static char[][] board;
    static int[][] bombList;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception{
	String[] cmdList = br.readLine().split(" ");
	
	R = Integer.parseInt(cmdList[0]);
	C = Integer.parseInt(cmdList[1]);
	N = Integer.parseInt(cmdList[2]);
	
	board = new char[R][C];
	bombList = new int[R * C][2];
	
	for(int row = 0; row < R; row++) {
	    String str = br.readLine();
	    
	    for(int col = 0; col < C; col++) {
		char ch = str.charAt(col);
		board[row][col] = ch;
		
		// 초기에 폭탄이 설치된 곳.
		if(ch == 'O') {
		    bombList[bCnt][0] = row;
		    bombList[bCnt++][1] = col;
		}
	    }
	}
	
	solution();
    }
    
    private static void solution() {
	for(int time = 2; time <= N; time++) {
	    if(time % 2 == 0) {
		setBomb();
	    } else {
		explode();
		searchBomb();
	    }
	}
	
	printBoard();
    }
    
    // 폭탄 설치
    private static void setBomb() {
	for(int row = 0; row < R; row++) {
	    for(int col = 0; col < C; col++) {
		if(board[row][col] != 'O') {
		    board[row][col] = 'O';
		}
	    }
	}
    }
    
    // 폭탄 터짐
    private static void explode() {
	for(int index = 0; index < bCnt; index++) {
	    int y = bombList[index][0];
	    int x = bombList[index][1];
	    
	    for(int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		if(isInBoard(ny, nx) && board[ny][nx] == 'O') {
		    board[ny][nx] = '.'; // 4방에 대해서
		}
	    }
	    
	    board[y][x] = '.'; // 자신의 자리
	}
    }
    
    // 다음 터질 폭탄 위치 탐색
    private static void searchBomb() {
	bCnt = 0;
	
	for(int row = 0; row < R; row++) {
	    for(int col = 0; col < C; col++) {
		if(board[row][col] == 'O') {
		    bombList[bCnt][0] = row;
		    bombList[bCnt++][1] = col;
		}
	    }
	}
    }
    
    // 격자 출력
    private static void printBoard() {
	for(int row = 0; row < R; row++) {
	    for(int col = 0; col < C; col++) {
		System.out.print(board[row][col]);
	    }
	    System.out.println();
	}
    }
    
    private static boolean isInBoard(int y, int x) {
	return ((y > -1 && y < R) && (x > -1 && x < C));
    }

}
