package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	
	int i=10;
	int j=20;
	static int z=44;
	transient int k=15;
	transient static int l = 40;
	transient final int m = 50;
	
	transient String a = "Nik";
//	volatile static int a=100;
//	volatile int b=100;
	
	
}
public class SerializeExample {

	public static void main(String[] args) throws Exception {
		Test ob = new Test();
		
	//Serialization	
		FileOutputStream fos = new FileOutputStream("demofile.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ob);
		
	//De-Serialization	
		FileInputStream fis = new FileInputStream("demofile.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Test ob1 = (Test) ois.readObject();
		
		System.out.println(ob1.i+"......"+ob.j); //10 20
		System.out.println(ob1.k+"....."+ob.i);// 0 10
		System.out.println(ob1.l+"......"+ob.k);//40 0
		System.out.println(ob1.k+"....."+ob.m);//0 50
		System.out.println(ob1.l+"......"+ob.m);//40 50
		
	//	System.out.println(ob1.a+"......"+ob.b);
		
		System.out.println(ob1.a+"......"+ob.i);
		
		//System.out.println(ob1.z);
		
		System.out.println();
	}
}
