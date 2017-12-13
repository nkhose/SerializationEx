package com.scp.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemoParent implements Serializable{
	private static final long serialVersionUID = 1L;
	String s1;
	static String s2 = "static";
	final String s3 = "final";
	final String s4;
	final static String s5 = "static final";
	final static String s6 = "blank final static";
	transient String s7;
	transient static String s8 = "transient static";
	transient final String s9;
	transient final String s10 = "transient final";

	public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {

		System.out.println("\n\n*****NOTE");
		System.out.println("\nCompare statements of same number*****\n\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		parentObjectSerialization();
		childObjectSerialization();
	}

	static void parentObjectSerialization() throws IOException, ClassNotFoundException {

		System.out.println("WHEN PARENT'S OBJECT IS SERIALIZED...");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		SerializationDemoParent serializationDemoParent_Out = new SerializationDemoParent("instance", "blank final",
				"transient", "transient blank final");

		System.out.println("\nBefore serialization:");
		System.out.println("---------------------");
		serializationDemoParent_Out.displayFields();
		FileOutputStream fileOut = new FileOutputStream("SerialiazableDemoParentFile.txt");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(serializationDemoParent_Out);
		out.flush();
		out.close();

		SerializationDemoParent serializationDemoParent_In = new SerializationDemoParent();
		FileInputStream fin = new FileInputStream("SerialiazableDemoParentFile.txt");
		ObjectInputStream in = new ObjectInputStream(fin);
		serializationDemoParent_In = (SerializationDemoParent) in.readObject();
		in.close();
		System.out.println("\nAfter de-serialization:");
		System.out.println("---------------------");
		serializationDemoParent_In.displayFields();
		System.out.println(
				"---------------------------------------------------------------------------------------------------\n\n\n");
	}
	
	static void childObjectSerialization() throws IOException, ClassNotFoundException {

		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		System.out.println("WHEN CHILD'S OBJECT IS SERIALIZED...");
		System.out.println(
				"---------------------------------------------------------------------------------------------------\n");

		SerializationDemoChild serializationDemoChild_Out = new SerializationDemoChild("instance Child",
				"blank final Child", "transient Child", "transint blank final Child");
		System.out.println("Before serialization:");
		System.out.println("---------------------");
		serializationDemoChild_Out.displayFieldsChild();
		FileOutputStream fileOutChild = new FileOutputStream("SerialiazableDemoChildFile.txt");
		ObjectOutputStream outChild = new ObjectOutputStream(fileOutChild);
		outChild.writeObject(serializationDemoChild_Out);
		outChild.flush();
		outChild.close();

		SerializationDemoChild serializationDemoChild_In = new SerializationDemoChild();
		FileInputStream finChild = new FileInputStream("SerialiazableDemoChildFile.txt");
		ObjectInputStream inChild = new ObjectInputStream(finChild);
		serializationDemoChild_In = (SerializationDemoChild) inChild.readObject();
		inChild.close();
		System.out.println("\nAfter de-serialization:");
		System.out.println("---------------------");
		serializationDemoChild_In.displayFieldsChild();
	}

	void displayFields() {

		System.out.println("s1 \t= " + s1 + "..........1");
		System.out.println("s2 \t= " + s2 + "..........2");
		System.out.println("s3 \t= " + s3 + "..........3");
		System.out.println("s4 \t= " + s4 + "..........4");
		System.out.println("s5 \t= " + s5 + "..........5");
		System.out.println("s6 \t= " + s6 + "..........6");
		System.out.println("s7 \t= " + s7 + "..........7");
		System.out.println("s8 \t= " + s8 + "..........8");
		System.out.println("s9 \t= " + s9 + "..........9");
		System.out.println("s10 \t=" + s10 + "..........10");
	}

	public SerializationDemoParent(String instanceField, String blankFinalField, String transientField,
			String transientBlankFinalField) {
		super();
		this.s1 = instanceField;
		this.s4 = blankFinalField;
		this.s7 = transientField;
		this.s9 = transientBlankFinalField;
	}

	public SerializationDemoParent() {
		this.s4 = "blank Final";
		this.s9 = "transient blank Final";
	}

}

