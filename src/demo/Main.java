package demo;

import jaxb.*;

public class Main {
	
	public static void main(String[] args) {
		
		ProductJAXB p = new ProductJAXB();
		//p.marshall();
		//p.unmarshall();
		p.marshallList();
		p.unmarshallList();
	}
}
