package Mock;

import java.util.HashMap;
import java.util.Map;
import Core.BarcodeScanner;
import Core.Product;

public class MockBarCodeScanner implements BarcodeScanner{

	Map<String, Product> productDatabase = new HashMap<String,Product>();
	
		@Override
	public void setDatabase(Map<String, Product> Product_database) {
		// TODO Auto-generated method stub
		this.productDatabase=Product_database;
	}

	@Override
	public Product ScanBarcode(String Barcode) {
		Product product = productDatabase.get(Barcode);
		return product;
	}


}
