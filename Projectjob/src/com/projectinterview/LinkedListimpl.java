package com.projectinterview;
import java.util.LinkedList;

public class LinkedListimpl {
  public static void main(String[] args) {
	  ReverseLinkedLIst();
  }
  
  static int index=0;
  
  public static void ReverseLinkedLIst() {
	  LinkedList<Integer> cars = new LinkedList<Integer>();
	  LinkedList<Integer> cars2 = new LinkedList<Integer>();
	    cars.add(1);
	    cars.add(3);
	    cars.add(7);
	    cars.add(9);
	   
	    cars.descendingIterator().forEachRemaining(cars2::add);;
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	    cars.forEach(s -> {});
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	  //  System.out.println(cars);
  }
  
  public static void function1(int s,LinkedList<Integer> cars) {
	//  System.out.println(s);
	 
	 int st = index++;
	 if(st < cars.size()-1) {
		  System.out.println(cars.get(index));
	 }
	
  }
  
}