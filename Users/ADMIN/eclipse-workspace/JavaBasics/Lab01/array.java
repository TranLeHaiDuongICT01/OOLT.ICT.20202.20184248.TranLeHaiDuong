
import java.util.Scanner;
public class array{
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		System.out.println("Input number of array:");
		int n=key.nextInt();
		double[] array=new double[n];
		System.out.println("Input elements of the array:");
		for(int i=0;i<n;i++) {
			array[i]=key.nextInt();
		}
		double sum=0;
		double average;
		System.out.println("Array before sorted:");
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
			sum+=array[i];
		}
		System.out.println();
		average=sum/(n/1.00f);
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(array[i]>array[j]) {
					double temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		System.out.println("Array after sorted:");
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("The sum of the array is: "+sum);
		System.out.println("The average value of the array is: "+average);
		key.close();
	}
}