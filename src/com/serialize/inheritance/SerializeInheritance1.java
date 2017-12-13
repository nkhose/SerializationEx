package com.serialize.inheritance;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class AA implements Serializable {
	int i = 10;
}

class BB extends AA {
	int j = 20;
}
public class SerializeInheritance1 {

	public static void main(String[] args) throws Exception {
		
		BB b1 =new BB();
		FileOutputStream fos = new FileOutputStream("file1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(b1);
		
		System.out.println("******After Serialization********");
		System.out.println(b1.i);
		System.out.println(b1.j);
		
		FileInputStream fis = new FileInputStream("file1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		BB b2 =(BB) ois.readObject();
		
		System.out.println("\n ******After De-Serialization********");
		System.out.println(b2.i);
		System.out.println(b2.j);
	}
}
