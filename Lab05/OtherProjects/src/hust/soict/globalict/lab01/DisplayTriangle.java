package hust.soict.globalict.lab01;
import java.util.Scanner;
public class DisplayTriangle{
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		System.out.println("Input n: ");
		int n=key.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<n-i+1;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=2*(i-1)+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		key.close();
	}
}