package Neon.DTO;

public class CartDTO {
	private int quanty;
	private double totalPrice;
	private ProductDTO product;
	
	public CartDTO() {
		
	}
	
	public CartDTO(int quanty, double totalPrice, ProductDTO product) {
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	
	public int getQuanty() {
		return quanty;
	}
	
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public ProductDTO getProduct() {
		return product;
	}
	
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
}