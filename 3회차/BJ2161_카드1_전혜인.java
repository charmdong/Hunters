import java.util.Scanner;
import java.util.ArrayDeque;

public class BJ2161_카드1_전혜인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayDeque<Integer> card = new ArrayDeque<>();

		for(int i=0;i<n;i++) {
			card.offer(i+1);
		}
		
		while(card.size()>1) {
			System.out.println(card.pop());
			card.offer(card.peek());
			card.pop();
		}
		System.out.println(card.pop());
	}

}