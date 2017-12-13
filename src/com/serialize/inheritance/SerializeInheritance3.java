package com.serialize.inheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A3 {
	int i = 100;
	//transient int x = 50;

	public A3(int i) {

		this.i = i;
	}

	A3() { /// if not write default constructor get InvalidClassException
		i = 200;
	}

	/*@Override
	public String toString() {
		return "A3 [i=" + i + ", x=" + x + "]";
	}*/

}

class B3 extends A3 implements Serializable {
	/*
	 * B3(int i) { super(i); // TODO Auto-generated constructor stub }
	 */

	int j = 20;

/*	@Override
	public String toString() {
		return "B3 [j=" + j + "]";
	}*/

}

public class SerializeInheritance3 {

	public static void main(String[] args) throws Exception {

		B3 b1 = new B3();
		FileOutputStream fos = new FileOutputStream("file4.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(b1);

		System.out.println("******After Serialization********");
		System.out.println(b1.i);
		System.out.println(b1.j);

		FileInputStream fis = new FileInputStream("file4.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		B3 b2 = (B3) ois.readObject();

		System.out.println("\n ******After De-Serialization********");
		System.out.println(b2.i);
		System.out.println(b2.j);
	}

}
