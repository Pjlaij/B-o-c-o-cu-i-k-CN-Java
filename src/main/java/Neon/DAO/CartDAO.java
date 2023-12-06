package Neon.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Neon.DTO.CartDTO;
import Neon.DTO.ProductDTO;
@Repository
public class CartDAO extends BaseDAO{
	
	@Autowired
	ProductDAO productsDao = new ProductDAO();
	
	public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		ProductDTO product = productsDao.FindProductByID(id);
		if(product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty()+1);
			itemCart.setTotalPrice(itemCart.getQuanty()*itemCart.getProduct().getPrice());
		}
		else {
			itemCart.setProduct(product);	
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Integer, CartDTO> EditCart(int id,int quantity, HashMap<Integer, CartDTO> cart) {
		if (cart==null)
			return cart;
		CartDTO itemCart = new CartDTO();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quantity);
			double totalPrice = quantity*itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Integer, CartDTO> DeleteCart(int id, HashMap<Integer, CartDTO> cart) {
		if (cart == null)
			return cart;
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int TotalQuanty(HashMap<Integer, CartDTO> cart) {
		int totalQuanty = 0;
		for (Map.Entry<Integer,CartDTO> itemCart : cart.entrySet()) {
			totalQuanty = totalQuanty + itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}
	
	public double TotalPrice(HashMap<Integer, CartDTO> cart) {
		double totalPrice = 0;
		for (Map.Entry<Integer,CartDTO> itemCart : cart.entrySet()) {
			totalPrice = totalPrice + itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}