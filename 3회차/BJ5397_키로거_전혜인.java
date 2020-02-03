import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ5397_키로거_전혜인 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] result;
		int T = bf.read();
		for(int t=0;t<T;t++) {
			StringBuilder sb = new StringBuilder();
			sb.append(bf.readLine());
			//StringTokenizer stk = new StringTokenizer(sb);
			String[] input = sb.split("");
			
			Deque<String> pw = new ArrayDeque<String>();
			Deque<String> pw2 = new ArrayDeque<String>();
			
			for(int i=0;i<input.length;i++) {
				if(input[i].equals("<")) {
					if(pw.size()>0) {
						pw2.addFirst(pw.peekLast());
						pw.removeLast();

					}
				} else if(input[i].equals(">")) {
					if(pw2.size()>0) {
						pw.addLast(pw2.peekFirst());
						pw2.removeFirst();
					}
				} else if(input[i].equals("-")) {
					if(pw.size()>0) {
						pw.removeLast();
					}
				} else {
					pw.addLast(input[i]);
				}
			}
			for(int i=0;i<pw2.size();i++) {
				pw.addLast(pw2.peekFirst());
				pw2.removeFirst();
			}
			for(String k:pw) {
				System.out.printf("%s",k);
			}
			
		}
	}
}
