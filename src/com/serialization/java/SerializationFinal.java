package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializeClass implements Serializable {
/*	int intVar = 10;
	static int staticVar = 10;
	transient int transientVar = 10;
	static transient int staticTransientVar = 10;
	final int finalVar = 10;
	final transient int finalTransientVar = 10;
	final static int finalStaticVar = 10;
	
	
	
	final int finalVar2;
	
	
	*/
	
	int intVar = 20;
	static int staticVar = 20;
	transient int transientVar = 20;
	static transient int staticTransientVar = 20;
	final int finalVar = 20;
	final transient int finalTransientVar;
	final static int finalStaticVar = 20;
	
	transient final int transientFinalVar=20;
	
	final int finalVar2;
	
	

/*	//Ser
	 public SerializeClass() { 
	finalVar2 = 10;
	
}*/

	//DSer
	 public SerializeClass() { 
		finalVar2 = 20;
		finalTransientVar=300;
	}

	
}

public class SerializationFinal {

	public static void main(String[] args) throws Exception {

		SerializeClass sobj = new SerializeClass();
	/*	// Serialization
		FileOutputStream fos = new FileOutputStream("Test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(sobj);

		System.out.println("****After Serialization****");
		System.out.println("intVar= " + sobj.intVar);
		System.out.println("staticVar= " + sobj.staticVar);
		System.out.println("transientVar= " + sobj.transientVar);
		System.out.println("staticTransientVar= " + sobj.staticTransientVar);
		System.out.println("finalVar= " + sobj.finalVar);
		System.out.println("finalTransientVar= " + sobj.finalTransientVar);
		System.out.println("finalStaticVar= " + sobj.finalStaticVar);

		System.out.println("finalVar2= " + sobj.finalVar2);

	*/	// De-Serialization
		FileInputStream fis = new FileInputStream("Test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerializeClass sobj2 = (SerializeClass) ois.readObject();

		System.out.println("\n \n**** After De-Serialization****");
		System.out.println("intVar= " + sobj2.intVar);
		System.out.println("staticVar= " + sobj2.staticVar);
		System.out.println("transientVar= " + sobj2.transientVar);
		System.out.println("staticTransientVar= " + sobj2.staticTransientVar);
		System.out.println("finalVar= " + sobj2.finalVar);
		System.out.println("finalTransientVar= " + sobj2.finalTransientVar);
		System.out.println("finalStaticVar= " + sobj2.finalStaticVar);

		System.out.println("finalVar2= " + sobj2.finalVar2);

		
	}

}
