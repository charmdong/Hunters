import java.util.Scanner;

public class BJ1476_날짜계산_전혜인 {

	public static void main(String[] args) {
		int earth, sun, moon;
		Scanner sc = new Scanner(System.in);
		earth = sc.nextInt();
		sun = sc.nextInt();
		moon = sc.nextInt();

		int year=1;
		while(true) {
			if((year-earth)%15==0 && (year-sun)%28==0 && (year-moon)%19==0) {
				System.out.println(year);
				return;
			}
			year++;
		}

	}
	

}
