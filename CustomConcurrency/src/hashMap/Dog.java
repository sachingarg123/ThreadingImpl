package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dog {
	public String name;
	
	public Dog(String n){
		this.name=n;
	}

	@Override
	public int hashCode() {
		
		return name.length();
	}

	@Override
	public boolean equals(Object obj) {
	if((obj instanceof Dog) && ((Dog)obj).name==name){
		return true;
	}
		else{
			return false;
		}
		
	}
	
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}*/
	public static void main(String arg[]){
		
		Dog d1 = new Dog("clover");
		Map<Dog,String> m = new HashMap<Dog,String>();
		m.put(d1, "My Dog");
		/*Iterator<Entry<Dog, String>> it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Dog,String> entry = (Map.Entry<Dog, String>)it.next();
			System.out.println(entry.getKey().toString());
			System.out.println(entry.getValue());
		}*/
		System.out.println(m.get(d1));
		
		d1.name="mangolia";
		Iterator<Map.Entry<Dog, String>> it1 = m.entrySet().iterator();
		while(it1.hasNext()){
			Map.Entry<Dog,String> entry = (Map.Entry<Dog, String>)it1.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(m.get(d1));
		
		d1.name="arthur";
		System.out.println(m.get(new Dog("arthur")));
		
	}
	
	}
	
	
