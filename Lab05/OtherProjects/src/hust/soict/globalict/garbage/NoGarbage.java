package hust.soict.globalict.garbage;
public class NoGarbage {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		StringBuffer s = new StringBuffer();
		for(long v=0;v<1000000;v++) {
			s.append('1');
		}
		System.out.println(System.currentTimeMillis()-start);
	}
}
