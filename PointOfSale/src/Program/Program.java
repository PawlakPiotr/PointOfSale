package Program;

import java.util.HashMap;
import java.util.Map;
import Core.BarcodeScanner;
import Core.Point_Of_Sale;
import Core.Product;
import Mock.MockBarCodeScanner;
import Mock.MockPointOfSale;
import Mock.MockProduct;
import Mock.Mock_LCD_OutputLogger;
import Mock.Mock_Printer_OutputLogger;

public class Program {

	public static void main(String[] args) {
		
		Map<String, Product> myProductDatabase = new HashMap<String, Product>();
		
		Product myNewProduct = new MockProduct("42010259", "Sok jabłkowy", 5.99);
			myProductDatabase.put(myNewProduct.getBarCode(), myNewProduct); 
			
		myNewProduct = new MockProduct("17845321", "Jogurt", 3.49);
			myProductDatabase.put(myNewProduct.getBarCode(), myNewProduct);
		
		myNewProduct = new MockProduct("12574845", "Woda gazowana", 1.99);
			myProductDatabase.put(myNewProduct.getBarCode(), myNewProduct);
		
		myNewProduct = new MockProduct("98996203", "Czekolada", 6.00);
			myProductDatabase.put(myNewProduct.getBarCode(), myNewProduct);
		
		myNewProduct = new MockProduct("20036501", "Chleb tostowy", 8.99);
			myProductDatabase.put(myNewProduct.getBarCode(), myNewProduct);
		
		
		Point_Of_Sale newPointOfSale = new MockPointOfSale();
		BarcodeScanner newScanner = new MockBarCodeScanner();
		
		newScanner.setDatabase(myProductDatabase);
		newPointOfSale.setBarcodeScanner(newScanner);
		
		newPointOfSale.addLogger(new Mock_LCD_OutputLogger());
		newPointOfSale.addLogger(new Mock_Printer_OutputLogger());
		
		newPointOfSale.handleCode("20036501");
		newPointOfSale.handleCode("98996203");
		newPointOfSale.handleCode("42010259");
		newPointOfSale.handleCode("exit");
			
	}

}
