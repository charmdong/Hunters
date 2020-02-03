import java.util.Scanner;

public class B_5397_키로거 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			String s = sc.next();
			String[] input = s.split("");
			String[] password = new String[1000000];
			int cursor=0; //현재 커서의 위치
			int top_index=0;
			
			for(int i=0;i<input.length;i++) {
				if(input[i]=="<") {
					if(cursor!=0) {
						cursor-=1;
					}
				}
				else if(input[i]==">") {
					if(cursor!=top_index) {
						cursor+=1;
					}
				}
				/*else if(input[i]=="-") {
					for(int j=cursor-1;j<)
					cursor-=1;
					top_index-=1;
					
				}*/
			}
			
		}

	}

}
