package Mock;

import Core.Product;

public class MockProduct implements Product {
	
	protected String ProductName;
	protected String Barcode;
	protected double ProductPrice;

	public MockProduct(String code, String name, double price){
		this.Barcode=code;
		this.ProductName=name;
		this.ProductPrice=price;
	}
	
	@Override
	public String getBarCode() {
		// TODO Auto-generated method stub
		return Barcode;
	}

	@Override
	public void setBarCode(String Barcode) {
		// TODO Auto-generated method stub
		this.Barcode=Barcode;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return ProductName;
	}

	@Override
	public void setProductName(String ProductName) {
		// TODO Auto-generated method stub
		this.ProductName=ProductName;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return ProductPrice;
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		this.ProductPrice=price;
	}

}
