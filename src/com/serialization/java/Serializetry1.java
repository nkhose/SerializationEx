package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Demo1 implements Serializable{
	
	transient int i=10;
	int j=20;
}

public class Serializetry1 {
public static void main(String[] args) throws Exception {
		
		Demo1 obj1 = new Demo1();
		
		FileOutputStream fos = new FileOutputStream("abc1.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		
		FileInputStream fis = new FileInputStream("abc1.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Demo1 obj2 = (Demo1) ois.readObject();
		
		System.out.println(obj2.i+"......"+obj1.j);
		
	}
}
