package Core;

import java.util.Map;

public interface BarcodeScanner {
	Product ScanBarcode(String Barcode);
	void setDatabase(Map<String, Product> Product_database);
}
