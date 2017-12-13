package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class my implements Serializable{
	transient int i=10;
	static int j=10;

}
public class myClass {
public static void main(String[] args) throws Exception{
	
	my obj = new my();
	
	FileOutputStream fos = new FileOutputStream("lmn.ser");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(obj);
	oos.close();
	
	System.out.println("transientintvar= "+ obj.i);
	System.out.println("staticintvar= "+ obj.i);
	
	
	FileInputStream fis = new FileInputStream("lmn.ser");
	ObjectInputStream ois = new ObjectInputStream(fis);
	my obj2 = (my) ois.readObject();
	ois.close();
	
	System.out.println("transientintvar= "+ obj2.i);
	System.out.println("staticintvar= "+ obj2.j);
	
	//System.out.println(obj2.i+"......"+obj.j);
}
}
