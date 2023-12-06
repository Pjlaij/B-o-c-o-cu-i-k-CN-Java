package Neon.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Neon.DTO.CartDTO;
import Neon.Entity.Bills;

@Service
public interface iBillsService {
	public int AddBills(Bills bill);
	public void AddBillsDetail(HashMap<Long,CartDTO> carts);
}
