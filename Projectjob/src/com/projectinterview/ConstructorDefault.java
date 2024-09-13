package com.projectinterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstructorDefault  {
	public static int age;
	public static String name;
	
	
	
	ConstructorDefault(int memberAge,String memberName){
		  age = memberAge;
		  name = memberName;
	}
	
	
	public static void main(String args[]) {
		ConstructorDefault s = new ConstructorDefault(12, "ashkll");
		System.out.println(age);
		System.out.println(name);
		
		  String txt = "Hello\rWorsdld!";
		    System.out.println(txt);
	
		  
		    
}


	
}