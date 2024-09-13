package com.projectinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class functionalInterfaceeg {

	public int age;
	public String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public functionalInterfaceeg(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "functionalInterfaceeg [age=" + age + ", name=" + name + "]";
	}

	public static void main(String args[]) {

		ArrayList<functionalInterfaceeg> list = new ArrayList();
		list.add(new functionalInterfaceeg(1, "akdl"));
		list.add(new functionalInterfaceeg(2, "priya"));
		list.add(new functionalInterfaceeg(3, "akdl"));
		list.add(new functionalInterfaceeg(4, "akdl"));

		System.out.println(list);

		// Predicate - takes in argument returns boolean
		Predicate<functionalInterfaceeg> pred = (functionalInterfaceeg test) -> {
			if (test.getName().equalsIgnoreCase("priya")) {
				return true;
			} else {
				return false;
			}

		};
		
		
		
	
		

		// Consumer -takes in argument does not return anything
		Consumer<functionalInterfaceeg> cons = new Consumer<functionalInterfaceeg>() {

			@Override
			public void accept(functionalInterfaceeg t) {
				System.out.println(t.getAge() + 10);

			}
		};

		// supplier - does not take any input argument but returns something..used for
		// creating objects inside it
		Supplier<functionalInterfaceeg> supp = new Supplier<functionalInterfaceeg>() {

			@Override
			public functionalInterfaceeg get() {
				return new functionalInterfaceeg(7, "maggi");
			}

		};
Function<String, String> funt = new Function<String, String>() {
	
	@Override
	public String apply(String t) {
		// TODO Auto-generated method stub
		return t+" HI";
	}
};

		
		
		for (functionalInterfaceeg fn : list) {
			if (pred.test(fn)) {
				System.out.println(fn);
			}
			cons.accept(fn);

		}
		System.out.println(supp.get());
		System.out.println(funt.apply("priya"));

	}

}
