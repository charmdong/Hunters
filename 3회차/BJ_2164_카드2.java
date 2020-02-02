package _200201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164_ī��2 {

	private static Scanner sc = new Scanner(System.in);
	static int result;

	public static void main(String[] args) {
		Queue queue = new LinkedList(); // queue ���·� ����

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {

			queue.offer(i); // offer = ��������

		}

		while (!queue.isEmpty()) {

			Object out = queue.poll(); // poll = ������� ������ �� ������ ��ȯ
			result = (int) out;
			

			if (queue.isEmpty()) // ����ִ��� �Ǻ�

				break;

			Object in = queue.poll(); // �ι�° �� ������

			queue.offer(in); // �ڿ� �ٽ� ����.

		}
		System.out.print(result);
	}

}
