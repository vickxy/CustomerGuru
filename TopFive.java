import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

public class TopFive {
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0) 
					return 1;
				else 
					return compare;
			}
	    };
	    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}
	
	public static ArrayList<String> returnFiveElements(String [] words) {

		ArrayList<String> al = new ArrayList<String>();
		Map<String, Integer> count = new HashMap<>();
		for(int i=0; i<words.length; i++) {
			if(!count.containsKey(words[i])) {
				count.put(words[i], 1);
			}else {
				int c = count.get(words[i]) + 1;
				count.put(words[i], c);
			}
		}
		Map<String, Integer> sortedMap = sortByValues(count);
		System.out.println(sortedMap);
		
	    Set<?> set = sortedMap.entrySet();
	    Iterator<?> it = set.iterator();
	    while(it.hasNext()) {
	      @SuppressWarnings("rawtypes")
	      Map.Entry pair = (Map.Entry)it.next();
	      String x = pair.getKey().toString();
	      al.add(x);
	    }
	    Collections.reverse(al);
	    al.subList(5, al.size()).clear();
		
		return al;
	}
	public static void main(String[] args) {
		String [] words = {"AAA","AAA","BBB","BBB","BBB","CC","CC","XXX", "XXX","PP","PP","QQ","XXX","XXX"};
		ArrayList<String> result = returnFiveElements(words);
	    System.out.println(result);
	}

}
