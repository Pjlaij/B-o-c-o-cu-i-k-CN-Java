package Neon.Service.User;

import java.util.HashMap;


import org.springframework.stereotype.Service;

import Neon.DTO.CartDTO;


@Service
public interface iCartService {
	public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart);
	public HashMap<Integer, CartDTO> EditCart(int id,int quantity, HashMap<Integer, CartDTO> cart);
	public HashMap<Integer, CartDTO> DeleteCart(int id, HashMap<Integer, CartDTO> cart);
	public int TotalQuanty(HashMap<Integer, CartDTO> cart);
	public double TotalPrice(HashMap<Integer, CartDTO> cart);
}
