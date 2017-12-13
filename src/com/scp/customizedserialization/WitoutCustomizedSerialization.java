package com.scp.customizedserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class myAccount implements Serializable {
	String userName = "Nikita";
	transient String userPwd = "nikit@";
}

public class WitoutCustomizedSerialization {
	public static void main(String[] args) throws Exception {
		myAccount ob = new myAccount();

		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ob);

		System.out.println("After Serialization:\n");
		System.out.println(ob.userName);
		System.out.println(ob.userPwd);

		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		myAccount ob1 = (myAccount) ois.readObject();

		System.out.println("\nAfter Deserialization:\n");
		System.out.println(ob1.userName);
		System.out.println(ob1.userPwd);

	}
}
