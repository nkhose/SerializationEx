package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Demo implements Serializable{
	
	int i=10;
	int j=20;
}

public class SerializeDemo {

	public static void main(String[] args) throws Exception {
		
		Demo obj1 = new Demo();
		
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Demo obj2 = (Demo) ois.readObject();
		
		System.out.println(obj2.i+"......"+obj1.j);
		
	}
}
