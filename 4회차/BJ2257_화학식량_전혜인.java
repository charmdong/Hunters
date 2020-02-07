import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BJ2257_화학식량_전혜인 {
	static char[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.next().toCharArray();
		int size = input.length;
		
		int sumC=0;
		int sumH=0;
		int sumO=0;
		
		int[] sum = new int[3];
		
		sum = fomula(0,size);


		
		System.out.println((sum[1]*12) + (sum[0]*16) + (sum[2]*1));

	}
	
	static int i=0;

	private static int[] fomula(int start, int size) {
		
		int[] result = new int[3]; //OCH순서
		int[] sub = new int[3];
		for(;i<size;i++) {
			switch(input[i]) {
			case 'O':
				result[0]++;
				break;
			case 'C':
				result[1]++;
				break;
			case 'H':
				result[2]++;
				break;
			case '(':
				i++;
				sub = fomula(i,size);
				result[0]+=sub[0];
				result[1]+=sub[1];
				result[2]+=sub[2];
				break;
			case ')':
				return result;
			default:
				if(input[i-1]==')') {
					result[0]=result[0]-sub[0]+(sub[0]*Character.getNumericValue(input[i]));
					result[1]=result[1]-sub[1]+(sub[1]*Character.getNumericValue(input[i]));
					result[2]=result[2]-sub[2]+(sub[2]*Character.getNumericValue(input[i]));
				}
				else {
					switch(input[i-1]) {
					case 'O':
						result[0]=result[0]-1+Character.getNumericValue(input[i]);
						break;
					case 'C':
						result[1]=result[1]-1+Character.getNumericValue(input[i]);
						break;
					case 'H':
						result[2]=result[2]-1+Character.getNumericValue(input[i]);
						break;
					default:
						break;
				}
			}
		}
	}
		return result;
	}
}