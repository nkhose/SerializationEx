package com.serialize.inheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A2 {
	int i = 10;
}

class B2 extends A2 implements Serializable {
	int j = 20;
}

public class SerializeInheritance2 {

public static void main(String[] args) throws Exception {
		
		B2 b1 =new B2();
		//b1.i=100;
	//	b1.j=200;
		
		FileOutputStream fos = new FileOutputStream("file2.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(b1);
		oos.close();
		
		System.out.println("******After Serialization********");
		System.out.println(b1.i);
		System.out.println(b1.j);
		
		FileInputStream fis = new FileInputStream("file2.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		B2 b2 =(B2) ois.readObject();
		ois.close();
		
		System.out.println("\n ******After De-Serialization********");
		System.out.println(b2.i);
		System.out.println(b2.j);
	}
}
