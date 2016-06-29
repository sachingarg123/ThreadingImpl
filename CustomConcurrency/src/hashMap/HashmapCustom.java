package hashMap;


public class HashmapCustom<K,V> {

private Entry<K,V>[] table;
private int capacity=4;

static class Entry<K,V>{
	K key;
	V value;
	Entry<K,V> next;
	
	public Entry(K key,V value,Entry<K,V> next){
		this.key=key;
		this.value=value;
		this.next=next;
	}
}

@SuppressWarnings("unchecked")
public HashmapCustom(){
	table = new Entry[capacity];
}

public void put(K newKey, V value){
	if(newKey==null){
		return;
	}
	int hash=hash(newKey);
	Entry<K,V> newEntry = new Entry<K,V>(newKey, value, null);
	
	if(table[hash]==null){
		table[hash]=newEntry;
	}else{
		Entry<K,V> previous = null;
        Entry<K,V> current = table[hash];
        
        while(current!=null){
        	if(current.key.equals(newKey)){
        		if(previous==null){
        			newEntry.next=current.next;
        			table[hash]=newEntry;
        			return;
        		}else{
        		newEntry.next = current.next;
        		previous.next = newEntry;
        		}
        	}else{
        		previous=current;
        		current = current.next;
        	}
        previous.next = newEntry;	
        }
	}
}



private int hash(K key){
    return Math.abs(key.hashCode()) % capacity;
}


}
