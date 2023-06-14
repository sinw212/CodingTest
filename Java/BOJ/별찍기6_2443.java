import java.util.Scanner;

public class º°Âï±â6_2443 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=num*2-1; k>i*2; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
