package bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String pcode;
	private String name;
	private Double price;
	private int qty;
	public ProductBean() {
		super();
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "ProductBean [pcode=" + pcode + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	

}
