package Core;

public interface Point_Of_Sale {

	void addLogger(Output_Logger logger);
	void handleCode(String code);
	void setBarcodeScanner(BarcodeScanner Scanner);
	
}
