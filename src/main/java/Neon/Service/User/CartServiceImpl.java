package Neon.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DAO.CartDAO;
import Neon.DTO.CartDTO;


@Service
public class CartServiceImpl implements iCartService {
	@Autowired
	private CartDAO cartDao = new CartDAO();

	public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart) {
		return cartDao.AddCart(id, cart);
	}


	public HashMap<Integer, CartDTO> EditCart(int id, int quantity, HashMap<Integer, CartDTO> cart) {

		return cartDao.EditCart(id, quantity, cart);
	}


	public HashMap<Integer, CartDTO> DeleteCart(int id, HashMap<Integer, CartDTO> cart) {

		return cartDao.DeleteCart(id, cart);
	}



	public int TotalQuanty(HashMap<Integer, CartDTO> cart) {
		return cartDao.TotalQuanty(cart);
	}



	public double TotalPrice(HashMap<Integer, CartDTO> cart) {
		return cartDao.TotalPrice(cart);
	}




}
