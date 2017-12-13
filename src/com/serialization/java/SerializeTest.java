package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {
	transient int i;

	public A(int i) {
		super();
		this.i = i;
	}
		
}

class B extends A {
	
	int j;

	public B(int i, int j) {
		super(i);
		this.j = j;
	}

}

public class SerializeTest {
public static void main(String[] args) throws Exception {
	
	B b1 = new B(10, 20);
	
	System.out.println("Serialization");
	System.out.println(b1.i);
	System.out.println(b1.j);
	
	
	FileOutputStream fos = new FileOutputStream("test.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(b1);
	
	
	FileInputStream fis = new FileInputStream("test.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	
	B b2 = (B) ois.readObject();
	
	System.out.println("De-Serialization");
	System.out.println(b2.i);
	System.out.println(b2.j);
}

}
