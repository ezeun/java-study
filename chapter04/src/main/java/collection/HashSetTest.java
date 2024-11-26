package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String str = new String("마이콜");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");
		s.add(str); //안들어감
		
		System.out.println(s.size());
		System.out.println(s.contains(str)); //값으로 비교
	
		//순회
		for(String str2 : s) {
			System.out.println(str2);
		}
	}

}