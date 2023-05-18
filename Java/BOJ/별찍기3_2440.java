import java.util.Scanner;

public class º°Âï±â3_2440 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			for(int j=num; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
