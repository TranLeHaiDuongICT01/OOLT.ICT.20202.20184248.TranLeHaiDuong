package hust.soict.globalict.test.disc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.media.Book;

public class BookTest {
	public static void main(String[] args) {
		Book bk = new Book("Hello");
		bk.setContent("But I know. I word For I For example, the word \"can\'t\" should");
//		List<String> contentTokens = new ArrayList<String>();
//		String Text = "But I know. For example, the word \"can\'t\" should";
//		System.out.println(Text);
//		String[] Res = Text.split("[\\p{Punct}\\s]+");
//		System.out.println(Res.length);
//		for (String s:Res){
//			contentTokens.add(s);
//		}
//		System.out.println(contentTokens);
//		Collections.sort(contentTokens);
//		System.out.println(contentTokens);
		System.out.println(bk.getContent());
		bk.processContent();
	}
}
