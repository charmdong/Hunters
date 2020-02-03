package Study3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//카드1

public class BJ2161_카드1_유지민 {
	static Queue<Integer> card = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// card 생성
		for (int i = 1; i <= N; i++)
			card.add(i);

		while (card.peek() != null) {
			throwCard();
		}
	}

	private static void throwCard() {
		System.out.print(card.poll() + " ");
		card.add(card.poll());
	}
}
