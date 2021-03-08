package lesson2;
public class Lesson2 {

	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		for(int i:a) {
			System.out.println(i);
		}
	}
}
