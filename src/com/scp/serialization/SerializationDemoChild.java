package com.scp.serialization;

public class SerializationDemoChild extends SerializationDemoParent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s1_child;
	static String s2_child = "static Child";
	final String s3_child = "final Child";
	final String s4_child;
	final static String s5_child = "static final Child";
	final static String s6_child = "blank final static Child";
	transient String s7_child;
	transient static String s8_child = "transient static Child";
	transient final String s9_child;
	transient final String s10_child = "transient final Child";

	void displayFieldsChild() {

		System.out.println("s1_child \t= " + s1_child + "..........1");
		System.out.println("s2_child \t= " + s2_child + "..........2");
		System.out.println("s3_child \t= " + s3_child + "..........3");
		System.out.println("s4_child \t= " + s4_child + "..........4");
		System.out.println("s5_child \t= " + s5_child + "..........5");
		System.out.println("s6_child \t= " + s6_child + "..........6");
		System.out.println("s7_child \t= " + s7_child + "..........7");
		System.out.println("s8_child \t= " + s8_child + "..........8");
		System.out.println("s9_child \t= " + s9_child + "..........9");
		System.out.println("s10_child \t= " + s10_child + "..........10\n");

		System.out.println("s1 \t= " + s1 + "..........11");
		System.out.println("s2 \t= " + s2 + "..........12");
		System.out.println("s3 \t= " + s3 + "..........13");
		System.out.println("s4 \t= " + s4 + "..........14");
		System.out.println("s5 \t= " + s5 + "..........15");
		System.out.println("s6 \t= " + s6 + "..........16");
		System.out.println("s7 \t= " + s7 + "..........17");
		System.out.println("s8 \t= " + s8 + "..........18");
		System.out.println("s9 \t= " + s9 + "..........19");
		System.out.println("s10 \t= " + s10 + "..........20");
		System.out.println("\n");
	}

	public SerializationDemoChild(String instanceFieldChild, String blankFinalFieldChild, String transientFieldChild,
			String transientBlankFinalFieldChild) {
		super();
		this.s1_child = instanceFieldChild;
		this.s4_child = blankFinalFieldChild;
		this.s7_child = transientFieldChild;
		this.s9_child = transientBlankFinalFieldChild;
	}

	public SerializationDemoChild() {
		this.s4_child = "blank final child";
		this.s9_child = "transient blank final child";
	}

}
