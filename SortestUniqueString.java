package eagle_view_test;

import java.util.ArrayList;
import java.util.TreeMap;

public class SortestUniqueString {

	public static void main(String[] args) {

		String s1 = "ababaabba";
		String s2 = "zyzyzyz";
		String s3 = "aabbbabaaa";

		System.out.println(smallestSubstring(s1));
		System.out.println(smallestSubstring(s2));
		System.out.println(smallestSubstring(s3));
	}

	static int smallestSubstring(String a) {

		ArrayList<String> subStrings = new ArrayList<>();

		for (int i = 0; i < a.length(); i++) {
			for (int j = i + 1; j <= a.length(); j++) {
				if (i != j)
					subStrings.add(a.substring(i, j));
			}
		}

		TreeMap<String, Integer> mapSubStrings = new TreeMap<>();
		subStrings.forEach(e ->mapSubStrings.put(e, mapSubStrings.getOrDefault(e, 0) + 1) );

		ArrayList<String> uniqueSubStrings = new ArrayList<>();		
		mapSubStrings.keySet().stream().filter(s-> mapSubStrings.get(s) == 1).forEach(s -> uniqueSubStrings.add(s));


		TreeMap<String, Integer> mapUniqueSubStrings = new TreeMap<>();
		uniqueSubStrings.forEach(s -> mapUniqueSubStrings.put(s, s.length()));

		ArrayList<Integer> newlist = new ArrayList<>();

		for (String s : mapUniqueSubStrings.keySet())
			newlist.add(mapUniqueSubStrings.get(s));

		int ans = newlist.get(0);

		for (int i : newlist)
			ans = Math.min(ans, i);

		return ans;
	}
}
