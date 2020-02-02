package _200201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2161_Card1 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Queue queue = new LinkedList(); // queue ���·� ����

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {

			queue.offer(i); // offer = ��������

		}

		while (!queue.isEmpty()) {

			Object out = queue.poll(); // poll = ������� ������ �� ������ ��ȯ

			System.out.print(out + " ");

			if (queue.isEmpty()) // ����ִ��� �Ǻ�

				break;

			Object in = queue.poll(); // �ι�° �� ������

			queue.offer(in); // �ڿ� �ٽ� ����.
			
		}

	}

}
