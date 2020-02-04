package _200201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_5397_키로거 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br 생성
		StringBuilder sb = new StringBuilder(); // sb (문자열) 생성
		int n = Integer.parseInt(br.readLine()); // int형변환

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Deque<Character> preFix = new ArrayDeque<>(); // 앞쪽 Deque
			Deque<Character> postFix = new ArrayDeque<>();// 뒤쪽 Deque

			for (int j = 0, len = s.length(); j < len; j++) {
				char c = s.charAt(j);
				switch (c) {
				case '<':
					if (!preFix.isEmpty()) // not null
						postFix.addFirst(preFix.pollLast()); // 앞 Deque의 뒷요소 삭제하면서 뒷 Deque 앞에 삽입
					break;
				case '>':
					if (!postFix.isEmpty()) // not null
						preFix.addLast(postFix.pollFirst()); // 뒷 Deque의 앞요소 삭제하면서 앞 Deque 뒤에 삽입
					break;
				case '-':
					if (!preFix.isEmpty())	// 앞 Deque가 not null 일때 뒷요소 삭제
						preFix.pollLast();
					break;
				default:
					preFix.add(c);
				}
			}

			while (!preFix.isEmpty()) // null이 아닐때
				sb.append(preFix.pollFirst());
			while (!postFix.isEmpty()) // null이 아닐때
				sb.append(postFix.pollFirst());
			sb.append("\n"); // 두 개의 deque를 더한 후 개행.
		}

		System.out.println(sb);
	}
}