package Mock;

import java.util.ArrayList;
import java.util.List;
import Core.BarcodeScanner;
import Core.Output_Logger;
import Core.Point_Of_Sale;
import Core.Product;
import Core.DeviceType;
import Core.Output_Logger;

public class MockPointOfSale implements Point_Of_Sale {
	
	BarcodeScanner codeScanner;	
	List<Output_Logger> outputLoggersList = new ArrayList<Output_Logger>();
	List<Product> scannedProductList = new ArrayList<Product>();
	
	@Override
	public void addLogger(Output_Logger logger) {
		outputLoggersList.add(logger);
	}
 
	@Override
	public void handleCode(String code) {
		
		Product myProduct = codeScanner.ScanBarcode(code);
		if(myProduct != null) {
			scannedProductList.add(myProduct);
		}
		for(Output_Logger logger : outputLoggersList){
			
			if(myProduct != null && logger.getDeviceType() == DeviceType.LCD){
				
				String message = String.format("Name: %s , Price: %s", myProduct.getProductName(), myProduct.getPrice());
				logger.handleOutputLogger(message);
				
			}else if(myProduct == null && !code.equals("exit") && 
						logger.getDeviceType()== DeviceType.LCD){
				System.out.println("Product not found");
			
			}else
				if(code.equals("exit") && logger.getDeviceType()== DeviceType.Printer){
					logger.handleOutputLogger(prepareRecipt());
					logger.handleOutputLogger("Total cost: "+ getTotalCost());
					System.out.println();
			}else
				if(code.equals("exit") && logger.getDeviceType()==DeviceType.LCD){
						logger.handleOutputLogger("Total cost: "+ getTotalCost());
						System.out.println();
					}
		}
		
	}
	
	private String prepareRecipt(){
		StringBuffer buffer = new StringBuffer();
		for(Product p: scannedProductList){
			String str = String.format("Name: %s , Price: %s", p.getProductName(), p.getPrice());
			buffer.append(str);
			buffer.append(System.lineSeparator());
		}
		String totalcost= String.format("Total cost: %s", getTotalCost());
		return buffer.toString();
	}
	
	public double getTotalCost(){
		double result =0;
		for(Product p: scannedProductList){
			result+=p.getPrice();
		}
		return result;
	}
	
	
	
	@Override
	public void setBarcodeScanner(BarcodeScanner Scanner) {
		// TODO Auto-generated method stub
		this.codeScanner=Scanner;
	}

}
