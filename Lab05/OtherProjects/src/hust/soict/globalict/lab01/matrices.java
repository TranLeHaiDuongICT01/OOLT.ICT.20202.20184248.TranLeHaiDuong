package hust.soict.globalict.lab01;
import java.util.Scanner;
public class matrices {
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		System.out.println("Input number of rows:");
		int row=key.nextInt();
		System.out.println("Input number of columns:");
		int col=key.nextInt();
		int[][] a=new int[row][col];
		int[][] b=new int[row][col];
		System.out.println("Input matrix a:");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				a[i][j]=key.nextInt();
			}
		}
		System.out.println("Input matrix b:");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				b[i][j]=key.nextInt();
			}
		}
		System.out.println();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		key.close();
	}
}
