package model;

import java.util.Objects;

public class ProductManagement {

	private String id;
	
	private String productName;
	
	private String price;
	
	private String quantityInStock;
	
	private String vendor;
	
	private String waranty;

	@Override
	public int hashCode() {
		return Objects.hash(id, price, productName, quantityInStock, vendor, waranty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductManagement other = (ProductManagement) obj;
		return Objects.equals(id, other.id) && Objects.equals(price, other.price)
				&& Objects.equals(productName, other.productName)
				&& Objects.equals(quantityInStock, other.quantityInStock) && Objects.equals(vendor, other.vendor)
				&& Objects.equals(waranty, other.waranty);
	}

	public ProductManagement(String id, String productName, String price, String quantityInStock, String vendor,
			String waranty) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.vendor = vendor;
		this.waranty = waranty;
	}
	public ProductManagement(String productName, String price, String quantityInStock, String vendor,
			String waranty) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.vendor = vendor;
		this.waranty = waranty;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(String quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getWaranty() {
		return waranty;
	}

	public void setWaranty(String waranty) {
		this.waranty = waranty;
	}

	@Override
	public String toString() {
		return "ProductManagement [id=" + id + ", productName=" + productName + ", price=" + price
				+ ", quantityInStock=" + quantityInStock + ", vendor=" + vendor + ", waranty=" + waranty + "]";
	}


	
	
}
