package com.projectinterview;

class A{
	void display() {
		System.out.println("DISPlAY A ");
	}
	void check() {
		System.out.println("CHECK A ");
	}
	
}

class B extends A{
	void display()  {
		System.out.println("DISPlAY B ");
	}
	
	void test() {
		System.out.println("TEST B ");
	}
	
}


public class InhertingMethods {

	public static void main(String[] args) {
		A a = new A();
		a.display();
		a.check();
		

	}

}
