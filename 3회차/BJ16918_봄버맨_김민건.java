package _200201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ16918_������_��ΰ� {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // �Է�
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ���
		StringTokenizer st = new StringTokenizer(br.readLine()); // ������ �������� ���ʸ�

		int R, C, N;
		R = Integer.parseInt(st.nextToken()); // ��
		C = Integer.parseInt(st.nextToken()); // ��
		N = Integer.parseInt(st.nextToken()); // ��
		int[][] map = new int[R][C]; // ��
		int time = 0;
		// ��Ÿ
		int[] drow = { -1, 1, 0, 0 }; // �� �� �� ��
		int[] dcol = { 0, 0, -1, 1 }; // �� �� �� ��

		// �ʱ� ��ź ��ġ
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray(); // char������ �޴´�
			for (int j = 0; j < C; j++) {
				if (input[j] == '.') {
					map[i][j] = 0; // ��ĭ
				} else {
					map[i][j] = 1; // ��ź
				}

			} // end of for(j)

		} // end of for(i)

		// ������ ���� ���ϱ�
		for (int k = 0; k < N; k++) {
			time++;
			// ���� ������ ����
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {	// ��ź�� ����ִ� ĭ
						
					}
				}
			}
		}

	}

}
