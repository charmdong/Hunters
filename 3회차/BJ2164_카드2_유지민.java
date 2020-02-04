package Study3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//카드2

public class BJ2164_카드2_유지민{
	static Queue<Integer> card = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++)
			card.add(i);

		while (card.size() != 1) {
			throwCard();
		}
		System.out.println(card.poll());
	}

	private static void throwCard() {
		card.poll();
		card.add(card.poll());
	}
}
