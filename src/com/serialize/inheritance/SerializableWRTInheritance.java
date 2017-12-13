package com.serialize.inheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A /*implements Serializable*/ {

	int i=30;
	A(){
	//i=10;	
	}


}

class B extends A implements Serializable  {
	
	int j = 20;
	
}
public class SerializableWRTInheritance {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	A a = new A();
	B d1 = new B();
	//	d1.i = 100;
	//	d1.j = 200;
		
		//Serialization
		
		/*FileOutputStream fos = new FileOutputStream("n.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d1);
		*/
		/*System.out.println("*******After Serialization*******");
		
			
		System.out.println("i= " +d1.i);//30
		System.out.println("j= " +d1.j);//20
		*/
		
		//De-serialization
		
		FileInputStream fis = new FileInputStream("n.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		B d2 = (B) ois.readObject();//DCC
		
		System.out.println("*******After De-Serialization*******");
		
		System.out.println("i= " +d2.i);
		System.out.println("j= " +d2.j);
	}

}
