package com.projectinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {

		 summaryStatsExample();
		collectorsgrpingby();

		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(12);
		numbers.add(5);
		numbers.add(30);
		numbers.add(18);

		List<Integer> numbers2 = Arrays.asList(2, 3, 45, 6, 7, 8, 89, 2);

		// to remove duplicates.
		java.util.Set setList = new HashSet(numbers2);

		System.out.println(setList);

		// **streams cant be consumed twice**
		Stream<Integer> data = numbers.stream();
		/*
		 * map - transforms the data - intermedeiate filter - filters data - terminal
		 * operator adds to list
		 */
		List<Integer> mylist = data.map(x -> x + 10).filter(x -> x % 2 == 0).toList();
		System.out.println(mylist);

		/*
		 * short circuiting terminal operations if any element in a stream doesnot
		 * satify the condition then the process is stopped.other elements are not
		 * evaluated. findAny(),findFirst(),Allmatch(),anyMatch(),noneMatch()
		 */
		// findany- used to findany element is present in a stream. checks a stream is
		// empty and thows error.
		Optional<Integer> num = numbers2.stream().findAny().filter(x -> x % 2 == 0);
		if (num.isPresent()) {
			System.out.println("present: " + num.get());
		}

		/*
		 * duplicate removal in stream using distint.
		 */
		numbers2.stream().distinct().forEach(x -> {
			System.out.println(x);
		});

		/*
		 * find maximum value present in a stream
		 */
		int max = numbers2.stream().max(Integer::compare).get();
		System.out.println("maximum value present: " + max);

		/*
		 * sort using comparator
		 */
		List<Integer> numberlist = Arrays.asList(1, 5, 3, 7, 4, 5);
		Collections.sort(numberlist, intComp);
		System.out.println("sort using comparator  " + numberlist);

		/*
		 * total number of elements
		 */
		long count = numberlist.stream().count();
		System.out.println("count " + count);
		System.out.println("count " + numberlist.size());

		/*
		 * find the first non-repeated character
		 */
		String str = "Pryiyanka";
		System.out.println(str.indexOf("y"));
		System.out.println(str.lastIndexOf("y"));
		// checking first and last occurance are same if yes filter and add it to a list
		Optional<Character> s = str.chars().mapToObj(z -> (char) z).filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
				.findFirst();
		System.out.println(s);

		/*
		 * find the first repeated character
		 */
		String str1 = "Pryiyanka";
		List strlist = str1.chars().mapToObj(z -> (char) z).filter(ch -> str.indexOf(ch) != str.lastIndexOf(ch))
				.collect(Collectors.toList());
		System.out.println(strlist.stream().findFirst());

		/*
		 * sort all values natural order - asc
		 */
		List sorted = numberlist.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);

		/*
		 * sort all values reversr order - desc
		 */
		Stream<Integer> sortedRev = numberlist.stream().sorted(Collections.reverseOrder());
		sortedRev.forEach(System.out::println);

		/*
		 * integer array nums, return true if any value appears at least twice in the
		 * array, and return false if every element is distinct.
		 */
		HashSet hash = new HashSet();
		long hashcount = numberlist.stream().filter(z -> !hash.add(z)).count();
		System.out.println("hashcount " + hashcount);
		if (hashcount > 0) {
			System.out.println("contain : true");
		} else {
			System.out.println("contain : false");
		}

		/*
		 * concat two streams
		 */
		List list1 = Arrays.asList(2, 4, 5, 6, 7, 8);
		List list2 = Arrays.asList(11, 12, 10);
		Stream<Integer> concatStream = Stream.concat(list1.stream(), list2.stream());
		concatStream.forEach(cons);

		/*
		 * perform cube on list elements and filter numbers greater than 50
		 */
		numberlist.stream().map(z -> z * z * z).filter(x -> x > 150).forEach(z -> {
			System.out.println(z);
		});

		/*
		 * map to convert object into Uppercase
		 */
		List charList = Arrays.asList("aria", "bsi", "chia", "dAY");
		ArrayList<String> nameLst = (ArrayList<String>) charList.stream().map(z -> z.toString().toUpperCase())
				.collect(Collectors.toList());
		nameLst.stream().forEachOrdered(z -> {
			System.out.println(z);
		});

		/*
		 * sort and convert opbject into map Collect(collectors.toMap(class::prop) for
		 * duplicate key -> (oldvalue,newvalue)
		 */
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1, "Priya"));
		users.add(new User(5, "riya"));
		users.add(new User(3, "Ariya"));
		users.add(new User(3, "aops"));

		Map usermap = users.stream().sorted(Comparator.comparingInt(User::getId).reversed()).collect(
				Collectors.toMap(User::getId, User::getName, (oldValue, newValue) -> newValue, LinkedHashMap::new));
		System.out.println(usermap);
	}

	public static Consumer<Integer> cons=new Consumer<Integer>(){

	@Override public void accept(Integer t){System.out.println(t);

	}};

	public static Comparator<Integer> intComp = (o1, o2) -> {
		return o1 - o2;
	};

	
	
			
			
			
	public static void summaryStatsExample() {

		List<Integer> intlist = Arrays.asList(2, 34, 21, 18, 23, 23);

		System.out.println("SUMMARY sum :" + intlist.stream().mapToInt(x -> x).distinct().summaryStatistics().getSum());
		
		System.out.println( intlist.stream().mapToInt(x-> x).summaryStatistics().getAverage());

	}

	public static void collectorsgrpingby() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1, "Priya"));
		users.add(new User(5, "riya"));
		users.add(new User(3, "Ariya"));
		users.add(new User(3, "aops"));
		users.add(new User(4, "hello"));
		
		
		
		System.out.println("users hello " +users);
		List<String> al = Arrays.asList("AK","sf","de");
		
		  
	

		Map<Integer, Set<User>> maps = users.stream().collect(Collectors.groupingBy(User::getId,Collectors.toSet()));
		System.out.println(maps);
		
		String s = "HI Hello HI";
		Map ss = ((CharSequence) s).chars().mapToObj(x-> (char) x).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(ss);
	}

	
 
	

}
