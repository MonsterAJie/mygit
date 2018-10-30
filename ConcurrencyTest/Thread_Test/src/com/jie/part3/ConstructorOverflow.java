package com.jie.part3;

public class ConstructorOverflow {

	public static void main(String[] args) {

		
	}

}

class FinalReferenceEscapeExample {
	final int i;
	static FinalReferenceEscapeExample obj;
	public FinalReferenceEscapeExample() {
		i = 1;
		obj = this;					//thisÒýÓÃ¡°Òç³ö¡±
	}
	public static void writer() {
		new FinalReferenceEscapeExample();
	}
	public static void reader() {
		if (obj != null) {
			int temp = obj.i;
		}
	}
}