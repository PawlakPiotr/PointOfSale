package Test;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import Core.BarcodeScanner;
import Core.Product;
import Mock.MockBarCodeScanner;
import Mock.MockProduct;
import junit.framework.Assert;

public class MockBarCodeScannerTest {
	
	static Map<String, Product> productDatabase = new HashMap<String, Product>();
	
	/*
	 * 1) Test BarCodeScanner (Product not found)
	 * 2) Test BarCodeScanner (Product found)
	 */
	
	@BeforeClass
	public static void TestSetUp(){
		productDatabase.clear();
		
		//random list of products
		Product myProduct = new MockProduct("42010259", "Sok jabłkowy", 5.99);
		productDatabase.put(myProduct.getBarCode(), myProduct); //put product in HashMap 
		
		myProduct = new MockProduct("17845321", "Jogurt", 3.49);
		productDatabase.put(myProduct.getBarCode(), myProduct);
		myProduct = new MockProduct("12574845", "Woda gazowana", 1.99);
		productDatabase.put(myProduct.getBarCode(), myProduct);
		myProduct = new MockProduct("98996203", "Czekolada", 6.00);
		productDatabase.put(myProduct.getBarCode(), myProduct);
		myProduct = new MockProduct("20036501", "Chleb tostowy", 8.99);
		productDatabase.put(myProduct.getBarCode(), myProduct);
	}
	
	@Test
	public void ProductNotFound(){
		
		//Arrange Test
		BarcodeScanner myScanner = new MockBarCodeScanner();
		myScanner.setDatabase(productDatabase);
		
		//Act Test
		Product resultOfTest = myScanner.ScanBarcode("78456985"); //random code (does not exist in productDatabase)
		
		//Assert Test
		Assert.assertNull(resultOfTest); //null test
		
	}

	@Test 
	public void ProductFound(){

		//Arrange Test
		BarcodeScanner myScanner = new MockBarCodeScanner();
		myScanner.setDatabase(productDatabase);
		
		//Act Test
		Product resultOfTest = myScanner.ScanBarcode("12574845"); //code 12574845 "Woda gazowana" (exist in productDatabse) 
		
		//Assert Test
		Assert.assertNotNull(resultOfTest); // not null test
		
	}
	
}
