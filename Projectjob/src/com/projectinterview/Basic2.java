package com.projectinterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// has only one abstract method
@FunctionalInterface
interface Animal {
	int multiply(int s);
}

public class Basic2 {

	public static void main(String args[]) {

		int[] arr1 = { 1, 3, 4, 5 };
		int[] arr2 = { 2, 3, 4, 6, 10, 9 };
		int[] arr3 = { 1, 4, 5, 3, 4 };
		arrayContainsElementsUsingSet(arr1, arr2);
		missingElement();
		lambdaexp();
		hashmapimpl();
		compareArrayValueUsingComparable();
		MapStreamExample();
		// arrayContainsElementsUsingSet(arr1,arr3);
		FlatMapExample();
		grpByExample();

	}

	private static void missingElement() {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13 };
		int n = arr.length;

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < n - 1; i++) {
			set.add(arr[i]);
		}
		for (int i = 1; i <= n - 1; i++) {
			if (!set.contains(i)) {
				System.out.println("Missing element is " + i);
			} else {
				System.out.println("Missing  is " + i);
			}
		}

	}

	public static boolean arrayContainsElementsUsingSet(int[] arr1, int[] arr2) {

		// set removes duplicates
		Set<Object> uniquearr1 = new HashSet<>(Arrays.asList(arr1));
		Set<Object> uniquearr2 = new HashSet<>(Arrays.asList(arr2));

		System.out.println("uniquearr " + uniquearr1);
		System.out.println("uniquearr2 " + uniquearr2.size());

		if (uniquearr1.size() != uniquearr2.size()) {
			// System.out.println("SIZE IS DEIFFERNET SO ARRAY IS DIFFERENT");
			return false;
		}

		for (Object obj : uniquearr1) {
			if (!uniquearr2.contains(obj)) {
				// System.out.println("Array consists of different elements");
				return false;
			}

		}
		return true;

	}

	public static void lambdaexp() {
		Animal a = s -> s*5;
		System.out.println("functional interface" +a.multiply(8));
		
		
		
		
	}

	public static void hashmapimpl() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "s");
		map.put(1, "sk");

		System.out.println(map);

	}

	public static void compareArrayValueUsingComparable() {
		User[] us = new User[3];
		us[0] = new User(2, "arav");
		us[1] = new User(1, "pranav");
		us[2] = new User(5, "manju");

		System.out.println(Arrays.toString(us));
		System.out.println("Array sort normally**************************");

		Arrays.sort(us);

		System.out.println(Arrays.toString(us));
		System.out.println("**************************");

		ArrayList<User> uss = new ArrayList<>();
		uss.add(new User(2, "psk"));
		uss.add(new User(9, "akd"));
		uss.add(new User(7, "tsk"));
		uss.add(new User(1, "ma"));

		System.out.println(uss);
		Collections.sort(uss);
		System.out.println(uss);

		System.out.println("************************** comparator ");
		Collections.sort(uss, User.namecmp);
		System.out.println(uss);
	}

	public static void MapStreamExample() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1, "Priya"));
		users.add(new User(2, "riya"));
		users.add(new User(3, "Ariya"));
		users.add(new User(3, "aops"));
		users.add(new User(3, "aops"));

		List s = users.stream().map(u -> u.getId()).toList();
		
		      Map<Integer, Long> ss = users.stream().collect(Collectors.groupingBy(User::getId,Collectors.counting()));

		System.out.println(s);
		System.out.println("MAP GRPING");
		System.out.println(ss);
	}

	public static void FlatMapExample() {

		ArrayList<Employee> emps = new ArrayList<>();
		ArrayList<String> city1 = new ArrayList<>();
		ArrayList<String> city2 = new ArrayList<>();
		ArrayList<String> city3 = new ArrayList<>();
		city1.add("Chennai");
		city1.add("Noida");
		city2.add("Chennai");
		city2.add("kochi");
		city3.add("banglaore");

		emps.add(new Employee(1, "ANANYA", city1));
		emps.add(new Employee(2, "Karthija", city2));
		emps.add(new Employee(3, "manju", city3));

		System.out.println(emps);

		// flatMap will take value as stream
		// flatmap is used to handle list inside list
		Set cities = (Set) emps.stream().flatMap(emp -> emp.getCities().stream()).collect(Collectors.toSet());

		System.out.println(cities);

	}
	
	
	public static void grpByExample() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1, "Priya"));
		users.add(new User(2, "riya"));
		users.add(new User(3, "Ariya"));
		users.add(new User(3, "aops"));
		users.add(new User(3, "aops"));
		
		//default collectors.grpingby function has collectors.tolisy as second arg..
		Map<String, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getName));
		System.out.println(map);
		List<Integer> s  = users.stream().map(x->x.getId()).toList();
		System.out.println("SMALLEST " +s.stream().sorted().skip(1).limit(1).toList());
		
		/*collect output to a set by defining hashcode and eqauls method in pojo on field which needs to be unique
		 * collect it to a set
		 */
		Map<String, Set<User>>uniquemap = users.stream().collect(Collectors.groupingBy(User::getName,Collectors.toSet()));
		System.out.println(uniquemap);
		
		/* sort the output 
		 * using treemap
		 */
		Map<Integer, Set<User>>uniquemapsorted = users.stream().collect(Collectors.groupingBy(User::getId,TreeMap::new,Collectors.toSet()));
		System.out.println(uniquemapsorted);
	}
}
