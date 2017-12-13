package com.scp.customizedserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Account implements Serializable {

	String userName = "Nikita";
	transient String userPassword = "nikit@";

	private void writeObject(ObjectOutputStream os) throws Exception {
		os.defaultWriteObject();
		String password = 123 + userPassword;
		os.writeObject(password);
	}

	private void readObject(ObjectInputStream is) throws Exception {
		is.defaultReadObject();
		String password = (String) is.readObject();
		userPassword = password.substring(3);

	}
}

public class CustomizedSerialization {
	public static void main(String[] args) throws Exception {
		Account a1 = new Account();

		FileOutputStream fos = new FileOutputStream("account.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		System.out.println("After Serialization:\n");
		System.out.println(a1.userName);
		System.out.println(a1.userPassword);

		FileInputStream fis = new FileInputStream("account.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Account a2 = (Account) ois.readObject();
		System.out.println("\nAfter Deserialization:\n");
		System.out.println(a2.userName);
		System.out.println(a2.userPassword);
	}
}
