import java.util.Arrays;
import java.util.Scanner;

public class BJ10819_차이를최대로_전혜인 { // 완탐으로 수정하기
	static int N;
	static int[] input;
	
	static int first;
	static int last;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);
		
		//두번 해주는 이유, N이 짝수냐 홀수냐에 따라 달라짐
		//if로 짝수홀수 안하고 두번 다 하는 이유 : 반례 (1 9 2)답이 15인데 9가 나옴

		first = N / 2 - 1;
		last = N / 2;

		int result1 = Calculate(0, N - 1);

		first = N / 2;
		last = N / 2 + 1;

		int result2 = Calculate(0, N - 1);
		if (result1 > result2)
			System.out.println(result1);
		else
			System.out.println(result2);
	}

	private static int Calculate(int min, int max) {
		int[] Arr = new int[N];
		boolean minValueFirst = true;
		while (true) {
			if (min > max)
				break;
			if (minValueFirst) {
				if (first >= 0) {
					Arr[first--] = input[min++];
				}
				if (last <= N - 1) {
					Arr[last++] = input[max--];
				}
			} else {
				if (first >= 0) {
					Arr[first--] = input[max--];
				}
				if (last <= N - 1) {
					Arr[last++] = input[min++];
				}
			}
			minValueFirst = !minValueFirst;
		}
		int Max_Diff = 0; // 차이의 최대값 저장
		for (int i = 1; i < N; i++) {
			Max_Diff += Math.abs(Arr[i] - Arr[i - 1]);
		}
		return Max_Diff;
	}

}
