import java.util.Scanner;

public class BJ2979_트럭주차_전혜인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] time = new int[101]; //1~100������ �ð�
		for(int i=0;i<3;i++) {
			int arrive = sc.nextInt();
			int depart = sc.nextInt();
			for(int j=arrive;j<depart;j++)
				//�ش� �ð��� ����� Ʈ���� �����Ǿ����� �˱� ���� ������ �ð�, �����ð������� ��� �ð��� +1����
				time[j]++;
		}

		cost(A,B,C,time);
	}

	private static void cost(int A, int B, int C, int[] time) {
		int totalCost = 0;
		for(int i=1;i<101;i++) {
			//i�ÿ� ��� �� �־����� * �ش� ����� �ݾ��� ���ؼ� �� ������뿡 ������
			switch(time[i]) {
			case 1:
				totalCost = totalCost + A;
				break;
			case 2:
				totalCost = totalCost + 2*B;
				break;
			case 3:
				totalCost = totalCost + 3*C;
				break;
			default:
				break;
			}
		}
		System.out.println(totalCost);
		
	}

}
