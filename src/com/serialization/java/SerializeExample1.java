package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test1 implements Serializable{
	
	int i=10;
	int j=20;
}

class Test2 implements Serializable{
	
	int i=40;
	int j=50;
}

public class SerializeExample1 {

	public static void main(String[] args) throws Exception {
		
		Test1 obj1 = new Test1();
		Test2 obj2 = new Test2();
		
		FileOutputStream fos = new FileOutputStream("xyz.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		oos.writeObject(obj2);
		
		
		FileInputStream fis = new FileInputStream("xyz.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Test1 ob1 = (Test1) ois.readObject();
		Test2 ob2 = (Test2) ois.readObject();
		
		System.out.println(ob1.i+"   "+ob1.j);
		System.out.println(ob2.i+"   "+ob2.j);
		
	}
	
}
