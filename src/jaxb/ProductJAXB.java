package jaxb;

import java.util.*;
import javax.xml.bind.*;
import java.io.*;

/**
 * 
 * @author jorge
 * This project was created coping the code of Learning Programming channel.
 * This class provide methods to Marshall and Unmarshall, the first an second method
 * are the only valor and the third and fourth are the List of Products.
 */

public class ProductJAXB {
	
	public void marshall () {
		try {
			Product product = new Product("p1", "Name1", 1000, 2, new Date());
			JAXBContext jc = JAXBContext.newInstance(Product.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(product, System.out);
			ms.marshal(product, new File("src//data//product.xml"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void marshallList () {
		try {
			
			List<Product> listProduct = new ArrayList<Product>();
			listProduct.add(new Product("p1", "Name1", 1000, 2, new Date()));
			listProduct.add(new Product("p2", "Name2", 2000, 3, new Date()));
			listProduct.add(new Product("p3", "Name3", 3000, 4, new Date()));
			
			ListProduct lp = new ListProduct();
			lp.setListProduct(listProduct);
			
			JAXBContext jc = JAXBContext.newInstance(ListProduct.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(lp, System.out);
			ms.marshal(lp, new File("src//data//listproduct.xml"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void unmarshall () {
		try {
			JAXBContext jc = JAXBContext.newInstance(Product.class);
			Unmarshaller ums = jc.createUnmarshaller();
			Product p = (Product) ums.unmarshal(new File("src//data//product.xml"));
			System.out.println("Product Information");
			System.out.println("Id: " + p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Price: " + p.getPrice());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void unmarshallList () {
		try {
			JAXBContext jc = JAXBContext.newInstance(ListProduct.class);
			Unmarshaller ums = jc.createUnmarshaller();
			ListProduct lp = (ListProduct) ums.unmarshal(new File("src//data//listproduct.xml"));
			
			for (Product p: lp.getListProduct()) {
				System.out.println("List Product Information");
				System.out.println("Id: " + p.getId());
				System.out.println("Name: " + p.getName());
				System.out.println("Price: " + p.getPrice());
				System.out.println("===============================");
			}	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
