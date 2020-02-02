package _200201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_5397_Ű�ΰ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br ����
		StringBuilder sb = new StringBuilder(); // sb (���ڿ�) ����
		int n = Integer.parseInt(br.readLine()); // int����ȯ

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Deque<Character> preFix = new ArrayDeque<>(); // ���� Deque
			Deque<Character> postFix = new ArrayDeque<>();// ���� Deque

			for (int j = 0, len = s.length(); j < len; j++) {
				char c = s.charAt(j);
				switch (c) {
				case '<':
					if (!preFix.isEmpty()) // not null
						postFix.addFirst(preFix.pollLast()); // �� Deque�� �޿�� �����ϸ鼭 �� Deque �տ� ����
					break;
				case '>':
					if (!postFix.isEmpty()) // not null
						preFix.addLast(postFix.pollFirst()); // �� Deque�� �տ�� �����ϸ鼭 �� Deque �ڿ� ����
					break;
				case '-':
					if (!preFix.isEmpty())	// �� Deque�� not null �϶� �޿�� ����
						preFix.pollLast();
					break;
				default:
					preFix.add(c);
				}
			}

			while (!preFix.isEmpty()) // null�� �ƴҶ�
				sb.append(preFix.pollFirst());
			while (!postFix.isEmpty()) // null�� �ƴҶ�
				sb.append(postFix.pollFirst());
			sb.append("\n"); // �� ���� deque�� ���� �� ����.
		}

		System.out.println(sb);
	}
}