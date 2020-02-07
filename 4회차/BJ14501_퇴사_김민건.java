package _200203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_퇴사_김민건 {

	static int N, max;
	static int[] Ti;
	static int[] Pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		N = Integer.parseInt(br.readLine());
		Ti = new int[N];
		Pi = new int[N];
		for (int test = 0; test < N; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Ti[test] = Integer.parseInt(st.nextToken()); // day
			Pi[test] = Integer.parseInt(st.nextToken()); // money
		}
		schedule(0, 0); // 호출
		System.out.println(max);
	}

	public static void schedule(int day, int money) {

		// 기저 조건
		if (day >= N) {
			max = Math.max(max, money); // static max를 비교
			return;
		}

		if (day + Ti[day] <= N) {
			schedule(day + Ti[day], money + Pi[day]); // 당일 상담을 하는 경우
		}
		schedule(day + 1, money); // 다음날 상담을 하는 경우

	}

}
