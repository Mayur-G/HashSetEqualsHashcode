import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		//works
		Set<Integer> hs = new HashSet<>();
		
		System.out.println(hs.add(101));
		System.out.println(hs.add(102));
		System.out.println(hs.add(103));
		System.out.println(hs.add(101)); //false , set doesn't add duplicates
		System.out.println();
		
		//odd behaviour , not working for custom class 
		//but if we both override equals() and hashcode() methods in Person class, it works 
		Set<Person> hs1 = new HashSet<>();
		System.out.println(hs1.add(new Person(1, "mike")));
		System.out.println(hs1.add(new Person(2, "lucy")));
		System.out.println(hs1.add(new Person(1, "mike"))); //should return false , but its returning true
		System.out.println();
		
		//initially false
		//but for equal values , it should return true
		//so override only equals() method  in Person class
		Person p1 = new Person(11, "mike");
		Person p2 = new Person(11, "mike");
		System.out.println("p1.equals(p2) : "+p1.equals(p2));
		System.out.println();
		
		System.out.println(new String("abc").hashCode());
		System.out.println(new String("abc").hashCode());
	
		//initially p3 and p4 hashcode will be different
		//so override only hashcode() method  in Person class
		//p3 and p4 hashcode will be same
		Person p3 = new Person(11, "mike");
		Person p4 = new Person(11, "mike");
		System.out.println(p3.hashCode()+"  "+p4.hashCode());
		System.out.println();
		
		
		Voter v1 = new Voter("Abhilash",101);
		Voter v2 = new Voter("Abhilash",101);
		Voter v3 = new Voter("Abhilash",101);
		Map<Voter ,Integer> map = new HashMap<>();
		map.put(v1,30);
		map.put(v2,40);
		System.out.println(map); 
		//if we dont override equals hashcode or only one of them we get 30 and 40 
		//if we override both equals hashcode we get 40 and 40
		System.out.println(map.get(v1)); 
		System.out.println(map.get(v2));

}
}
