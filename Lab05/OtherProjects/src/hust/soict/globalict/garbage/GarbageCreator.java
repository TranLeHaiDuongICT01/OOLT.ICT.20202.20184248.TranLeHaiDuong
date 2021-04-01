package hust.soict.globalict.garbage;

public class GarbageCreator {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		String s="";
		for(long v=0;v<1000000;v++) {
			s += "1";
		}
		System.out.println(s);
		System.out.println(System.currentTimeMillis()-start);
	}
}
